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
package io.opencaesar.oml.dsl.settings;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceValuesByLanguage;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;

@Log
@SuppressWarnings("all")
public class PreferenceValuesProvider implements IPreferenceValuesProvider {

	@Inject(optional = true)
	private IProjectConfigProvider configProvider;

	@Inject
	private LanguageInfo language;

	private List<Procedure2<? super IPreferenceValues, ? super Resource>> onChangeListeners = new ArrayList<>();

	private static final Logger LOG = Logger.getLogger(PreferenceValuesProvider.class);

	@Override
	public IPreferenceValues getPreferenceValues(final Resource context) {
		if ((context == null)) {
			return new MapBasedPreferenceValues(Collections.emptyMap());
		}
		var valuesByLanguage = PreferenceValuesByLanguage.findInEmfObject(context.getResourceSet());
		if (valuesByLanguage == null) {
			valuesByLanguage = new PreferenceValuesByLanguage();
			valuesByLanguage.attachToEmfObject(context.getResourceSet());	
		}

		var values = valuesByLanguage.get(language.getLanguageName());
		if (values != null) {
			URI uri = null;
			if (configProvider != null) {
				var c = configProvider.getProjectConfig(context.getResourceSet());
				if (c != null) {
					uri = c.getPath();
				}
			}
			createPreferenceValues(uri);
		}
		valuesByLanguage.put(language.getLanguageName(), values);
		
		if ((values instanceof JsonFileBasedPreferenceValues)) {
			if (!((JsonFileBasedPreferenceValues) values).checkIsUpToDate()) {
				for (var listener : onChangeListeners) {
					listener.apply(values, context);
				}
			}
		}
		return values;
	}

	public static IPreferenceValues createPreferenceValues(final URI projectURI) {
		try {
			var result = new MapBasedPreferenceValues(constantSettings);
			final var userHome = Paths.get(StandardSystemProperty.USER_HOME.value());
			final var userSettings = userHome.resolve(".oml").resolve("oml.settings");
			result = new JsonFileBasedPreferenceValues(userSettings, result);
			if (projectURI == null) {
				return result;
			}
			final var segmentsToRemove = (projectURI.lastSegment().isEmpty()) ? 1 : 0;
			
			// add workspace settings
			final var workspaceDirectory = new java.net.URI(projectURI.trimSegments(segmentsToRemove + 1).toString());
			final var workspaceSettings = Paths.get(workspaceDirectory).resolve("oml.settings");
			result = new JsonFileBasedPreferenceValues(workspaceSettings, result);
			
			// add project settings
			final var projectDirectory = new java.net.URI(projectURI.trimSegments(segmentsToRemove).toString());
			final var projectSettings = Paths.get(projectDirectory).resolve("oml.settings");
			result = new JsonFileBasedPreferenceValues(projectSettings, result);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static final Map<String, String> constantSettings = new HashMap<>();

	public IDisposable registerChangeListener(Procedure2<? super IPreferenceValues, ? super Resource> callback) {
		this.onChangeListeners.add(callback);
		return () -> {
			this.onChangeListeners.remove(callback);
		};
	}
}
