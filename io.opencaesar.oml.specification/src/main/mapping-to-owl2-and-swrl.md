# Mapping to OWL2 and SWRL # {#Mapping-to-Owl2-and-Swrl}

## Description Logic Semantics ## {#Description-Logic-Semantics}

Description Logic (DL) is a class of logic that is sufficiently expressive (between propositional and first-order logic) and decidable (in finite time). Since [OML is mappable to OWL2-DL](#Mapping-to-Owl2-and-Swrl), which is a subset of OWL2 that has DL semantics, OML models can be reasoned on with DL reasoners. Sevral over-the-shelf DL reasoner implementations exist such as [Pellet](https://github.com/stardog-union/pellet). There are two kinds of DL reasoning that can be performed on OML models: *satisfiability* analysis and *consistency* analysis.

Satisfiability analysis can be run on a vocabuly bundle to check that the types defined by that bundle are instantiable, i.e., valid instances can be created for each of them. The concern checked here is whether any type is over constrained (e.g. specializes two disjoint types) such that valid instances of the type cannot be created.

Consistency analysis can be run on a description bundle to check that the instances defined by that bundle are consistent with the rules of the used vocabularies. The concern checked here is whether any instance is involved in a logical contradition (e.g., two unequal instances assert different values to a functional property).

The reasoning process relies heavily on the inference semantics of the OML elements. These semantics are described by [mapping](#Mapping-to-Owl2-and-Swrl) OML elements to corresponding OWL2-DL elements, which have DL semantics described in the [OWL2 standard](https://www.w3.org/TR/owl2-syntax/). The DL semantics allow generating inferred statements (called entailments) from asserted statements (defined in OML models). Such inference process is run repeatedly until all possible entailments are generated or until a contradiction is detected. In the latter case, a proof of the contradiction (a minimum set of statements exemplifying the contradiction) is emitted for the user to inspect.

The [openCAESAR](https://github.com/opencaesar) project provides tools that enables running DL reasoning on OML models. The first tool, called [OWL Adapter](https://github.com/opencaesar/owl-adapter), maps OML models to correspond OWL2-DL models. The second tool, called [OWL Reason](https://github.com/opencaesar/owl-tools), runs a DL reasoner on the resulting OWL2-DL models and generates a reasoning report that report on reasoning problems if any.
