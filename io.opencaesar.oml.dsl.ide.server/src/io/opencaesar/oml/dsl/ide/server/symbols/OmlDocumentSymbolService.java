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
package io.opencaesar.oml.dsl.ide.server.symbols;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Location;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class OmlDocumentSymbolService extends DocumentSymbolService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;

  @Inject
  private EObjectAtOffsetHelper helper;

  @Override
  public List<? extends Location> getDefinitions(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    TextRegion _textRegion = new TextRegion(offset, 0);
    final INode node = this.helper.getCrossReferenceNode(resource, _textRegion);
    if ((node != null)) {
      final EObject element = this.helper.getCrossReferencedElement(node);
      if ((element != null)) {
        Location _newFullLocation = this._documentExtensions.newFullLocation(element);
        return Collections.<Location>unmodifiableList(CollectionLiterals.<Location>newArrayList(_newFullLocation));
      }
    }
    return CollectionLiterals.<Location>emptyList();
  }
}
