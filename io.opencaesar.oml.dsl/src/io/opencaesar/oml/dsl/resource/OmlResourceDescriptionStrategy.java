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
package io.opencaesar.oml.dsl.resource;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.Ontology;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class OmlResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
  @Override
  public boolean createEObjectDescriptions(final EObject eObject, final IAcceptor<IEObjectDescription> acceptor) {
    if ((eObject instanceof Ontology)) {
      final QualifiedName qualifiedName = this.getQualifiedNameProvider().getFullyQualifiedName(eObject);
      if ((qualifiedName != null)) {
        String _namespace = ((Ontology)eObject).getOntology().getNamespace();
        Pair<String, String> _mappedTo = Pair.<String, String>of("namespace", _namespace);
        String _prefix = ((Ontology)eObject).getOntology().getPrefix();
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of("prefix", _prefix);
        acceptor.accept(EObjectDescription.create(qualifiedName, eObject, CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
      }
      return true;
    } else {
      if ((eObject instanceof Member)) {
        final QualifiedName qualifiedName_1 = this.getQualifiedNameProvider().getFullyQualifiedName(eObject);
        if ((qualifiedName_1 != null)) {
          String _prefix_1 = ((Member)eObject).getOntology().getPrefix();
          Pair<String, String> _mappedTo_2 = Pair.<String, String>of("defaultPrefix", _prefix_1);
          acceptor.accept(EObjectDescription.create(qualifiedName_1, eObject, CollectionLiterals.<String, String>newHashMap(_mappedTo_2)));
        }
        return true;
      }
    }
    return false;
  }
}
