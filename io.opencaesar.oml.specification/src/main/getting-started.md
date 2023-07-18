# Getting Started # {#Getting-Started}

## OML Project ## {#OML-Project}

An OML project is a root folder that typically nests [OML files](#OML-File), a [catalog file](#Catalog-File), and a [build](#Build-File) file as follows:

<pre class="highlight highlight-html">
.
├── build
│   └── oml
│       └── www.w3.org
│           └── 2001
│               └── XMLSchema.oml
│           └── 2002
│               └── 07
│                   └── owl.oml
├── src
│   └── oml
│       ├── imce.jpl.nasa.gov
│       │    └── foundation
│       │	    ├── base.oml
│       │	    ├── analysis.oml
│       │	    └── mission.oml
│       └── europa.jpl.nasa.gov
│           └── lander
│       	    ├── assemblies.omlxmi
│       	    ├── endcircuits.omlxmi
│       	    └── functions.omljson
|
├── catalog.xml
└── build.gradle
</pre>

## OML File ## {#OML-File}

An OML file has the extension *oml* (if it uses the OML textual syntax), *omlxmi* (if it uses the OML XMI syntax) or *omljson* (if it uses the OML Json syntax). It can be directly at the root of an OML project or nested in sub folders. OML files that are manually authored are typiclally nested under a *src* sub folder, while those that are machine produced are typically nested under a *build* sub folder. Each OML file defines a single OML [ontolopgy](#Ontology-LR) which has a unique hierarchical \[IRI](#IRI-LR). The nesting path of an OML file typically corresponds to the nesting path of its ontology IRI. For example, an ontology with an IRI *http://imce.jpl.nasa.gov/foundation/base#* is persisted in a file with a path *imce.jpl.nasa.gov/foundation/base.oml*. The syntax of an OML file is discussed in the [language reference](#Language-Reference) section.

## Catalog File ## {#Catalog-File}

A catalog.xml file provides a mapping from the OML ontology IRIs to their corresponding file paths under the project. This enables an OML ontology to [import](#Import-LR) another ontology using the latter's logical IRI, without worrying where the file physically exists under the project. The catalog file is defined based on the [OASIS XML Catalog](https://www.oasis-open.org/committees/entity/spec-2001-08-06.html) standard. The standard allows defining the mapping rules in several ways. One common way is using a `rewriteURI` rule, which has an attribute `uriStartString` that specifies a prefix for an IRI, and attribute `rewritePrefix` that specifies the corresponding file path prefix. For example, using the first rewriteURI rule in the catalog below, the IRI *http://imce.jpl.nasa.gov/foundation/base* would be mapped to the file path *src/oml/imce.jpl.nasa.gov/foundation/base.oml*, whle using the second rewriteURI rule, the IRI *http://www.w3.org/2002/07/owl* would be mapped to the file path *build/oml/www.w3.org/2002/07/owl.oml*.

<pre class="highlight highlight-html">
<`?xml` `version`='1.0'`?`>
<`catalog` `xmlns`="urn:oasis:names:tc:entity:xmlns:xml:catalog" `prefer`="public">
	<`rewriteURI` `uriStartString`="http://imce.jpl.nasa.gov/" `rewritePrefix`="src/oml/imce.jpl.nasa.gov/" />
	<`rewriteURI` `uriStartString`="http://" rewritePrefix="build/oml/" />
<`/catalog`>
</pre>

Note: If an IRI is mappable by more than one catalog rule, the most specific rule is used.

Note: Catalog IRI resolution checks the existence of files with OML extensions in this order: *oml*, *omlxmi*, then *omljson*.

Note: To be considered a valid OML file, the file needs to be mapped by some rule in a catalog file.

## Build File ## {#Build-File}

The build file is a standard [Gradle](https://docs.gradle.org/) file that describes an analysis pipeline for the OML project. In addition to plethora of gradle plugins/tasks that can be used to construct the pipeline, the [openCAESAR] project (the home of OML) provides some addiional ones that are particulary useful for OML analysis. The following is a list of links to those tools for additional information:

- [OML Tools](https://github.com/opencaesar/oml-tools): a set of tools that work on the OML format
- [OWL Tools](https://github.com/opencaesar/owl-tools): a set of tools that work on the OWL format
- [OWL Adapter](https://github.com/opencaesar/owl-adapter): a set of tools that convert between OML and OWL formats
