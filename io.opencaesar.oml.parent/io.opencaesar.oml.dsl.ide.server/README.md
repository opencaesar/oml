# OML Diagram Server

## Java / Xtend.

The following Xtend sources have been manually converted to Java.
The original xtend sources are retained for comparison purposes; 
however, there is additional functionality in the java files not present in the xtend files.


In `src/io/opencaesar/oml/dsl/ide/diagram/`:

| Xtend | Java |
|-------|------|
| OmlDiagramModule.xtend (deleted) | OmlDiagramModule.java |
| OmlDiagramGenerator.xtend (deleted) | OmlDiagramViewGenerator.java |
| OmlDiagramView.xtend (deleted) | OmlOntologyDiagramView.java |
| OmlOntologyScopeCalculator.xtend (deleted) | OmlOntoloyDiagramScope.java |

## Layout algorithms

By default, Elk uses the `RecursiveGraphLayoutEngine`, which applies a layout algorithm on each level of the hierarchy.
There are two alternatives: `OmlDiagramGraphvizLayoutEngine` and `OmlDiagramLayeredLayoutEngine` that replace the default
with ELK's Graphviz Dot and ELK's Layered algorithms respectively. Of the three, the third produces the most reasonable layouts
for OML ontologies.


## Running in debug mode.

1) Execute: `io.opencaesar.oml.dsl.ide.launch.OmlRunSocketServer` with command-line arguments: `--port 5009`
2) Clone https://github.com/opencaesar/oml-theia
  * `cd oml-theia/electron-app`
  * `yarn start --LSP_PORT=5009`
  

## Known problem.

When working with multiple Oml Theia windows, a diagram created on one window may show up in another window even though
the two windows are completely unrelated in terms of ontologies.

- Start Oml Theia and open a folder, e.g., F1
- Open a diagram for an ontology of F1, say O1 => this shows a diagram, say, D1, for O1.

- Open a new folder, e.g., F2
- Open a diagram for an ontology of F2, say, O2 => this will show a diagram, say D2 for O2;
  however, instead of showing O2's contents, it shows O1's contents instead!
  

* Workaround: Close the new diagram, D2, and open the diagram for the ontology O2 again.
