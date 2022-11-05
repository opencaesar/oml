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
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

@SuppressWarnings("all")
public class OmlValueConverterService extends DefaultTerminalConverters {
  @Inject
  private NAMESPACEValueConverter namespaceValueConverter;

  @Inject
  private IRIValueConverter iriValueConverter;

  @Inject
  private RefValueConverter refValueConverter;

  @Inject
  private STRINGValueConverter stringValueConverter2;

  @ValueConverter(rule = "NAMESPACE")
  public IValueConverter<String> TerminalsNAMESPACE() {
    return this.namespaceValueConverter;
  }

  @ValueConverter(rule = "IRI")
  public IValueConverter<String> TerminalsIRI() {
    return this.iriValueConverter;
  }

  @ValueConverter(rule = "Ref")
  public IValueConverter<String> TerminalsRef() {
    return this.refValueConverter;
  }

  @ValueConverter(rule = "STRING")
  @Override
  public IValueConverter<String> TerminalsSTRING() {
    return this.stringValueConverter2;
  }
}
