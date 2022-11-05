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

import com.google.inject.Inject;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class RefValueConverter extends IRIValueConverter {
  @Inject
  private ABBREV_IRIValueConverter abbrev_iriValueConverter;

  @Override
  public String elseToString(final String value) {
    return this.abbrev_iriValueConverter.toString(value);
  }

  @Override
  public String elseToValue(final String string, final INode node) {
    return this.abbrev_iriValueConverter.toValue(string, null);
  }
}
