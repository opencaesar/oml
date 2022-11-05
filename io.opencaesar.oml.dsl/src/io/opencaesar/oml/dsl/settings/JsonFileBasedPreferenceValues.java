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

import com.google.common.base.Objects;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Log
@SuppressWarnings("all")
public class JsonFileBasedPreferenceValues extends MapBasedPreferenceValues {
  private final Path path;

  private FileTime lastModification = null;

  public JsonFileBasedPreferenceValues(final Path path, final IPreferenceValues delegate) {
    super(delegate, CollectionLiterals.<String, String>newHashMap());
    this.path = path;
  }

  /**
   * reloads the preferences from disk if the file has changed.
   * @return whether
   */
  public boolean checkIsUpToDate() {
    boolean result = true;
    final IPreferenceValues d = this.getDelegate();
    if ((d instanceof JsonFileBasedPreferenceValues)) {
      result = (result && ((JsonFileBasedPreferenceValues)d).checkIsUpToDate());
    }
    try {
      final FileTime localLastMod = Files.getLastModifiedTime(this.path);
      boolean _notEquals = (!Objects.equal(localLastMod, this.lastModification));
      if (_notEquals) {
        this.lastModification = localLastMod;
        this.read();
        return false;
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        if ((!(e instanceof NoSuchFileException))) {
          String _message = e.getMessage();
          String _plus = ((("Error reading settings \'" + this.path) + "\' : ") + _message);
          JsonFileBasedPreferenceValues.LOG.error(_plus);
        } else {
          this.lastModification = null;
        }
        boolean _isEmpty = this.getValues().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          this.clear();
          return false;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return result;
  }

  public void read() {
    try {
      this.clear();
      final byte[] bytes = Files.readAllBytes(this.path);
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(bytes);
      InputStreamReader _inputStreamReader = new InputStreamReader(_byteArrayInputStream);
      BufferedReader _bufferedReader = new BufferedReader(_inputStreamReader);
      final JsonReader reader = new JsonReader(_bufferedReader);
      reader.setLenient(true);
      final JsonElement object = Streams.parse(reader);
      if ((object instanceof JsonObject)) {
        this.internalFillMap(null, ((JsonObject)object));
      } else {
        JsonFileBasedPreferenceValues.LOG.error("The oml.settings file, did not contain a top level object.");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private void internalFillMap(final String prefix, final JsonObject object) {
    Set<Map.Entry<String, JsonElement>> _entrySet = object.entrySet();
    for (final Map.Entry<String, JsonElement> entry : _entrySet) {
      JsonElement _value = entry.getValue();
      final JsonElement v = _value;
      boolean _matched = false;
      if (v instanceof JsonObject) {
        _matched=true;
        JsonElement _value_1 = entry.getValue();
        this.internalFillMap(entry.getKey(), ((JsonObject) _value_1));
      }
      if (!_matched) {
        if (v instanceof JsonPrimitive) {
          _matched=true;
          String _xifexpression = null;
          if ((prefix != null)) {
            String _key = entry.getKey();
            _xifexpression = ((prefix + ".") + _key);
          } else {
            _xifexpression = entry.getKey();
          }
          final String key = _xifexpression;
          this.put(key, ((JsonPrimitive)v).getAsString().toString());
        }
      }
    }
  }

  private static final Logger LOG = Logger.getLogger(JsonFileBasedPreferenceValues.class);
}
