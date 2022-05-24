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

import io.opencaesar.oml.dsl.naming.OmlQualifiedName
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName

class OmlQualifiedNameConverter implements IQualifiedNameConverter {
	
	override String toString(QualifiedName qualifiedName) {
		return qualifiedName.toString()
	}

	override QualifiedName toQualifiedName(String qualifiedNameAsString) {
		var index = qualifiedNameAsString.lastIndexOf('#')
		if (index === -1) {
			index = qualifiedNameAsString.lastIndexOf('/')
		}
		if (index === -1) {
			index = qualifiedNameAsString.lastIndexOf(':')
		}
		if (index === -1) {
			return OmlQualifiedName.create(qualifiedNameAsString)
		}
		val base = qualifiedNameAsString.substring(0, index)
		val sep = qualifiedNameAsString.substring(index, index+1)
		val fragment = qualifiedNameAsString.substring(index+1)
		if (fragment == "") {
			return OmlQualifiedName.create(base, sep);
		} else {
			return OmlQualifiedName.create(base, sep, fragment);
		}
	}
	
}
