# Document Organization # {#Document-Organization}

This document is targetted at system engineering **methodologists**, **engineers**, as well as **toolsmiths** who are interested in OML. 

The section named [Getting Started](#Getting-Started) is targetted at **any reader**. It walks the reader through and demonstrates the use cases of working with OML.

The section named [Language Reference](#Language-Reference) is mostly targetted at **methodlogists**. It describes how to use OML to create vocabularies for a systems engineering methodology and what it means in terms of what the systems engineers would be able to describe with it. While it can also read by systems engineers, it would only serve the purpose of teaching the general OML idioms, and not the specific systems engineering methodology that the systems engineer need to learn to be effectively. For that, the systems engineer should read the methodology's own documentation.

The section named [Textual BNF](#Textual-BNF) is targetted mostly at **methodlogists** but can also be used by **engineers**. It describes the BNF grammar of OML. This can help readers understand textual OML models and create them using an OML text editor. In practice, OML vocabularies and example system descriptions are typically created using a text editor, but real sytem descriptions are typically created using methodology-specific higher level UI that is described iin the methodology's own documentation.

The section named [Grahical BNF](#Graphical-BNF) is targetted mostly at **methodlogists** but can also be used by **engineers**. It describes the graphical BNF grammar of OML. This can help readers understand standard OML diagrams and visualize them using graphical viewers. In practice, OML vocabularies and example system descriptions are typically visualized using this notation, but real sytem descriptions are typically visualized using methodology-specific notation that is described in the methodology's own documentation.

The section named [Abstract Syntax](#Abstract-Syntax) is targetted mostly at **toolsmiths** but can also be used by **methodologists**. It describes the constructs that make up the language, along with their attibutes, relations and constraints. Each set of related constructs are listed under a sub heading, visualized using a UML class diagram under that sub heading, where they appear in white color (other related constructs appear in grey color), and described in details including their super classes, subclasses, properties and constrainsts. Various hyperlinks are provided to help the reader navigate the constructs.

The section named [Public API](#Public-API) is targetted at **toolsmiths**. It describes the Java API of OML that can be used to create language tools, including adapters (transformations between OML and other languages and formats), interfaces (to other tools)  and UI tools (viewers/editors). Some of the public API maps directly from the corresponding OML abstract syntax. Other API adds useful functions that make working with OML programmatically easier.

The section named [Mapping to OWL2 and SWRL](#Mapping-to-Owl2-and-Swrl) is targetted at both **methodologists** and **toolsmiths**. It describes the semantics of OML by mapping them to the semantics of OWL2 and SWRL. It accomplishes that by giving the mapping of every OML construct to a pattern defined in a subset of OWL2 and SWRL. This can help a methodologist understand the semantics of OML constructs. It can also help a toolsmith define new tools for OML.

## Document Conventions ## {#Document-Conventions}

## BNF Conventions ## {#BNF-Conventions}

The document uses BNF notation to specify allowed expression syntax in the textual and graphical notation. The following BNF symbols are used:

- expression : the expression is required
- expression `?` : the expression is optional
- expression `*` : the expression repeats zero or more times
- expression `+` : the expression repeats one or more times
- `(` expression `)` :  the expression is delineated
