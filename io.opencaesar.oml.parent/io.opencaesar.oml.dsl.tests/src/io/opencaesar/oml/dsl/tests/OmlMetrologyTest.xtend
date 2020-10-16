package io.opencaesar.oml.dsl.tests

import io.opencaesar.oml.dsl.OmlStandaloneSetup
import java.io.FileOutputStream
import java.nio.file.Files
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import java.util.Collection
import java.io.File
import java.util.ArrayList
import java.nio.file.Path

import static extension io.opencaesar.oml.util.OmlRead.*
import org.eclipse.emf.ecore.util.EcoreUtil
import io.opencaesar.oml.util.OmlCatalog
import java.util.HashMap
import java.util.Map
import java.io.BufferedWriter
import java.io.FileWriter
import io.opencaesar.oml.util.OmlOntologyScopeCalculator

@ExtendWith(InjectionExtension)
@InjectWith(OmlInjectorProvider)
class OmlMetrologyTest {

	@Test
	def void loadModel() {
		OmlStandaloneSetup.doSetup()
		val rs = new XtextResourceSet
		var catalogMap = rs.loadOptions.get(CATALOGS) as Map<URI, OmlCatalog>
		if (catalogMap === null) {
			rs.loadOptions.put(CATALOGS, catalogMap = new HashMap<URI, OmlCatalog>)
		}

		val Path temp = Files.createTempDirectory("oml-")
		temp.toFile.deleteOnExit()

		extractZipResource(temp, "/metrology.zip")
		val catalogFile = temp.resolve("catalog.xml").toFile
		val bw = new BufferedWriter(new FileWriter(catalogFile))
		bw.write(
			"<?xml version='1.0'?>\n" +
				"<catalog xmlns=\"urn:oasis:names:tc:entity:xmlns:xml:catalog\" prefer=\"public\">\n" +
				"\t<rewriteURI uriStartString=\"http://\" rewritePrefix=\"./\" />\n" + "</catalog>"
		);
		bw.close();

		val omlFiles = collectOMLFiles(temp.toFile)
		for (omlFile : omlFiles) {
			val inputURI = URI.createFileURI(omlFile.absolutePath)
			rs.getResource(inputURI, true)
		}

		EcoreUtil.resolveAll(rs)

		for (r : rs.resources) {
			Assertions.assertTrue(r.errors.size == 0, "Errors in resource: " + r.URI)
		}

		val core = rs.resources.map[r|r.ontology].findFirst [ o |
			o.iri == "http://ontology.iupac.org/metrology/diagrams/core"
		]

		val scope = new OmlOntologyScopeCalculator(core)
		scope.analyze()

		scope.aspects.keySet.forEach [ x |
			println("aspect: " + x.abbreviatedIri)
			scope.scalarProperties.get(x).forEach [ y |
				println(" - scalar: " + y.abbreviatedIri)
			]
			scope.structuredProperties.get(x).forEach [ y |
				println(" - struct: " + y.abbreviatedIri)
			]
		]
		scope.concepts.keySet.forEach [ x |
			println("concept: " + x.abbreviatedIri)
			scope.scalarProperties.get(x).forEach [ y |
				println(" - scalar: " + y.abbreviatedIri)
			]
			scope.structuredProperties.get(x).forEach [ y |
				println(" - struct: " + y.abbreviatedIri)
			]
		]
		scope.relationEntities.keySet.forEach [ x |
			println("relation entity: " + x.abbreviatedIri)
			scope.scalarProperties.get(x).forEach [ y |
				println(" - scalar: " + y.abbreviatedIri)
			]
			scope.structuredProperties.get(x).forEach [ y |
				println(" - struct: " + y.abbreviatedIri)
			]
		]
		scope.specializationAxioms.forEach [ x |
			println("specialization: " + x.specializingTerm.abbreviatedIri + " -> " + x.specializedTerm.abbreviatedIri)
		]

	}

	def extractZipResource(Path dir, String resourcePath) {
		val is = OmlMetrologyTest.getResourceAsStream(resourcePath)
		if (is === null)
			throw new IllegalArgumentException("Cannot find resource: " + resourcePath)
		val zis = new ZipInputStream(is)
		var ZipEntry ze
		while (null !== (ze = zis.getNextEntry())) {
			val f = dir.resolve(ze.getName()).toFile()
			f.deleteOnExit()
			if (ze.isDirectory())
				f.mkdirs()
			else {
				val fos = new FileOutputStream(f)
				val byte[] buffer = newByteArrayOfSize(4096)
				var int len
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len)
				}
				fos.close()
			}
			zis.closeEntry()
		}
		zis.close()
	}

	package static val OML = 'oml'
	package static val OMLXMI = "omlxmi"

	def Collection<File> collectOMLFiles(File directory) {
		val omlFiles = new ArrayList<File>
		for (file : directory.listFiles()) {
			if (file.isFile) {
				if ((getFileExtension(file) == OML || getFileExtension(file) == OMLXMI)) {
					omlFiles.add(file)
				}
			} else if (file.isDirectory) {
				omlFiles.addAll(collectOMLFiles(file))
			}
		}
		return omlFiles
	}

	def String getFileExtension(File file) {
		val fileName = file.getName()
		if (fileName.lastIndexOf(".") != -1)
			return fileName.substring(fileName.lastIndexOf(".") + 1)
		else
			return ""
	}
}
