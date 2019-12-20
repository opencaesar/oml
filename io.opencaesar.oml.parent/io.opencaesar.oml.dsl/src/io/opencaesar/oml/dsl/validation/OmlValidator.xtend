/**
 * 
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
 * 
 */
package io.opencaesar.oml.dsl.validation

import io.opencaesar.oml.Bundle
import io.opencaesar.oml.BundleExtension
import io.opencaesar.oml.BundleInclusion
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.Member
import io.opencaesar.oml.OmlPackage
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyExtension
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ValidationMessageAcceptor

import static extension io.opencaesar.oml.util.OmlRead.*
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.Terminology

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class OmlValidator extends AbstractOmlValidator {
	
	@Check def void checkVocabularyExtension_URL(VocabularyExtension _extension) {
		if (!(_extension.importedOntology instanceof Vocabulary)) {
			error("Couldn't resolve this URL to a vocabulary", OmlPackage.Literals::IMPORT__URI,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, "INVALID_VOCABULARY_EXTENSION_URL", _extension.uri)
		}
	}

	@Check def void checkBundleExtension_URL(BundleExtension _extension) {
		if (!(_extension.importedOntology instanceof Bundle)) {
			error("Couldn't resolve this URL to a bundle", OmlPackage.Literals::IMPORT__URI,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, "INVALID_BUNDLE_EXTENSION_URL", _extension.uri)
		}
	}

	@Check def void checkBundleInclusion_URL(BundleInclusion inclusion) {
		if (!(inclusion.importedOntology instanceof Vocabulary)) {
			error("Couldn't resolve this URL to a vocabulary", OmlPackage.Literals::IMPORT__URI,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, "INVALID_BUNDLE_INCLUSION_URL", inclusion.uri)
		}
	}

	@Check def void checkDescriptionExtension_URL(DescriptionExtension _extension) {
		if (!(_extension.importedOntology instanceof Description)) {
			error("Couldn't resolve this URL to a description", OmlPackage.Literals::IMPORT__URI,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, "INVALID_DESCRIPTION_EXTENSION_URL", _extension.uri)
		}
	}

	@Check def void checkBundleInclusion_URL(DescriptionUsage usage) {
		if (!(usage.importedOntology instanceof Terminology)) {
			error("Couldn't resolve this URL to a vocabulary or bundle", OmlPackage.Literals::IMPORT__URI,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, "INVALID_DESCRIPTION_USAGE_URL", usage.uri)
		}
	}

	@Check def void checkMember_Name(Member member) {
		if (member.ontology.members.exists[it !== member && it.name == member.name]) {
			error("Found a duplicate ontology member name", OmlPackage.Literals::MEMBER__NAME,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, "INVALID_MEMBER_NAME", member.name)
		}
	}

}
