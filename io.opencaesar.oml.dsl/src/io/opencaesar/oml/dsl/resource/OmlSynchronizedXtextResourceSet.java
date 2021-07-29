package io.opencaesar.oml.dsl.resource;

import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;

public class OmlSynchronizedXtextResourceSet extends SynchronizedXtextResourceSet {

	public OmlSynchronizedXtextResourceSet() {
		super();
		eAdapters().add(new ECrossReferenceAdapter());
	}

}
