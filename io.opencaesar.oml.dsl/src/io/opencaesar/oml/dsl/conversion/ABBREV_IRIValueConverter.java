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

import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

@SuppressWarnings("all")
public class ABBREV_IRIValueConverter extends QualifiedNameValueConverter {

	protected String getDelimiter() {
		return ":";
	}

	@Override
	public String getStringNamespaceDelimiter() {
		return getDelimiter();
	}

	@Override
	public String getValueNamespaceDelimiter() {
		return getDelimiter();
	}

	@Override
	public String toString(final String value) {
		final String string = super.toString(value);
		if (string.contains(getDelimiter())) {
			return string.replaceAll("^", "");
		} else {
			return string;
		}
	}
}
