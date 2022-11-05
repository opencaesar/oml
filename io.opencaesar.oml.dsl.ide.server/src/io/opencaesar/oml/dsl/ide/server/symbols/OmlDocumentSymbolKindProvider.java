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

import io.opencaesar.oml.OmlPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper;

@SuppressWarnings("all")
public class OmlDocumentSymbolKindProvider extends DocumentSymbolMapper.DocumentSymbolKindProvider {
  @Override
  protected SymbolKind getSymbolKind(final EClass clazz) {
    SymbolKind _switchResult = null;
    boolean _matched = false;
    boolean _isSuperTypeOf = OmlPackage.Literals.ONTOLOGY.isSuperTypeOf(clazz);
    if (_isSuperTypeOf) {
      _matched=true;
      _switchResult = SymbolKind.Package;
    }
    if (!_matched) {
      boolean _isSuperTypeOf_1 = OmlPackage.Literals.ASPECT.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_1) {
        _matched=true;
        _switchResult = SymbolKind.Interface;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_2 = OmlPackage.Literals.ASPECT_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_2) {
        _matched=true;
        _switchResult = SymbolKind.Interface;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_3 = OmlPackage.Literals.CONCEPT.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_3) {
        _matched=true;
        _switchResult = SymbolKind.Class;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_4 = OmlPackage.Literals.CONCEPT_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_4) {
        _matched=true;
        _switchResult = SymbolKind.Class;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_5 = OmlPackage.Literals.STRUCTURE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_5) {
        _matched=true;
        _switchResult = SymbolKind.Struct;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_6 = OmlPackage.Literals.STRUCTURE_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_6) {
        _matched=true;
        _switchResult = SymbolKind.Struct;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_7 = OmlPackage.Literals.FACETED_SCALAR.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_7) {
        _matched=true;
        _switchResult = SymbolKind.String;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_8 = OmlPackage.Literals.FACETED_SCALAR_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_8) {
        _matched=true;
        _switchResult = SymbolKind.String;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_9 = OmlPackage.Literals.ENUMERATED_SCALAR.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_9) {
        _matched=true;
        _switchResult = SymbolKind.Enum;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_10 = OmlPackage.Literals.ENUMERATED_SCALAR_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_10) {
        _matched=true;
        _switchResult = SymbolKind.Enum;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_11 = OmlPackage.Literals.RELATION_ENTITY.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_11) {
        _matched=true;
        _switchResult = SymbolKind.Class;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_12 = OmlPackage.Literals.RELATION_ENTITY_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_12) {
        _matched=true;
        _switchResult = SymbolKind.Class;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_13 = OmlPackage.Literals.FORWARD_RELATION.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_13) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_14 = OmlPackage.Literals.REVERSE_RELATION.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_14) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_15 = OmlPackage.Literals.ANNOTATION_PROPERTY.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_15) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_16 = OmlPackage.Literals.ANNOTATION_PROPERTY_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_16) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_17 = OmlPackage.Literals.SCALAR_PROPERTY.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_17) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_18 = OmlPackage.Literals.SCALAR_PROPERTY_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_18) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_19 = OmlPackage.Literals.STRUCTURED_PROPERTY.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_19) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_20 = OmlPackage.Literals.STRUCTURED_PROPERTY_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_20) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_21 = OmlPackage.Literals.CONCEPT_INSTANCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_21) {
        _matched=true;
        _switchResult = SymbolKind.Object;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_22 = OmlPackage.Literals.CONCEPT_INSTANCE_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_22) {
        _matched=true;
        _switchResult = SymbolKind.Object;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_23 = OmlPackage.Literals.RELATION_INSTANCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_23) {
        _matched=true;
        _switchResult = SymbolKind.Object;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_24 = OmlPackage.Literals.RELATION_INSTANCE_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_24) {
        _matched=true;
        _switchResult = SymbolKind.Object;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_25 = OmlPackage.Literals.RULE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_25) {
        _matched=true;
        _switchResult = SymbolKind.Object;
      }
    }
    if (!_matched) {
      boolean _isSuperTypeOf_26 = OmlPackage.Literals.RULE_REFERENCE.isSuperTypeOf(clazz);
      if (_isSuperTypeOf_26) {
        _matched=true;
        _switchResult = SymbolKind.Object;
      }
    }
    if (!_matched) {
      _switchResult = SymbolKind.Property;
    }
    return _switchResult;
  }
}
