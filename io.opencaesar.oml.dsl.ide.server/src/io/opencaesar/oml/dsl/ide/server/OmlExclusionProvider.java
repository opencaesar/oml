/**
 * Copyright 2019 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.opencaesar.oml.dsl.ide.server;

import io.opencaesar.oml.dsl.settings.JsonFileBasedPreferenceValues;
import io.opencaesar.oml.dsl.settings.PreferenceValuesProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class OmlExclusionProvider {
	private static final PreferenceKey EXCLUSION_PATHS = new PreferenceKey("excludePath", "");

	private Map<URI, IPreferenceValues> preferences = CollectionLiterals.<URI, IPreferenceValues>newHashMap();

	@SuppressWarnings("unchecked")
	public boolean isExcluded(final URI uri, final URI projectURI) {
		final String uriAsString = uri.toString();
		final String excludedSegments = getPreferences(projectURI).getPreference(OmlExclusionProvider.EXCLUSION_PATHS);

		if ((excludedSegments != null) && (!excludedSegments.isEmpty())) {
			final URI truncatedProjectURI = projectURI.lastSegment().isEmpty() ? projectURI.trimSegments(1) : projectURI;

			final List<String> excludedSegmentPaths = (List<String>) Conversions.doWrapArray(excludedSegments.split(":"));
			final Stream<String> excludedPaths = excludedSegmentPaths.stream().map(path -> {
				final String[] nonEmptySegments = (String[]) Arrays.asList(path.split("/")).stream().filter(p -> !p.isEmpty()).toArray();
				return truncatedProjectURI.appendSegments(nonEmptySegments).appendSegment("").toString();
			});

			return excludedPaths.filter(path -> uriAsString.startsWith(path)).findFirst().isPresent();
		}

		return false;
	}

	private IPreferenceValues getPreferences(final URI projectURI) {
		IPreferenceValues prefs = this.preferences.get(projectURI);
		if (null == prefs) {
			final IPreferenceValues newPrefs = PreferenceValuesProvider.createPreferenceValues(projectURI);
			preferences.put(projectURI, newPrefs);
			prefs = newPrefs;
		}

		if (prefs instanceof JsonFileBasedPreferenceValues) {
			((JsonFileBasedPreferenceValues) prefs).checkIsUpToDate();
		}
		return prefs;
	}
}
