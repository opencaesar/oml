<img src="io.opencaesar.oml.specification/src/images/oml.svg" alt="OML" width="30%" height="30%"/>

# Ontological Modeling Language

[![Build Status](https://app.travis-ci.com/opencaesar/oml.svg?branch=master)](https://app.travis-ci.com/github/opencaesar/oml)
[![Release](https://img.shields.io/github/v/release/opencaesar/oml?label=release)](https://github.com/opencaesar/oml/releases/latest)
[![Updatesite](https://img.shields.io/badge/p2-updatesite-yellow.svg?longCache=true)](https://github.com/opencaesar/oml-p2)
[![OML Specification](https://img.shields.io/badge/OML-specification-purple.svg?longCache=true)](https://opencaesar.github.io/oml/)


This repository defines the OML abstract syntax, textual syntax, graphical syntax, API and specification.

It also publishes the following artifacts (see the OML specification for using instructions):

  - Maven [libraries](https://search.maven.org/search?q=a:io.opencaesar.oml) that give access to OML APIs from JVM languages.
  - A p2 [updatesite](https://github.com/opencaesar/oml-p2) that gives native OML support in the Eclipse IDE.
  - An LSP [server](https://github.com/opencaesar/oml/releases) that gives support for OML in editors that support LSP.
  - The OML [specification](https://opencaesar.github.io/oml/) that documents how OML can be used.

## Clone
```
  git clone https://github.com/opencaesar/oml.git
  cd oml
```

## Build

Dependencies: Gradle 6.x, Maven 3.6.x, Java 11
```
  ./gradlew build
  mvn verify
```

> NOTE: If the gradle build gives errors on a second or subsequent build, try deleting the generated `.gradle` subfolder then try invoking the gradle build again 


## Spec
If you want to generate the OML spec, you first need to have the [bikeshed](https://tabatkins.github.io/bikeshed/#install-final) tool installed in the environment, then invoke:
```
  ./gradlew generateDocs
```


