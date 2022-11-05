/**
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License")
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

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import io.opencaesar.oml.Entity;
import io.opencaesar.oml.EnumeratedScalar;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.SpecializableTerm;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;

/**
 * This class contains custom scoping description.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class OmlScopeProvider extends AbstractOmlScopeProvider {
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    boolean _equals = Objects.equal(reference, OmlPackage.Literals.SPECIALIZATION_AXIOM__SPECIALIZED_TERM);
    if (_equals) {
      return this.getScopeForSpecializationAxiom_SpecializedTerm(context, reference);
    }
    return super.getScope(context, reference);
  }

  private IScope getScopeForSpecializationAxiom_SpecializedTerm(final EObject context, final EReference reference) {
    IScope superScope = super.getScope(context, reference);
    if ((context instanceof Entity)) {
      final Predicate<IEObjectDescription> _function = (IEObjectDescription a) -> {
        return ((!EcoreUtil.getURI(context).equals(a.getEObjectURI())) && ((((Entity)context).eClass() == a.getEClass()) || 
          (OmlPackage.Literals.ASPECT == a.getEClass())));
      };
      return new FilteringScope(superScope, _function);
    } else {
      if ((context instanceof EnumeratedScalar)) {
        final Predicate<IEObjectDescription> _function_1 = (IEObjectDescription a) -> {
          return ((!EcoreUtil.getURI(context).equals(a.getEObjectURI())) && ((((EnumeratedScalar)context).eClass() == a.getEClass()) || 
            (OmlPackage.Literals.FACETED_SCALAR == a.getEClass())));
        };
        return new FilteringScope(superScope, _function_1);
      } else {
        if ((context instanceof SpecializableTerm)) {
          final Predicate<IEObjectDescription> _function_2 = (IEObjectDescription a) -> {
            return ((!EcoreUtil.getURI(context).equals(a.getEObjectURI())) && 
              Objects.equal(((SpecializableTerm)context).eClass(), a.getEClass()));
          };
          return new FilteringScope(superScope, _function_2);
        }
      }
    }
    return superScope;
  }
}
