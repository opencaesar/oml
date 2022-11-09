/**
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
 */
package io.opencaesar.oml.dsl.ide.diagram.launch;

import com.google.gson.GsonBuilder;
import com.google.inject.Binder;
import io.opencaesar.oml.dsl.ide.diagram.FilterAction;
import io.opencaesar.oml.dsl.resource.OmlSynchronizedXtextResourceSet;
import java.util.Map;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.core.util.persistence.ElkGraphResourceFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sprotty.layout.ElkLayoutEngine;
import org.eclipse.sprotty.server.json.ActionTypeAdapter;
import org.eclipse.sprotty.server.json.EnumTypeAdapter;
import org.eclipse.sprotty.xtext.EditActionTypeAdapterFactory;
import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup;
import org.eclipse.sprotty.xtext.ls.SyncDiagramServerModule;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.Modules2;

@SuppressWarnings("all")
public class OmlLanguageServerSetup extends DiagramLanguageServerSetup {
  @Override
  public void setupLanguages() {
    LayeredMetaDataProvider _layeredMetaDataProvider = new LayeredMetaDataProvider();
    ElkLayoutEngine.initialize(_layeredMetaDataProvider);
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    ElkGraphResourceFactory _elkGraphResourceFactory = new ElkGraphResourceFactory();
    _extensionToFactoryMap.put("elkg", _elkGraphResourceFactory);
  }

  @Override
  public GsonBuilder configureGson(final GsonBuilder gsonBuilder) {
    GsonBuilder _xblockexpression = null;
    {
      final ActionTypeAdapter.Factory factory = new ActionTypeAdapter.Factory();
      factory.addActionKind(FilterAction.KIND, FilterAction.class);
      GsonBuilder _registerTypeAdapterFactory = gsonBuilder.registerTypeAdapterFactory(factory);
      EditActionTypeAdapterFactory _editActionTypeAdapterFactory = new EditActionTypeAdapterFactory();
      GsonBuilder _registerTypeAdapterFactory_1 = _registerTypeAdapterFactory.registerTypeAdapterFactory(_editActionTypeAdapterFactory);
      EnumTypeAdapter.Factory _factory = new EnumTypeAdapter.Factory();
      _xblockexpression = _registerTypeAdapterFactory_1.registerTypeAdapterFactory(_factory);
    }
    return _xblockexpression;
  }

  @Override
  public com.google.inject.Module getLanguageServerModule() {
    ServerModule _serverModule = new ServerModule();
    SyncDiagramServerModule _syncDiagramServerModule = new SyncDiagramServerModule();
    final com.google.inject.Module _function = (Binder it) -> {
      it.<XtextResourceSet>bind(XtextResourceSet.class).to(OmlSynchronizedXtextResourceSet.class);
    };
    return Modules2.mixin(_serverModule, _syncDiagramServerModule, _function);
  }
}
