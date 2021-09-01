package io.opencaesar.oml.dsl.ui.resource

import io.opencaesar.oml.util.OmlCrossReferenceAdapter
import org.eclipse.core.resources.IProject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter
import org.eclipse.xtext.ui.resource.IResourceSetInitializer

/*
 * This is used to install the ECrossReferenceAdapter (if not there) on resource set used by Xtext Builder
 * The builder uses a shared resource set for all xtext resources in a project
 */
class OmlResourceSetInitializer implements IResourceSetInitializer {
		
	override initialize(ResourceSet resourceSet, IProject project) {
		val adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet)	
		if (adapter === null) {
			resourceSet.eAdapters().add(new OmlCrossReferenceAdapter)
		}
	}
		
}