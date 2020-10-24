package io.opencaesar.oml.dsl.resource

import com.google.inject.Provider
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet
import org.eclipse.xtext.resource.XtextResourceSet

class OmlXtextResourceSetProvider implements Provider<XtextResourceSet> {
	
	override get() {
		val rs = new SynchronizedXtextResourceSet
		rs.eAdapters().add(new ECrossReferenceAdapter)
		return rs
	}
}