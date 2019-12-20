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

import org.eclipse.xtext.nodemodel.INode

class STRINGValueConverter extends org.eclipse.xtext.conversion.impl.STRINGValueConverter {
	
	override protected String toEscapedString(String value) {
		if (value.contains('\r') || value.contains('\n')) {
 			if (!value.contains('"""')) {
				return '"""' + value + '"""'
			} else if (!value.contains("'''")) {
				return "'''" + value + "'''"
			}
		} else {
 			if (value.contains('"')) {
				return "'" + value + "'"
			}
		}
		return '"' + value + '"' 
	}
	
	override String toValue(String string, INode node) {
		if (string.contains('"""')) {
			return string.replaceAll('"""', '')
		} else if (string.contains("'''")) {
			return string.replaceAll("'''", '')
		}
		return string.substring(1, string.length() - 1)
	}

}