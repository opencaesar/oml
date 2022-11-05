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
package io.opencaesar.oml.dsl.ide.diagram;

import com.google.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sprotty.IDiagramServer;
import org.eclipse.sprotty.IPopupModelFactory;
import org.eclipse.sprotty.RequestPopupModelAction;
import org.eclipse.sprotty.SModelElement;
import org.eclipse.sprotty.SModelRoot;
import org.eclipse.sprotty.xtext.ILanguageAwareDiagramServer;
import org.eclipse.sprotty.xtext.tracing.ITraceProvider;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class OmlPopupModelFactory implements IPopupModelFactory {
  @Inject
  @Extension
  private ITraceProvider _iTraceProvider;

  @Override
  public SModelRoot createPopupModel(final SModelElement element, final RequestPopupModelAction request, final IDiagramServer server) {
    try {
      SModelRoot _xifexpression = null;
      String _trace = element.getTrace();
      boolean _tripleNotEquals = (_trace != null);
      if (_tripleNotEquals) {
        SModelRoot _xblockexpression = null;
        {
          final BiFunction<EObject, ILanguageServerAccess.Context, SModelRoot> _function = (EObject statement, ILanguageServerAccess.Context context) -> {
            return null;
          };
          final CompletableFuture<SModelRoot> future = this._iTraceProvider.<SModelRoot>withSource(element, ((ILanguageAwareDiagramServer) server), _function);
          _xblockexpression = future.get();
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
