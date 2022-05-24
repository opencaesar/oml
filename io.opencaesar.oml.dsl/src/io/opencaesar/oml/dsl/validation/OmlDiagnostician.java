package io.opencaesar.oml.dsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.CancelableDiagnostician;

import com.google.inject.Inject;

import io.opencaesar.oml.Member;
import io.opencaesar.oml.Ontology;

public class OmlDiagnostician extends CancelableDiagnostician {

	@Inject
	public OmlDiagnostician(Registry registry) {
		super(registry);
	}

	@Override
	public String getObjectLabel(EObject eObject) {
		String type = eObject.eClass().getName();
		String name = "";
		if (eObject.eIsProxy()) {
			return "";
		} else if (eObject instanceof Member) {
			name = ((Member)eObject).getAbbreviatedIri();
		} else if (eObject instanceof Ontology) {
	    	name = ((Ontology)eObject).getNamespace();
	    }
	    return type + (name.length()>0 ? " "+name : "");
	}
	
}
