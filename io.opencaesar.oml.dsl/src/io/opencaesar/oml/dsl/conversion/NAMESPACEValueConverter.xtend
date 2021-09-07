/**
 * 
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
 * 
 */
package io.opencaesar.oml.dsl.conversion

import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractValueConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings

class NAMESPACEValueConverter extends AbstractValueConverter<String> {

	override String toString(String value) {
		if (value.startsWith("http://")) {
			return '<' + Strings.convertToJavaString(value, false) + '>'
		} else {
			return elseToString(value)
		}
	}

	def elseToString(String value) {
		return Strings.convertToJavaString(value, false)
	}

	override toValue(String string, INode node) {
		if (string === null) {
			return null;
		}
		try {
			if (string.startsWith('<') && string.endsWith('>')) {
				return Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
			} else {
				return elseToValue(string, node)
			}
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
	
	def elseToValue(String string, INode node) {
		return Strings.convertFromJavaString(string, true)
	}
	
}