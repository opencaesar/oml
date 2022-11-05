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
package io.opencaesar.oml.dsl.scoping;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import io.opencaesar.oml.Import;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.dsl.naming.OmlNamespaceImportNormalizer;
import io.opencaesar.oml.util.OmlRead;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

@SuppressWarnings("all")
public class OmlImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
  @Inject
  private IQualifiedNameConverter qnc;

  @Override
  public String getImportedNamespace(final EObject object) {
    String _xifexpression = null;
    if ((object instanceof Import)) {
      _xifexpression = ((Import)object).getPrefix();
    }
    return _xifexpression;
  }

  @Override
  public List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, final boolean ignoreCase) {
    if ((context instanceof Ontology)) {
      final ArrayList<ImportNormalizer> importedNamespaceResolvers = Lists.<ImportNormalizer>newArrayList();
      String _namespace = ((Ontology)context).getNamespace();
      boolean _tripleNotEquals = (_namespace != null);
      if (_tripleNotEquals) {
        QualifiedName _qualifiedName = this.qnc.toQualifiedName(((Ontology)context).getNamespace());
        String _prefix = ((Ontology)context).getPrefix();
        OmlNamespaceImportNormalizer _omlNamespaceImportNormalizer = new OmlNamespaceImportNormalizer(_qualifiedName, _prefix, ignoreCase);
        importedNamespaceResolvers.add(_omlNamespaceImportNormalizer);
      }
      final BiConsumer<String, String> _function = (String namespace, String prefix) -> {
        if (((prefix != null) && (namespace != null))) {
          QualifiedName _qualifiedName_1 = this.qnc.toQualifiedName(namespace);
          OmlNamespaceImportNormalizer _omlNamespaceImportNormalizer_1 = new OmlNamespaceImportNormalizer(_qualifiedName_1, prefix, ignoreCase);
          importedNamespaceResolvers.add(_omlNamespaceImportNormalizer_1);
        }
      };
      OmlRead.getImportPrefixes(((Ontology)context)).forEach(_function);
      return importedNamespaceResolvers;
    }
    return Collections.emptyList();
  }
}
