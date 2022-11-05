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
package io.opencaesar.oml.dsl.conversion;

import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class STRINGValueConverter extends org.eclipse.xtext.conversion.impl.STRINGValueConverter {
  @Override
  protected String toEscapedString(final String value) {
    if (((!value.contains("\r")) && (!value.contains("\n")))) {
      boolean _contains = value.contains("\"");
      if (_contains) {
        boolean _contains_1 = value.contains("\'");
        boolean _not = (!_contains_1);
        if (_not) {
          return (("\'" + value) + "\'");
        }
      } else {
        return (("\"" + value) + "\"");
      }
    }
    boolean _contains_2 = value.contains("\'\'\'");
    if (_contains_2) {
      return (("\"\"\"" + value) + "\"\"\"");
    } else {
      return (("\'\'\'" + value) + "\'\'\'");
    }
  }

  @Override
  public String toValue(final String string, final INode node) {
    boolean _contains = string.contains("\"\"\"");
    if (_contains) {
      return string.replaceAll("\"\"\"", "");
    } else {
      boolean _contains_1 = string.contains("\'\'\'");
      if (_contains_1) {
        return string.replaceAll("\'\'\'", "");
      }
    }
    int _length = string.length();
    int _minus = (_length - 1);
    return string.substring(1, _minus);
  }
}
