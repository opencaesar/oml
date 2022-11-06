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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.util.internal.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;

@Log
@SuppressWarnings("all")
public class JsonFileBasedPreferenceValues extends MapBasedPreferenceValues {

	private final Path path;

	private FileTime lastModification = null;

	private static final Logger LOG = Logger.getLogger(JsonFileBasedPreferenceValues.class);

	public JsonFileBasedPreferenceValues(final Path path, final IPreferenceValues delegate) {
		super(delegate, new HashMap<>());
		this.path = path;
	}

	/**
	 * reloads the preferences from disk if the file has changed.
	 * 
	 * @return whether
	 */
	public boolean checkIsUpToDate() {
		boolean result = true;
		final var d = this.getDelegate();
		if (d instanceof JsonFileBasedPreferenceValues) {
			result &= ((JsonFileBasedPreferenceValues) d).checkIsUpToDate();
		}
		try {
			final var localLastMod = Files.getLastModifiedTime(path);
			if (localLastMod != lastModification) {
				lastModification = localLastMod;
				read();
				return false;
			}
		} catch (final Exception e) {
			if (!(e instanceof NoSuchFileException)) {
				LOG.error("Error reading settings '" + path + "' : " + e.getMessage());
			} else {
				lastModification = null;
			}
			if (!getValues().isEmpty()) {
				clear();
				return false;
			}
		}
		return result;
	}

	public void read() {
		try {
			clear();
			final var bytes = Files.readAllBytes(path);
			final var reader = new JsonReader(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes))));
			reader.setLenient(true);
			final var object = Streams.parse(reader);
			if (object instanceof JsonObject) {		
				internalFillMap(null, (JsonObject)object);
			} else {
				LOG.error("The oml.settings file, did not contain a top level object.");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void internalFillMap(final String prefix, final JsonObject object) {
		for (var entry : object.entrySet()) {
			var v = entry.getValue();
			if (v instanceof JsonObject) {
				internalFillMap(entry.getKey(), (JsonObject) entry.getValue());
			} else if (v instanceof JsonPrimitive) {
				String key = null;
				if (prefix != null) {
					key = prefix + "." + entry.getKey();
				} else {
					key = entry.getKey();
				}
				this.put(key, v.getAsString().toString());			
			}
		}
	}

}
