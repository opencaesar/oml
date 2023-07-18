# Document Organization # {#Document-Organization}

This document describes the syntax, notation, semantics, and API of the Ontological Modeling Language (OML). The section named [Getting Started](#Getting-Started) walks the reader through and demonstrates the use cases of working with OML.

- The section [Language Reference](#Language-Reference) describes how to use OML to create a DSL for a given domain and what it means in terms of what system modelers in that domain would be able to model.

- The section [Textual BNF](#Textual-BNF) describes the BNF grammar of OML. This can help readers understand textual OML models and create them using an OML text editor. 

- The section [Grahical BNF](#Graphical-BNF) describes the graphical BNF grammar of OML. This can help readers understand standard OML diagrams.

- The section [Abstract Syntax](#Abstract-Syntax) describes the concepts that make up the OML syntax, along with their attibutes and relations. Hyperlinks are provided to help the reader navigate the concepts.

- The section [Public API](#Public-API) describes the OML public API that can be used to create tools that read or write OML models. Some of the public API maps directly from the corresponding OML abstract syntax. Other API adds useful functions that make working with OML easier programmatically.

- The section [Mapping to OWL2 and SWRL](#Mapping-to-Owl2-and-Swrl) describes the semantics of OML by mapping them to the semantics of OWL2 and SWRL. It accomplishes that by giving the mapping of every OML construct to a pattern defined in a subset of OWL2 and SWRL.

## Document Conventions ## {#Document-Conventions}

## BNF Conventions ## {#BNF-Conventions}

The document uses BNF notation to specify allowed expression syntax in the textual and graphical notation. The following BNF symbols are used:

- expression : the expression is required
- expression `?` : the expression is optional
- expression `*` : the expression repeats zero or more times
- expression `+` : the expression repeats one or more times
- `(` expression `)` :  the expression is delineated

Moreover, BNF grammar rules can compose other rules. In the following example, `Rule1` is composed of `Rule2`. 
```javascript
<Rule1>: Rule2
<Rule2>: ...
```

Rules may also cross reference other rules. In the following example, `Rule1` cross references `Rule2` using its `IRI` token.
```javascript
<Rule1>: [Rule2|IRI]
<Rule2>: IRI ...
<Rule3>: IRI ...
<IRI>: ...
```

This allows more precision than saying `<Rule1>: IRI`, which could ambiguously refer to the `IRI` of `Rule2` or `Rule3`.
