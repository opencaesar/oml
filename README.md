<img src="io.opencaesar.oml.specification/src/images/oml.svg" alt="OML" width="30%" height="30%"/>

# Ontological Modeling Language

[![Build Status](https://app.travis-ci.com/opencaesar/oml.svg?branch=master)](https://app.travis-ci.com/github/opencaesar/oml)
[![Release](https://img.shields.io/github/v/release/opencaesar/oml?label=release)](https://github.com/opencaesar/oml/releases/latest)
[![Updatesite](https://img.shields.io/badge/p2-updatesite-yellow.svg?longCache=true)](https://github.com/opencaesar/oml-p2)
[![OML Specification](https://img.shields.io/badge/OML-specification-purple.svg?longCache=true)](https://opencaesar.github.io/oml/)

This repository is for the OML abstract syntax, textual syntax, graphical syntax, API and specification.

It also publishes the following artifacts (see the OML specification for using instructions):

  - Maven [libraries](https://search.maven.org/search?q=a:io.opencaesar.oml) that provides OML APIs for JVM languages.
  - P2 [update site](https://github.com/opencaesar/oml-p2) that provides native OML support in the Eclipse IDE.
  - LSP [server](https://github.com/opencaesar/oml/releases) that provides OML support in editors that support LSP.
  - OML [specification](https://opencaesar.github.io/oml/) that provides the OML documentation.

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
If you want to generate the OML spec, you first need to have both [bikeshed](https://tabatkins.github.io/bikeshed/#install-final) and 
[graphviz](https://graphviz.org/download/) installed in the environment, then invoke:
```
  ./gradlew generateDocs
```
The generated spec can then be opened from `io.opencaesar.oml.specification/build/bikeshed/index.html`

## Development

To setup a development environment for oml:

Preparation:

- Install/use a recent version of Eclipse IDE for Java and DSL Developers (e.g., 2021-09)
- Launch the Eclipse IDE and create a new workspace (recommended)
- Switch to the Java perspective from Window -> Perspective -> Open Perspective -> Other -> Java
- Show the Project Explorer view (if hidden) by selecting Window -> Show View -> Project Explorer
- Turn off automatic build from Project -> Build automatically (uncheck)

Import:

- Import the cloned project using File -> Import -> Maven -> Existing Maven Projects -> Browse (select the root of the clone folder) -> Finish
- Right click on the root `oml` project in the Project Explorer view and select from the context menu Gradle -> Refresh Gradle Project
- At this point, you should have all projects loaded in your workspace

Build:

- In Project Explorer, navigate to the file oml/io.opencaesar.oml.target/io.opencaesar.oml.target.target and double click to open its editor
- Wait for the resolution of the target platform to finish (watch the percentage at the bottom-right of the IDE window)
- Once the target platform is resolved, click in th editor on the link (top-right) saying "Set as Active Target Platform" then close the editor
- Turn on automatic build from Project -> Build automatically (check)
- The build will start, wait for it to finish (watch the percentage at the bottom-right of the IDE window)
- At this point, you should have all projects building without errors

To change version:

- In Project Explorer, navigate to the file oml/version.txt and double click to open its editor (note the current version)
- Using a terminal window, navigate to the root of the clone folder
- Execute the script ./setversion `<new-version>` (replace `<new-version>`)
- Back in Eclipse IDE, right click on the root project in Project Explorer view and select Refresh
- Wait for the build to finish