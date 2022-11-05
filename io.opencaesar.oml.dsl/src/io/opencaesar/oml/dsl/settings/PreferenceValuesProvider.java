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

import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
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
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@Log
@Singleton
@SuppressWarnings("all")
public class PreferenceValuesProvider implements IPreferenceValuesProvider {
  @Inject(optional = true)
  private IProjectConfigProvider configProvider;

  @Inject
  private LanguageInfo language;

  private List<Procedure2<? super IPreferenceValues, ? super Resource>> onChangeListeners = CollectionLiterals.<Procedure2<? super IPreferenceValues, ? super Resource>>newArrayList();

  @Override
  public IPreferenceValues getPreferenceValues(final Resource context) {
    if ((context == null)) {
      Map<String, String> _emptyMap = CollectionLiterals.<String, String>emptyMap();
      return new MapBasedPreferenceValues(_emptyMap);
    }
    PreferenceValuesByLanguage _elvis = null;
    PreferenceValuesByLanguage _findInEmfObject = PreferenceValuesByLanguage.findInEmfObject(context.getResourceSet());
    if (_findInEmfObject != null) {
      _elvis = _findInEmfObject;
    } else {
      PreferenceValuesByLanguage _preferenceValuesByLanguage = new PreferenceValuesByLanguage();
      final Procedure1<PreferenceValuesByLanguage> _function = (PreferenceValuesByLanguage it) -> {
        it.attachToEmfObject(context.getResourceSet());
      };
      PreferenceValuesByLanguage _doubleArrow = ObjectExtensions.<PreferenceValuesByLanguage>operator_doubleArrow(_preferenceValuesByLanguage, _function);
      _elvis = _doubleArrow;
    }
    final PreferenceValuesByLanguage valuesByLanguage = _elvis;
    IPreferenceValues _elvis_1 = null;
    IPreferenceValues _get = valuesByLanguage.get(this.language.getLanguageName());
    if (_get != null) {
      _elvis_1 = _get;
    } else {
      IProjectConfig _projectConfig = null;
      if (this.configProvider!=null) {
        _projectConfig=this.configProvider.getProjectConfig(context.getResourceSet());
      }
      URI _path = null;
      if (_projectConfig!=null) {
        _path=_projectConfig.getPath();
      }
      IPreferenceValues _createPreferenceValues = PreferenceValuesProvider.createPreferenceValues(_path);
      _elvis_1 = _createPreferenceValues;
    }
    IPreferenceValues values = _elvis_1;
    valuesByLanguage.put(this.language.getLanguageName(), values);
    if ((values instanceof JsonFileBasedPreferenceValues)) {
      boolean _checkIsUpToDate = ((JsonFileBasedPreferenceValues)values).checkIsUpToDate();
      boolean _not = (!_checkIsUpToDate);
      if (_not) {
        for (final Procedure2<? super IPreferenceValues, ? super Resource> listener : this.onChangeListeners) {
          listener.apply(values, context);
        }
      }
    }
    return values;
  }

  public static IPreferenceValues createPreferenceValues(final URI projectURI) {
    try {
      MapBasedPreferenceValues result = new MapBasedPreferenceValues(PreferenceValuesProvider.constantSettings);
      final Path userHome = Paths.get(StandardSystemProperty.USER_HOME.value());
      final Path userSettings = userHome.resolve(".oml").resolve("oml.settings");
      JsonFileBasedPreferenceValues _jsonFileBasedPreferenceValues = new JsonFileBasedPreferenceValues(userSettings, result);
      result = _jsonFileBasedPreferenceValues;
      if ((projectURI == null)) {
        return result;
      }
      int _xifexpression = (int) 0;
      boolean _isEmpty = projectURI.lastSegment().isEmpty();
      if (_isEmpty) {
        _xifexpression = 1;
      } else {
        _xifexpression = 0;
      }
      final int segmentsToRemove = _xifexpression;
      String _string = projectURI.trimSegments((segmentsToRemove + 1)).toString();
      final java.net.URI workspaceDirectory = new java.net.URI(_string);
      final Path workspaceSettings = Paths.get(workspaceDirectory).resolve("oml.settings");
      JsonFileBasedPreferenceValues _jsonFileBasedPreferenceValues_1 = new JsonFileBasedPreferenceValues(workspaceSettings, result);
      result = _jsonFileBasedPreferenceValues_1;
      String _string_1 = projectURI.trimSegments(segmentsToRemove).toString();
      final java.net.URI projectDirectory = new java.net.URI(_string_1);
      final Path projectSettings = Paths.get(projectDirectory).resolve("oml.settings");
      JsonFileBasedPreferenceValues _jsonFileBasedPreferenceValues_2 = new JsonFileBasedPreferenceValues(projectSettings, result);
      result = _jsonFileBasedPreferenceValues_2;
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public static final Map<String, String> constantSettings = CollectionLiterals.<String, String>newHashMap();

  public IDisposable registerChangeListener(final Procedure2<? super IPreferenceValues, ? super Resource> callback) {
    this.onChangeListeners.add(callback);
    final IDisposable _function = () -> {
      this.onChangeListeners.remove(callback);
    };
    return _function;
  }

  private static final Logger LOG = Logger.getLogger(PreferenceValuesProvider.class);
}
