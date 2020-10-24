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
package io.opencaesar.oml.dsl.ide.server

import java.util.Map
import io.opencaesar.oml.dsl.settings.JsonFileBasedPreferenceValues
import io.opencaesar.oml.dsl.settings.PreferenceValuesProvider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.preferences.IPreferenceValues
import org.eclipse.xtext.preferences.PreferenceKey

class OmlExclusionProvider {
	
	static val EXCLUSION_PATHS = new PreferenceKey("excludePath", "")

	Map<URI, IPreferenceValues> preferences = newHashMap
	
	@SuppressWarnings("unchecked")
	def isExcluded(URI uri, URI projectURI) {
		val uriAsString = uri.toString
		val excludedSegments = getPreferences(projectURI).getPreference(EXCLUSION_PATHS) 
		if (excludedSegments !== null && !excludedSegments.empty) {
			val truncatedProjectURI = if (projectURI.lastSegment.empty) projectURI.trimSegments(1) else projectURI 
			val excludedPaths = excludedSegments.split(':').map[ path |
				truncatedProjectURI
					.appendSegments(path.split('/').filter[!empty])
					.appendSegment('')
					.toString
			]
			return excludedPaths.exists[
				uriAsString.startsWith(it)
			]
		}
		return false
	}

	private def getPreferences(URI projectURI) {
		val prefs = preferences.get(projectURI) ?: {
			val newPrefs = PreferenceValuesProvider.createPreferenceValues(projectURI)
			preferences.put(projectURI, newPrefs)
			newPrefs
		}
		if (prefs instanceof JsonFileBasedPreferenceValues)
			prefs.checkIsUpToDate
		prefs
	}
}
