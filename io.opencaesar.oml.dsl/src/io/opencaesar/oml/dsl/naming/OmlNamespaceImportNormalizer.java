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
package io.opencaesar.oml.dsl.naming;

import com.google.common.base.Objects;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;

@SuppressWarnings("all")
public class OmlNamespaceImportNormalizer extends ImportNormalizer {

	private final String nsPrefix;

	private final QualifiedName nsURI;

	public OmlNamespaceImportNormalizer(final QualifiedName nsURI, final String nsPrefix, final boolean ignoreCase) {
		super(nsURI, false, ignoreCase);
		this.nsPrefix = nsPrefix;
		this.nsURI = nsURI;
	}

	@Override
	public QualifiedName resolve(final QualifiedName relativeName) {
		if (relativeName.getSegmentCount() == 3) {
			if (relativeName.getSegment(1).equals(":")) {
				final var prefix = relativeName.getFirstSegment();
				if (prefix.equals(nsPrefix)) {
					return nsURI.append(relativeName.getLastSegment());
				}
			}
		}
		return null;
	}

	@Override
	public QualifiedName deresolve(final QualifiedName fullyQualifiedName) {
		if ((fullyQualifiedName.startsWith(this.nsURI) && (!fullyQualifiedName.equals(this.nsURI)))) {
			final var name = fullyQualifiedName.getLastSegment();
			return QualifiedName.create(this.nsPrefix, ":", name);
		}
		return null;
	}
}
