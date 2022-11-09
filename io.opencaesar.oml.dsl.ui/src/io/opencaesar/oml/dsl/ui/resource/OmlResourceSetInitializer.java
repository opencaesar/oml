/**
 * 
 * Copyright 2019-2021 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.dsl.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;

/**
 * This is used to install the ECrossReferenceAdapter (if not there) on resource
 * set used by Xtext Builder The builder uses a shared resource set for all
 * xtext resources in a project
 */
@SuppressWarnings("all")
public class OmlResourceSetInitializer implements IResourceSetInitializer {

	@Override
	public void initialize(final ResourceSet resourceSet, final IProject project) {
		final var adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if (adapter == null) {
			resourceSet.eAdapters().add(new ECrossReferenceAdapter());
		}
	}
}
