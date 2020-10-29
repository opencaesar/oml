/**
 * 
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package io.opencaesar.oml.dsl.ide.launch;

import com.google.gson.GsonBuilder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.Logger;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup;
import org.eclipse.sprotty.xtext.launch.DiagramServerSocketLauncher;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("all")
public class OmlRunSocketServer extends DiagramServerSocketLauncher {
  private static final Logger LOG = Logger.getLogger(OmlRunSocketServer.class);

  @Override
  public DiagramLanguageServerSetup createSetup() {
    return new OmlLanguageServerSetup();
  }
  
  public static void main(final String... args) {
    new OmlRunSocketServer().run(args);
  }

  // This override should be unnecessary; however, there are some weird exceptions that hit the catch clause.
  // In the parent class, such exceptions would be simply printed; e.g., t.printStackTrace().
  // Unfortunately, this in turn leads to opaque errors like this:
  // 
  // Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 12143 out of bounds for length 2090
  // 
  @Override
  public void run(final String... args) {
    try {
      final DiagramLanguageServerSetup setup = this.createSetup();
      setup.setupLanguages();
      final Injector injector = Guice.createInjector(setup.getLanguageServerModule());
      
      // This is done in org.eclipse.sprotty.xtext.launch.DiagramServerLauncher but 
      // *NOT* in org.eclipse.sprotty.xtext.launch.DiagramServerSocketLauncher
      injector.injectMembers(this);
      
      final AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress("0.0.0.0", getPort(args)));
      while (true) {
        {
          final AsynchronousSocketChannel socketChannel = serverSocket.accept().get();
          final InputStream in = Channels.newInputStream(socketChannel);
          final OutputStream out = Channels.newOutputStream(socketChannel);
          final LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
          final ExecutorService executorService = Executors.newCachedThreadPool();
          final Launcher<? extends LanguageClient> launcher = Launcher.createIoLauncher(languageServer, setup.getLanguageClientClass(), in, out, executorService, (MessageConsumer mc) -> mc, (GsonBuilder gb) -> setup.configureGson(gb));
          languageServer.connect(launcher.getRemoteProxy());
          launcher.startListening();
          SocketAddress remote = socketChannel.getRemoteAddress();
          LOG.info("Started language server for client " + remote);
        }
      }
    } catch (final Throwable t) {
      // The parent catch prints each frame and this in turn can lead to more exceptions.
      t.fillInStackTrace();
      StackTraceElement[] traces = t.getStackTrace();
      for (StackTraceElement frame : traces) {
        LOG.error(frame.getClassName() + "." + frame.getMethodName() + " @ " + frame.getLineNumber());
      }
    }
  }
}
