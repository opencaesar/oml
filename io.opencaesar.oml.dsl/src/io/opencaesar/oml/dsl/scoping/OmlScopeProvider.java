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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;

import io.opencaesar.oml.Entity;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.SpecializableTerm;

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
		if (reference == OmlPackage.Literals.SPECIALIZATION_AXIOM__SUPER_TERM) {
			return getScopeForSpecializationAxiom_SpecializedTerm(context, reference);
		}
		return super.getScope(context, reference);
	}

	private IScope getScopeForSpecializationAxiom_SpecializedTerm(final EObject context, final EReference reference) {
		IScope superScope = super.getScope(context, reference);
		if ((context instanceof Entity)) {
			return new FilteringScope(superScope, a -> {
				return ((!EcoreUtil.getURI(context).equals(a.getEObjectURI())) && 
						((((Entity) context).eClass() == a.getEClass()) || (OmlPackage.Literals.ASPECT == a.getEClass())));
			});
		} else if ((context instanceof SpecializableTerm)) {
			return new FilteringScope(superScope, a -> {
				return ((!EcoreUtil.getURI(context).equals(a.getEObjectURI())) && 
						(((SpecializableTerm) context).eClass() == a.getEClass()));
			});
		}
		return superScope;
	}
}
