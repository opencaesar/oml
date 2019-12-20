<img src="io.opencaesar.oml.parent/io.opencaesar.oml.specification/image/oml.svg" alt="OML" width="30%" height="30%"/>

# Ontological Modeling Language

[![Build Status](https://travis-ci.org/opencaesar/oml.svg?branch=master)](https://travis-ci.org/opencaesar/oml)
[![Maven](https://api.bintray.com/packages/opencaesar/oml/io.opencaesar.oml/images/download.svg) ](https://bintray.com/opencaesar/oml/io.opencaesar.oml/_latestVersion)
[![Updatesite](https://img.shields.io/badge/p2-updatesite-yellow.svg?longCache=true)](https://bintray.com/opencaesar/p2/oml/_latestVersion)
[![OML Specification](https://img.shields.io/badge/OML-specification-purple.svg?longCache=true)](https://opencaesar.github.io/oml/)


This repository defines the OML abstract syntax, textual syntax, graphical syntax, and API. It is released as a Maven library, an Eclipse p2 updatesite, and an LSP server. It also contains the OML specification.

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

## Release

Replace \<version\> by the version, e.g., 0.5.0
```
  git tag -a <version> -m "<version>"
  git push origin <version>
```
