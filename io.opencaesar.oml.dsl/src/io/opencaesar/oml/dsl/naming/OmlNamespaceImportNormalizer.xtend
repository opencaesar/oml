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
package io.opencaesar.oml.dsl.naming

import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.ImportNormalizer

class OmlNamespaceImportNormalizer extends ImportNormalizer{
	
	val String nsPrefix
	val QualifiedName nsURI

	new(QualifiedName nsURI, String nsPrefix, boolean ignoreCase) {
		super(nsURI, false, ignoreCase);
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
	}
	
	override QualifiedName resolve(QualifiedName relativeName) {
		val last = relativeName.getLastSegment();
		if (last.contains(":")) {
			val data = last.split(":");
			if ((data.get(0)) == nsPrefix) {
				val x = nsURI.append(QualifiedName.create(data.get(1)));
				return x;
			}
			
		}
		return null;
	}
	
	override QualifiedName deresolve(QualifiedName fullyQualifiedName) {
		if (nsURI.getSegmentCount() < fullyQualifiedName.getSegmentCount()) {
			val name = fullyQualifiedName.skipFirst(nsURI.getSegmentCount());
			if (name.getSegmentCount() == 1) {
				val parentQualifiedName = fullyQualifiedName.skipLast(1)
				if (parentQualifiedName == nsURI) {
					val x = QualifiedName.create(nsPrefix+":"+name.getLastSegment());
					return x;
				}
			}
		}
		return null;
	}

}