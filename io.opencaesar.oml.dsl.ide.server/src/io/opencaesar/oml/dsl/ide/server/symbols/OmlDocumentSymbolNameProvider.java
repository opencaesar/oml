/**
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.dsl.ide.server.symbols;

import io.opencaesar.oml.AnnotationPropertyReference;
import io.opencaesar.oml.AspectReference;
import io.opencaesar.oml.ConceptReference;
import io.opencaesar.oml.EnumeratedScalarReference;
import io.opencaesar.oml.FacetedScalarReference;
import io.opencaesar.oml.Member;
import io.opencaesar.oml.Ontology;
import io.opencaesar.oml.RelationEntityReference;
import io.opencaesar.oml.RelationReference;
import io.opencaesar.oml.RuleReference;
import io.opencaesar.oml.ScalarPropertyReference;
import io.opencaesar.oml.StructuredPropertyReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper;

@SuppressWarnings("all")
public class OmlDocumentSymbolNameProvider extends DocumentSymbolMapper.DocumentSymbolNameProvider {
  @Override
  public String getName(final EObject object) {
    boolean _matched = false;
    if (object instanceof Ontology) {
      _matched=true;
      return ((Ontology)object).getIri();
    }
    if (!_matched) {
      if (object instanceof Member) {
        _matched=true;
        return ((Member)object).getName();
      }
    }
    if (!_matched) {
      if (object instanceof RelationReference) {
        _matched=true;
        return ((RelationReference)object).getRelation().getName();
      }
    }
    if (!_matched) {
      if (object instanceof RuleReference) {
        _matched=true;
        return ((RuleReference)object).getRule().getName();
      }
    }
    if (!_matched) {
      if (object instanceof AnnotationPropertyReference) {
        _matched=true;
        return ((AnnotationPropertyReference)object).getProperty().getName();
      }
    }
    if (!_matched) {
      if (object instanceof AspectReference) {
        _matched=true;
        return ((AspectReference)object).getAspect().getName();
      }
    }
    if (!_matched) {
      if (object instanceof ConceptReference) {
        _matched=true;
        return ((ConceptReference)object).getConcept().getName();
      }
    }
    if (!_matched) {
      if (object instanceof RelationEntityReference) {
        _matched=true;
        return ((RelationEntityReference)object).getEntity().getName();
      }
    }
    if (!_matched) {
      if (object instanceof EnumeratedScalarReference) {
        _matched=true;
        return ((EnumeratedScalarReference)object).getScalar().getName();
      }
    }
    if (!_matched) {
      if (object instanceof FacetedScalarReference) {
        _matched=true;
        return ((FacetedScalarReference)object).getScalar().getName();
      }
    }
    if (!_matched) {
      if (object instanceof ScalarPropertyReference) {
        _matched=true;
        return ((ScalarPropertyReference)object).getProperty().getName();
      }
    }
    if (!_matched) {
      if (object instanceof StructuredPropertyReference) {
        _matched=true;
        return ((StructuredPropertyReference)object).getProperty().getName();
      }
    }
    return "<unnamed>";
  }
}
