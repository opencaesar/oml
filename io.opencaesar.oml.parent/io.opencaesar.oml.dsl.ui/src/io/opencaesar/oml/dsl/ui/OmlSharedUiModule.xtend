package io.opencaesar.oml.dsl.ui

import io.opencaesar.oml.dsl.ui.resource.OmlResourceSetInitializer
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.ui.resource.IResourceSetInitializer

/*
 * This is used by to contribute to shared xtext UI resources 
 */
class OmlSharedUiModule extends AbstractGenericModule {
	
	def Class<? extends IResourceSetInitializer> bindIResourceSetInitializer() {
		OmlResourceSetInitializer
	}
	
}