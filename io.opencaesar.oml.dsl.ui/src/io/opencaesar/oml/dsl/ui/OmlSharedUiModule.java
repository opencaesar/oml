package io.opencaesar.oml.dsl.ui;

import io.opencaesar.oml.dsl.ui.resource.OmlResourceSetInitializer;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;

/**
 * This is used to contribute to shared xtext UI resources
 */
@SuppressWarnings("all")
public class OmlSharedUiModule extends AbstractGenericModule {

	public Class<? extends IResourceSetInitializer> bindIResourceSetInitializer() {
		return OmlResourceSetInitializer.class;
	}
}
