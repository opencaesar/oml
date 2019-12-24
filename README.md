<img src="io.opencaesar.oml.parent/io.opencaesar.oml.specification/src/images/oml.svg" alt="OML" width="30%" height="30%"/>

# Ontological Modeling Language

[![Build Status](https://travis-ci.org/opencaesar/oml.svg?branch=master)](https://travis-ci.org/opencaesar/oml)
[![Maven](https://api.bintray.com/packages/opencaesar/oml/io.opencaesar.oml/images/download.svg) ](https://bintray.com/opencaesar/oml/io.opencaesar.oml/_latestVersion)
[![Updatesite](https://img.shields.io/badge/p2-updatesite-yellow.svg?longCache=true)](https://bintray.com/opencaesar/p2/oml/_latestVersion)
[![OML Specification](https://img.shields.io/badge/OML-specification-purple.svg?longCache=true)](https://opencaesar.github.io/oml/)


This repository defines the OML abstract syntax, textual syntax, graphical syntax, API and specification.

It also publishes the following artifacts (see the OML specification for using instructions):

  - Maven [libraries](https://bintray.com/opencaesar/oml) that give access to OML APIs from JVM languages.
  - A p2 [updatesite](https://bintray.com/opencaesar/p2/oml) that gives native OML support in the Eclipse IDE.
  - An LSP [server](https://github.com/opencaesar/oml/releases) that gives support for OML in editors that support LSP.
  - The OML [specification](https://opencaesar.github.io/oml/) that documents how OML can be used.

## Clone
```
  git clone https://github.com/opencaesar/oml.git
  cd oml
```

## Build

Dependencies: Gradle 4.9, Java 8
```
  cd io.opencaesar.oml.parent
  ./gradlew build
  mvn verify
```
Note: the gradle build updates the OML specification's generated Bikeshed source files


## Render Specification

If you have updated the OML specification's Bikeshed source files, you can render them to HTML using:
```
  cd io.opencaesar.oml.specification
  bikeshed spec
```
Note: to install the Bikeshed tool, follow these [instructions](https://tabatkins.github.io/bikeshed/#installing).

## Release

Replace \<version\> by the version, e.g., 0.5.0
```
  git tag -a <version> -m "<version>"
  git push origin <version>
```
