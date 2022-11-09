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

import com.google.common.base.Objects;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public class OmlQualifiedNameConverter implements IQualifiedNameConverter {

	@Override
	public String toString(final QualifiedName qualifiedName) {
		return qualifiedName.toString("");
	}

	@Override
	public QualifiedName toQualifiedName(final String qualifiedNameAsString) {
		var index = qualifiedNameAsString.lastIndexOf('#');
		if (index == -1) {
			index = qualifiedNameAsString.lastIndexOf('/');
		}
		if (index == -1) {
			index = qualifiedNameAsString.lastIndexOf(':');
		}
		if (index == -1) {
			return QualifiedName.create(qualifiedNameAsString);
		}
		final var base = qualifiedNameAsString.substring(0, index);
		final var sep = qualifiedNameAsString.substring(index, index+1);
		final var fragment = qualifiedNameAsString.substring(index+1);
		if (fragment.equals("")) {
			return QualifiedName.create(base, sep);
		} else {
			return QualifiedName.create(base, sep, fragment);
		}
	}
}
