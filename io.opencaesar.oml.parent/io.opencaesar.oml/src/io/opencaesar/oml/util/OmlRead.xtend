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
package io.opencaesar.oml.util

import io.opencaesar.oml.AnnotatedElement
import io.opencaesar.oml.Annotation
import io.opencaesar.oml.AnnotationPropertyReference
import io.opencaesar.oml.AspectReference
import io.opencaesar.oml.Assertion
import io.opencaesar.oml.BooleanLiteral
import io.opencaesar.oml.Classifier
import io.opencaesar.oml.ConceptInstance
import io.opencaesar.oml.ConceptInstanceReference
import io.opencaesar.oml.ConceptReference
import io.opencaesar.oml.ConceptTypeAssertion
import io.opencaesar.oml.DecimalLiteral
import io.opencaesar.oml.Description
import io.opencaesar.oml.DescriptionBox
import io.opencaesar.oml.DescriptionBundle
import io.opencaesar.oml.DescriptionBundleExtension
import io.opencaesar.oml.DescriptionBundleImport
import io.opencaesar.oml.DescriptionBundleInclusion
import io.opencaesar.oml.DescriptionBundleUsage
import io.opencaesar.oml.DescriptionExtension
import io.opencaesar.oml.DescriptionImport
import io.opencaesar.oml.DescriptionStatement
import io.opencaesar.oml.DescriptionUsage
import io.opencaesar.oml.DoubleLiteral
import io.opencaesar.oml.Element
import io.opencaesar.oml.Entity
import io.opencaesar.oml.EnumeratedScalarReference
import io.opencaesar.oml.FacetedScalarReference
import io.opencaesar.oml.ForwardRelation
import io.opencaesar.oml.IdentifiedElement
import io.opencaesar.oml.Import
import io.opencaesar.oml.Instance
import io.opencaesar.oml.IntegerLiteral
import io.opencaesar.oml.KeyAxiom
import io.opencaesar.oml.LinkAssertion
import io.opencaesar.oml.Member
import io.opencaesar.oml.NamedInstance
import io.opencaesar.oml.Ontology
import io.opencaesar.oml.Property
import io.opencaesar.oml.PropertyRestrictionAxiom
import io.opencaesar.oml.PropertyValueAssertion
import io.opencaesar.oml.QuotedLiteral
import io.opencaesar.oml.Reference
import io.opencaesar.oml.Relation
import io.opencaesar.oml.RelationEntity
import io.opencaesar.oml.RelationEntityReference
import io.opencaesar.oml.RelationInstance
import io.opencaesar.oml.RelationInstanceReference
import io.opencaesar.oml.RelationReference
import io.opencaesar.oml.RelationRestrictionAxiom
import io.opencaesar.oml.RelationTypeAssertion
import io.opencaesar.oml.RestrictionAxiom
import io.opencaesar.oml.ReverseRelation
import io.opencaesar.oml.RuleReference
import io.opencaesar.oml.Scalar
import io.opencaesar.oml.ScalarProperty
import io.opencaesar.oml.ScalarPropertyReference
import io.opencaesar.oml.ScalarPropertyRestrictionAxiom
import io.opencaesar.oml.ScalarPropertyValueAssertion
import io.opencaesar.oml.SpecializableTerm
import io.opencaesar.oml.SpecializableTermReference
import io.opencaesar.oml.SpecializationAxiom
import io.opencaesar.oml.Statement
import io.opencaesar.oml.Structure
import io.opencaesar.oml.StructureReference
import io.opencaesar.oml.StructuredProperty
import io.opencaesar.oml.StructuredPropertyReference
import io.opencaesar.oml.StructuredPropertyRestrictionAxiom
import io.opencaesar.oml.StructuredPropertyValueAssertion
import io.opencaesar.oml.Term
import io.opencaesar.oml.TypeAssertion
import io.opencaesar.oml.Vocabulary
import io.opencaesar.oml.VocabularyBox
import io.opencaesar.oml.VocabularyBundle
import io.opencaesar.oml.VocabularyBundleExtension
import io.opencaesar.oml.VocabularyBundleImport
import io.opencaesar.oml.VocabularyBundleInclusion
import io.opencaesar.oml.VocabularyExtension
import io.opencaesar.oml.VocabularyImport
import io.opencaesar.oml.VocabularyStatement
import io.opencaesar.oml.VocabularyUsage
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.Map
import java.util.Set
import java.util.regex.Pattern
import org.eclipse.core.runtime.FileLocator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import java.net.MalformedURLException
import java.nio.file.Paths
import java.io.IOException

class OmlRead {
	
	static val CATALOGS = 'Catalogs'
	static val OML_EXTENSION = "oml"
	
	// closure operators
	
	static def <T, V extends T> Iterable<T> closure(V v, (T)=>Iterable<T> f) {
		val allResults = new LinkedHashSet<T>
		closure(v, f, allResults)
		allResults
	}

	static def <T, V extends T> Iterable<T> reflexiveClosure(V v, (T)=>Iterable<T> f) {
		val allResults = new LinkedHashSet<T>
		allResults += v
		closure(v, f, allResults)
		allResults
	}

	static def <T, V extends T> Iterable<T> reflexiveClosure(Iterable<V> v, (T)=>Iterable<T> f) {
		val allResults = new LinkedHashSet<T>
		allResults += v
		v.forEach[closure(it, f, allResults)]
		allResults
	}

	protected static def <T, V extends T> void closure(V v, (T)=>Iterable<T> f, Set<T> allResults) {
		var results = f.apply(v) ?: Collections.emptyList
		results = results.filterNull.filter[r|!allResults.contains(r)].toList
		allResults += results
		results.forEach[r|r.closure(f, allResults)]
	}

	// ResourceSet
	
	static def Element getElementWithIri(ResourceSet resourceSet, String iri) {
		for (resource : resourceSet.resources) {
			val found = resource.getElementWithIri(iri)
			if (found !== null)
				return found
		}
		return null
	}
	
	static def Iterable<Ontology> getOntologies(ResourceSet resourceSet) {
		resourceSet.resources.flatMap[contents].filter(Ontology)
	}

	// Resource
	
	static def Element getElementWithIri(Resource resource, String iri) {
		val ontology = resource.ontology
		if (ontology !== null) {
			if (iri == ontology.iri) {
				return ontology
			} else if (iri.startsWith(ontology.iri)) {
				val name = iri.substring(ontology.iri.length+1)
				return ontology.members.findFirst[it.name == name]
			}
		}
	}

	static def Ontology getOntology(Resource resource) {
		resource.contents.filter(Ontology).head
	}
	
	// Element
	
	static def Ontology getOntology(Element element) {
		var EObject current = element
		while (current !== null && !(current instanceof Ontology)) {
			current = current.eContainer
		}
		current as Ontology
	}
	
	static def getId(Element element) {
		EcoreUtil.getID(element)
	}
	
	// Annotation
	
	static def AnnotatedElement getAnnotatedElement(Annotation annotation) {
		if (annotation.owningReference !== null) {
			annotation.owningReference.resolve
		} else {
			annotation.owningElement
		}
	}
	
	// AnnotatedElement
	
	static def getAnnotationValues(AnnotatedElement element, String annotationPropertyIri) {
		element.ownedAnnotations.filter[property.iri == annotationPropertyIri].map[value]
	}
	
	static def getAnnotationValue(AnnotatedElement element, String annotationPropertyIri) {
		element.getAnnotationValues(annotationPropertyIri)?.head
	}

	static def getAnnotationLexicalValue(AnnotatedElement element, String annotationPropertyIri) {
		element.getAnnotationValue(annotationPropertyIri)?.lexicalValue
	}

	// IdentifiedElement
	
	static dispatch def String getIri(IdentifiedElement element) {
	}

	static dispatch def String getAbbreviatedIri(IdentifiedElement element) {
	}

	static dispatch def String getNameIn(IdentifiedElement element, Ontology ontology) {
	}
	
	// Ontology
	
	static dispatch def String getIri(Ontology ontology) {
		ontology.iri
	}

	static dispatch def String getAbbreviatedIri(Ontology element) {
		element.prefix
	}

	static dispatch def String getNameIn(Ontology element, Ontology ontology) {
		if (element === ontology) {
			element.prefix
		} else {
			ontology.importPrefixes.get(element.namespace)
		}
	}

	static def String getNamespace(Ontology ontology) {
		ontology.iri+ontology.separator
	}

	static dispatch def Iterable<Statement> getStatements(Ontology ontology) {
		Collections.EMPTY_LIST
	}

	static dispatch def Iterable<Member> getMembers(Ontology ontology) {
		ontology.statements.filter(Member)
	}

	static def Iterable<Reference> getReferences(Ontology ontology) {
		ontology.statements.filter(Reference)
	}
	
	static dispatch def Iterable<Import> getImportsWithSource(Ontology ontology) {
		Collections.EMPTY_LIST
	}

	static def Iterable<Import> getAllImportsWithSource(Ontology ontology) {
		val allImports = new ArrayList<Import>
		allImports += ontology.importsWithSource.reflexiveClosure[importedOntology?.importsWithSource]
		allImports
	}

	static def Ontology getImportedOntologyByIri(Ontology importingOntology, String importedIri) {
		for (^import : importingOntology.allImportsWithSource) {
			if (^import.importedOntology?.iri == importedIri) {
				return ^import.importedOntology
			}
		}
		return null
	}
	
	static def Iterable<Ontology> getImportedOntologies(Ontology ontology) {
		ontology.importsWithSource.map[importedOntology]
	}

	static def Map<String, String> getImportPrefixes(Ontology ontology) {
		val namespaces = new LinkedHashMap<String, String>
		ontology.allImportsWithSource.forEach[i|
			if (!namespaces.containsKey(i.importNamespace)) {
				namespaces.put(i.importNamespace, i.importPrefix)
			}
		]
		namespaces
	}

	// VocabularyBox

	// Vocabulary
	
	static dispatch def Iterable<Import> getImportsWithSource(Vocabulary ontology) {
		ontology.ownedImports.filter(Import)
	}

	static def Iterable<VocabularyExtension> getExtensionsWithSource(Vocabulary vocabulary) {
		vocabulary.ownedImports.filter(VocabularyExtension)
	}

	static def Iterable<VocabularyUsage> getUsagesWithSource(Vocabulary vocabulary) {
		vocabulary.ownedImports.filter(VocabularyUsage)
	}

	static def Iterable<Vocabulary> getExtendedVocabularies(Vocabulary vocabulary) {
		vocabulary.extensionsWithSource.map[extendedVocabulary]
	}

	static def Iterable<DescriptionBox> getUsedDescriptionBoxes(Vocabulary vocabulary) {
		vocabulary.usagesWithSource.map[usedDescriptionBox]
	}

	static dispatch def Iterable<Statement> getStatements(Vocabulary ontology) {
		ontology.ownedStatements.filter(Statement)
	}

	static dispatch def Iterable<Member> getMembers(Vocabulary ontology) {
		val members = new ArrayList<Member>
		members += ontology.ownedStatements.filter(Member)
		members += ontology.ownedStatements.filter(RelationEntity).flatMap[relations]
		members
	}

	// VocabularyBundle

	static dispatch def Iterable<Import> getImportsWithSource(VocabularyBundle ontology) {
		ontology.ownedImports.filter(Import)
	}

	static def Iterable<VocabularyBundleExtension> getExtensionsWithSource(VocabularyBundle bundle) {
		bundle.ownedImports.filter(VocabularyBundleExtension)
	}

	static def Iterable<VocabularyBundleInclusion> getInclusionsWithSource(VocabularyBundle bundle) {
		bundle.ownedImports.filter(VocabularyBundleInclusion)
	}

	static def Iterable<VocabularyBundle> getExtendedVocabularyBundles(VocabularyBundle bundle) {
		bundle.extensionsWithSource.map[extendedVocabularyBundle]
	}

	static def Iterable<Vocabulary> getIncludedVocabularies(VocabularyBundle bundle) {
		bundle.inclusionsWithSource.map[includedVocabulary]
	}

	// DescriptionBox

	// Description

	static dispatch def Iterable<Import> getImportsWithSource(Description ontology) {
		ontology.ownedImports.filter(Import)
	}

	static def Iterable<DescriptionUsage> getUsagesWithSource(Description description) {
		description.ownedImports.filter(DescriptionUsage)
	}

	static def Iterable<DescriptionExtension> getExtensionsWithSource(Description description) {
		description.ownedImports.filter(DescriptionExtension)
	}

	static def Iterable<Description> getExtendedDescriptions(Description description) {
		description.extensionsWithSource.map[extendedDescription]
	}

	static def Iterable<VocabularyBox> getUsedVocabularyBoxes(Description description) {
		description.usagesWithSource.map[usedVocabularyBox]
	}

	static dispatch def Iterable<Statement> getStatements(Description ontology) {
		ontology.ownedStatements.filter(Statement)
	}

	// DescriptionBundle

	static dispatch def Iterable<Import> getImportsWithSource(DescriptionBundle ontology) {
		ontology.ownedImports.filter(Import)
	}

	static def Iterable<DescriptionBundleExtension> getExtensionsWithSource(DescriptionBundle bundle) {
		bundle.ownedImports.filter(DescriptionBundleExtension)
	}

	static def Iterable<DescriptionBundleInclusion> getInclusionsWithSource(DescriptionBundle bundle) {
		bundle.ownedImports.filter(DescriptionBundleInclusion)
	}

	static def Iterable<DescriptionBundleUsage> getUsagesWithSource(DescriptionBundle bundle) {
		bundle.ownedImports.filter(DescriptionBundleUsage)
	}

	static def Iterable<DescriptionBundle> getExtendedDescriptionBundles(DescriptionBundle bundle) {
		bundle.extensionsWithSource.map[extendedDescriptionBundle]
	}

	static def Iterable<Description> getIncludedDescriptions(DescriptionBundle bundle) {
		bundle.inclusionsWithSource.map[includedDescription]
	}

	static def Iterable<VocabularyBundle> getUsedVocabularyBundles(DescriptionBundle bundle) {
		bundle.usagesWithSource.map[usedVocabularyBundle]
	}

	// Member
	
	static dispatch def String getIri(Member element) {
		val ontology = element.ontology
		ontology?.namespace + element.name
	}

	static dispatch def String getAbbreviatedIri(Member element) {
		element.ontology?.prefix+':'+element.name
	}

	static dispatch def String getNameIn(Member element, Ontology ontology) {
		if (element.ontology === ontology) {
			element.name
		} else {
			ontology.importPrefixes.get(element.ontology?.namespace)?.concat(':'+element.name)
		}
	}

	// Term

	// SpecializableTerm

	static def Iterable<SpecializableTerm> getSpecializedTerms(SpecializableTerm term) {
		term.ownedSpecializations.map[specializedTerm]
	}

	// Type

	// Classifier
	
	// Entity
	
	// Aspect
	
	// Concept
	
	// RelationEntity
	
	static def Iterable<Relation> getRelations(RelationEntity entity) {
		val relations = new ArrayList<Relation>
		if (entity.forward !== null) {
			relations += entity.forward
		}
		if (entity.reverse !== null) {
			relations += entity.reverse
		}
		relations
	}
	
	// Structure
	
	// Property
	
	// AnnotationProperty
	
	// CharacterizationProperty
	
	// ScalarProperty
	
	static dispatch def Scalar getRange(ScalarProperty property) {
		property.range
	}
	
	// StructuredProperty

	static dispatch def Structure getRange(StructuredProperty property) {
		property.range
	}

	// Scalar
		
	static def Scalar getSpecializedScalar(Scalar scalar) {
		// scalars can have a max of one specialized term
		scalar.specializedTerms.head as Scalar
	}

	// FacetedScalar
		
	// EnumeratedScalar
			
	// Relation
	
	static def Vocabulary getVocabulary(Relation relation) {
		relation.ontology as Vocabulary
	}

	// ForwardRelation
	
	static dispatch def RelationEntity getEntity(ForwardRelation relation) {
		relation.entity
	}

	// ReverseRelation
		
	static dispatch def RelationEntity getEntity(ReverseRelation relation) {
		relation.entity
	}

	// Rule

	// Instance

	// StructureInstance
		
	// NamedInstance
		
	// ConceptInstance
	
	// RelationInstance
	
	// Reference
	
	static dispatch def Member resolve(Reference reference) {
	}

	static def String getResolvedName(Reference reference) {
		reference.resolve.getNameIn(reference.ontology)
	}
	
	static def getAnnotationValues(Reference reference, String annotationPropertyIri) {
		reference.ownedAnnotations.filter[property.iri == annotationPropertyIri].map[value]
	}
	
	static def getAnnotationValue(Reference reference, String annotationPropertyIri) {
		reference.getAnnotationValues(annotationPropertyIri)?.head
	}

	static def getAnnotationLexicalValue(Reference reference, String annotationPropertyIri) {
		reference.getAnnotationValue(annotationPropertyIri)?.lexicalValue
	}

	// SpecializableTermReference
	
	static def Iterable<SpecializableTerm> getSpecializedTerms(SpecializableTermReference reference) {
		reference.ownedSpecializations.map[specializedTerm]
	}

	// EntityReference
	
	// AspectReference
	
	static dispatch def Member resolve(AspectReference reference) {
		reference.aspect
	}
	
	// ConceptReference

	static dispatch def Member resolve(ConceptReference reference) {
		reference.concept
	}

	// RelationEntityReference

	static dispatch def Member resolve(RelationEntityReference reference) {
		reference.entity
	}
	
	// StructureReference
	
	static dispatch def Member resolve(StructureReference reference) {
		reference.structure
	}

	// AnnotationPropertyReference

	static dispatch def Member resolve(AnnotationPropertyReference reference) {
		reference.property
	}

	// ScalarPropertyReference
	
	static dispatch def Member resolve(ScalarPropertyReference reference) {
		reference.property
	}
	
	// StructuredPropertyReference
	
	static dispatch def Member resolve(StructuredPropertyReference reference) {
		reference.property
	}

	// ScalarReference

	// FacetedScalarReference
	
	static dispatch def Member resolve(FacetedScalarReference reference) {
		reference.scalar
	}

	// EnumeratedScalarReference
	
	static dispatch def Member resolve(EnumeratedScalarReference reference) {
		reference.scalar
	}

	// RelationReference
	
	static dispatch def Member resolve(RelationReference reference) {
		reference.relation
	}
	
	// RuleReference

	static dispatch def Member resolve(RuleReference reference) {
		reference.rule
	}
		
	// NamedInstanceReference

	// ConceptInstanceReference
	
	static dispatch def Member resolve(ConceptInstanceReference reference) {
		reference.instance
	}

	// RelationInstanceReference
	
	static dispatch def Member resolve(RelationInstanceReference reference) {
		reference.instance
	}

	// Statement

	// VocabularyStatement
	
	static def Vocabulary getVocabulary(VocabularyStatement statement) {
		statement.ontology as Vocabulary
	}

	// DescriptionStatement
	
	static def Description getDescription(DescriptionStatement statement) {
		statement.ontology as Description
	}

	// Import

	static def String getImportPrefix(Import ^import) {
		if (^import.prefix !== null) {
			^import.prefix
		} else {
			^import.getImportedOntology?.prefix
		}
	}

	static def String getImportNamespace(Import ^import) {
		^import.getImportedOntology?.namespace
	}

	static val NUMBER = Pattern.compile("\\d+");

	synchronized static def URI getResolvedImportUri(Import ^import) {
		if (^import.uri !== null) {
			var uri = URI.createURI(^import.uri)
			if (uri.isRelative() && !uri.isEmpty()) {
				val contextURI = ^import.eResource?.getURI()
				uri = if (contextURI !== null) uri.resolve(contextURI) else null
			} else {
				val contextURI = ^import.eResource?.getURI()
				val rs = ^import.eResource?.resourceSet
				if (rs !== null && contextURI !== null) {
					var catalogMap = rs.loadOptions.get(CATALOGS) as Map<URI, OmlCatalog>
					if (catalogMap === null) {
						rs.loadOptions.put(CATALOGS, catalogMap = new HashMap<URI, OmlCatalog>)
					}
					try {
						val directoryURI = contextURI.trimSegments(1)
						if (!catalogMap.containsKey(directoryURI)) {
							catalogMap.findCatalogs(directoryURI)
						}
						var catalog = catalogMap.get(directoryURI)
						if (catalog !== null) {
							val resolved = catalog.resolveURI(uri.toString)
							if (resolved !== null) {
								uri = URI.createURI(resolved)
								if (uri.fileExtension === null) {
									// if the imported URI does not end with an extension, assume it's .oml
									uri = uri.appendFileExtension(OML_EXTENSION)
								} else if (NUMBER.matcher(uri.fileExtension).matches) { 
									// special case for the dc vocabulary ending its IRI with a version number
									uri = uri.appendFileExtension(OML_EXTENSION)
								}
              }
						}
					} catch (MalformedURLException e) {
						// the contextURI scheme is not recognized
					}
				}
			}
			return uri
		}
	}
	
	private static def findCatalogs(Map<URI, OmlCatalog> catalogMap, URI folder) {
		val path = new ArrayList<URI>
		var current = folder
		var OmlCatalog catalog = null
		while (current !== null && catalog === null && current.segmentCount > 0) {
			path.add(current)
			val catalogUrl = try {
					new URL(current.appendSegment('catalog.xml').toString)
				} catch (MalformedURLException e) {
					null
				}
			val catalogFileUrl = try {
					FileLocator.toFileURL(catalogUrl)
				} catch (IOException e) {
					null
				}
			if (catalogFileUrl?.protocol == 'file' && Paths.get(catalogFileUrl.toURI).toFile.exists) {
				catalog = OmlCatalog.create(catalogUrl)
			} else {
				current = current.trimSegments(1)
				catalog = catalogMap.get(current)
			}
		}
		val foundCatalog = catalog
		path.forEach[ catalogMap.put(it, foundCatalog) ]
	}

	static def Resource getImportedResource(Import ^import) {
		val uri = ^import.resolvedImportUri
		if (uri === null) {
			return null
		}			
		val resourceSet = ^import.eResource.resourceSet
		if (resourceSet === null) {
			return null
		}
		 var resource = resourceSet.getResource(uri, false)
		 if (resource !== null) {
		 	return resource
		 }
		try {
			val uriConverter = resourceSet.getURIConverter();
			if (uriConverter !== null && uriConverter.exists(uri, resourceSet.loadOptions)) {
				resource = resourceSet.getResource(uri, true)
			}
			return resource
		} catch (Throwable t) {
			return null
		}
	}

	static def Ontology getImportedOntology(Import ^import) {
		^import.importedResource?.ontology
	}

	static dispatch def Ontology getImportingOntology(Import ^import) {
	}

	// VocabularyImport
	
	static dispatch def Ontology getImportingOntology(VocabularyImport ^import) {
		^import.importingVocabulary
	}

	static def Vocabulary getImportingVocabulary(VocabularyImport ^import) {
		^import.owningVocabulary
	}

	// VocabularyExtension
	
	static def Vocabulary getExtendingVocabulary(VocabularyExtension ^extension) {
		^extension.owningVocabulary
	}

	static def Vocabulary getExtendedVocabulary(VocabularyExtension ^extension) {
		^extension.importedOntology as Vocabulary
	}

	// VocabularyUsage
	
	static def Vocabulary getUsingVocabulary(VocabularyUsage usage) {
		usage.owningVocabulary
	}

	static def DescriptionBox getUsedDescriptionBox(VocabularyUsage usage) {
		usage.importedOntology as DescriptionBox
	}

	// VocabularyBundleImport
	
	static dispatch def Ontology getImportingOntology(VocabularyBundleImport ^import) {
		^import.importingVocabularyBundle
	}

	static def VocabularyBundle getImportingVocabularyBundle(VocabularyBundleImport ^import) {
		^import.owningVocabularyBundle
	}

	// VocabularyBundleExtension
	
	static def VocabularyBundle getExtendingVocabularyBundle(VocabularyBundleExtension ^extension) {
		^extension.owningVocabularyBundle
	}

	static def VocabularyBundle getExtendedVocabularyBundle(VocabularyBundleExtension ^extension) {
		^extension.importedOntology as VocabularyBundle
	}

	// VocabularyBundleInclusion
	
	static def VocabularyBundle getIncludingVocabularyBundle(VocabularyBundleInclusion inclusion) {
		inclusion.owningVocabularyBundle
	}

	static def Vocabulary getIncludedVocabulary(VocabularyBundleInclusion inclusion) {
		inclusion.importedOntology as Vocabulary
	}

	// DescriptionImport
	
	static dispatch def Ontology getImportingOntology(DescriptionImport ^import) {
		^import.importingDescription
	}

	static def Description getImportingDescription(DescriptionImport ^import) {
		^import.owningDescription
	}

	// DescriptionExtension

	static def Description getExtendingDescription(DescriptionExtension ^extension) {
		^extension.owningDescription
	}

	static def Description getExtendedDescription(DescriptionExtension ^extension) {
		^extension.importedOntology as Description
	}

	// DescriptionUsage
	
	static def Description getUsingDescription(DescriptionUsage usage) {
		usage.owningDescription
	}

	static def VocabularyBox getUsedVocabularyBox(DescriptionUsage usage) {
		usage.importedOntology as VocabularyBox
	}

	// DescriptionBundleImport
	
	static dispatch def Ontology getImportingOntology(DescriptionBundleImport ^import) {
		^import.importingDescriptionBundle
	}

	static def DescriptionBundle getImportingDescriptionBundle(DescriptionBundleImport ^import) {
		^import.owningDescriptionBundle
	}

	// DescriptionBundleExtension
	
	static def DescriptionBundle getExtendingDescriptionBundle(DescriptionBundleExtension ^extension) {
		^extension.owningDescriptionBundle
	}

	static def DescriptionBundle getExtendedDescriptionBundle(DescriptionBundleExtension ^extension) {
		^extension.importedOntology as DescriptionBundle
	}

	// DescriptionBundleInclusion
	
	static def DescriptionBundle getIncludingDescriptionBundle(DescriptionBundleInclusion inclusion) {
		inclusion.owningDescriptionBundle
	}

	static def Description getIncludedDescription(DescriptionBundleInclusion inclusion) {
		inclusion.importedOntology as Description
	}

	// DescriptionBundleUsage
	
	static def DescriptionBundle getUsingDescriptionBundle(DescriptionBundleUsage usage) {
		usage.owningDescriptionBundle
	}

	static def VocabularyBundle getUsedVocabularyBundle(DescriptionBundleUsage usage) {
		usage.importedOntology as VocabularyBundle
	}

	// Axiom

	// SpecializationAxiom

	static def SpecializableTerm getSpecializingTerm(SpecializationAxiom axiom) {
		if (axiom.owningReference !== null) {
			axiom.owningReference.resolve as SpecializableTerm
		} else {
			axiom.owningTerm
		}
	}
	
	// RestrictionAxiom

	static dispatch def Classifier getRestrictingType(RestrictionAxiom axiom) {
	}
			
	static dispatch def Term getRestrictedTerm(RestrictionAxiom axiom) {
	}

	// PropertyRestrictionAxiom

	static dispatch def Classifier getRestrictingType(PropertyRestrictionAxiom axiom) {
		if (axiom.owningReference !== null) {
			axiom.owningReference.resolve as Classifier
		} else {
			axiom.owningClassifier
		}
	}

	// ScalarPropertyRestrictionAxiom

	static dispatch def Term getRestrictedTerm(ScalarPropertyRestrictionAxiom axiom) {
		axiom.property
	}

	// ScalarPropertyRangeRestrictionAxiom
		
	// ScalarPropertyCardinalityRestrictionAxiom

	// ScalarPropertyValueRestrictionAxiom
	
	// StructuredPropertyRestrictionAxiom
		
	static dispatch def Term getRestrictedTerm(StructuredPropertyRestrictionAxiom axiom) {
		axiom.property
	}

	// StructuredPropertyRangeRestrictionAxiom
	
	// StructuredPropertyCardinalityRestrictionAxiom

	// StructuredPropertyValueRestrictionAxiom
	
	// RelationRestrictionAxiom

	static dispatch def Term getRestrictedTerm(RelationRestrictionAxiom axiom) {
		axiom.relation
	}
	
	static dispatch def Classifier getRestrictingType(RelationRestrictionAxiom axiom) {
		axiom.restrictingEntity
	}

	static def Entity getRestrictingEntity(RelationRestrictionAxiom axiom) {
		if (axiom.owningReference !== null) {
			axiom.owningReference.resolve as Entity
		} else {
			axiom.owningEntity
		}
	}

	// RelationRangeRestrictionAxiom
	
	// RelationCardinalityRestrictionAxiom
	
	// RelationTargetRestrictionAxiom

	// KeyAxiom

	static def Entity getKeyedEntity(KeyAxiom axiom) {
		if (axiom.owningReference !== null) {
			axiom.owningReference.resolve as Entity
		} else {
			axiom.owningEntity
		}
	}

	static dispatch def Classifier getRestrictingType(KeyAxiom axiom) {
		axiom.getRestrictingEntity
	}

	static def Entity getRestrictingEntity(KeyAxiom axiom) {
		if (axiom.owningReference !== null) {
			axiom.owningReference.resolve as Entity
		} else {
			axiom.owningEntity
		}
	}

	// Assertion
	
	static dispatch def Instance getInstance(Assertion assertion) {	
	}
	
	// TypeAssertion

	static dispatch def Entity getType(TypeAssertion assertion) {
	}

	// ConceptTypeAssertion
	
	static dispatch def Entity getType(ConceptTypeAssertion assertion) {
		assertion.type
	}

	static dispatch def Instance getInstance(ConceptTypeAssertion assertion) {
		assertion.conceptInstance
	}

	static def ConceptInstance getConceptInstance(ConceptTypeAssertion assertion) {
		if (assertion.owningReference !== null) {
			assertion.owningReference.resolve as ConceptInstance
		} else {
			assertion.owningInstance
		}
	}

	// RelationTypeAssertion

	static dispatch def Entity getType(RelationTypeAssertion assertion) {
		assertion.type
	}

	static dispatch def Instance getInstance(RelationTypeAssertion assertion) {
		assertion.relationInstance
	}
	
	static def RelationInstance getRelationInstance(RelationTypeAssertion assertion) {
		if (assertion.owningReference !== null) {
			assertion.owningReference.resolve as RelationInstance
		} else {
			assertion.owningInstance
		}
	}

	// PropertyValueAssertion

	static dispatch def Instance getInstance(PropertyValueAssertion assertion) {
		if (assertion.owningReference !== null) {
			assertion.owningReference.resolve as Instance
		} else {
			assertion.owningInstance
		}
	}

	static dispatch def Property getProperty(PropertyValueAssertion assertion) {
	}
		
	static dispatch def Element getValue(PropertyValueAssertion assertion) {
	}

	// ScalarPropertyValueAssertion
	
	static dispatch def Property getProperty(ScalarPropertyValueAssertion assertion) {
		assertion.property
	}

	static dispatch def Element getValue(ScalarPropertyValueAssertion assertion) {
		assertion.value
	}

	// StructuredPropertyValueAssertion
	
	static dispatch def Property getProperty(StructuredPropertyValueAssertion assertion) {
		assertion.property
	}

	static dispatch def Element getValue(StructuredPropertyValueAssertion assertion) {
		assertion.value
	}

	// LinkAssertion
		
	static def NamedInstance getSource(LinkAssertion assertion) {
		assertion.instance as NamedInstance
	}

	static dispatch def Instance getInstance(LinkAssertion assertion) {
		assertion.namedInstance
	}
	
	static def NamedInstance getNamedInstance(LinkAssertion assertion) {
		if (assertion.owningReference !== null) {
			assertion.owningReference.resolve as NamedInstance
		} else {
			assertion.owningInstance
		}
	}

	// Predicate

	// UnaryPredicate

	// EntityPredicate

	// BinaryPredicate
	
	// RelationPredicate

	// SameAsPredicate

	// DifferentFromPredicate

	// RelationEntityPredicate

	// Literal
	
	// QuotedLiteral
	
	static dispatch def getLiteralValue(QuotedLiteral literal) {
		literal.value
	}

	static dispatch def String getLexicalValue(QuotedLiteral literal) {
		literal.value?.toString
	}

	// IntegerLiteral
	
	static dispatch def getLiteralValue(IntegerLiteral literal) {
		literal.value
	}

	static dispatch def String getLexicalValue(IntegerLiteral literal) {
		Integer.toString(literal.value)
	}

	// DecimalLiteral
	
	static dispatch def getLiteralValue(DecimalLiteral literal) {
		literal.value
	}

	static dispatch def String getLexicalValue(DecimalLiteral literal) {
		literal.value?.toString?:'0.0'
	}

	// DoubleLiteral
	
	static dispatch def getLiteralValue(DoubleLiteral literal) {
		literal.value
	}

	static dispatch def String getLexicalValue(DoubleLiteral literal) {
		Double.toString(literal.value)
	}
	
	// BooleanLiteral
	
	static dispatch def getLiteralValue(BooleanLiteral literal) {
		literal.value
	}

	static dispatch def String getLexicalValue(BooleanLiteral literal) {
		Boolean.toString(literal.value)
	}

}