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
package io.opencaesar.oml.dsl.settings

import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.google.gson.internal.Streams
import com.google.gson.stream.JsonReader
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.attribute.FileTime
import org.eclipse.xtext.preferences.IPreferenceValues
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.util.internal.Log

@Log
class JsonFileBasedPreferenceValues extends MapBasedPreferenceValues {
	
	val Path path
	FileTime lastModification = null
	
	new(Path path, IPreferenceValues delegate) {
		super(delegate, newHashMap)
		this.path = path
	}
	
	/**
	 * reloads the preferences from disk if the file has changed.
	 * @return whether
	 */
	def boolean checkIsUpToDate() {
		var result = true
		val d = this.delegate
		if (d instanceof JsonFileBasedPreferenceValues) {
			result = result && d.checkIsUpToDate
		}
		try {
			val localLastMod = Files.getLastModifiedTime(path)
			if (localLastMod != lastModification) {
				lastModification = localLastMod
				read()
				return false
			}
		} catch (Exception e) {
			if (!(e instanceof NoSuchFileException)) {
				LOG.error("Error reading settings '" + path + "' : " + e.message)
			} else {
				lastModification = null
			}
			if (!values.isEmpty) {
				clear()
				return false
			}
		}
		return result
	}
	
	def void read() {
		clear()
		val bytes = Files.readAllBytes(path)
		val reader = new JsonReader(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes))))
		reader.lenient = true
		val object = Streams.parse(reader)
		if (object instanceof JsonObject) {		
			internalFillMap(null, object)
		} else {
			LOG.error("The oml.settings file, did not contain a top level object.")
		}
	}
	
	private def void internalFillMap(String prefix, JsonObject object) {
		for (entry : object.entrySet) {
			switch v : entry.value {
				JsonObject : 
					internalFillMap(entry.key, entry.value as JsonObject)
				JsonPrimitive : {
					val key = if (prefix !== null) {
						prefix + "." + entry.key
					} else {
						entry.key
					}
					this.put(key, v.asString.toString)				
				} 
			}
		}
	}
	
}