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
package io.opencaesar.oml.dsl.ide.diagram;

import org.eclipse.sprotty.Action;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class FilterAction implements Action {

	public static final String KIND = "filter";

	private String kind = KIND;

	private String data;

	public FilterAction(final String data) {
		this.data = data;
	}

	@Pure
	@Override
	public String getKind() {
		return this.kind;
	}

	public void setKind(final String kind) {
		this.kind = kind;
	}

	@Pure
	public String getData() {
		return this.data;
	}

	public void setData(final String data) {
		this.data = data;
	}

	@Override
	@Pure
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilterAction other = (FilterAction) obj;
		if (this.kind == null) {
			if (other.kind != null)
				return false;
		} else if (!this.kind.equals(other.kind))
			return false;
		if (this.data == null) {
			if (other.data != null)
				return false;
		} else if (!this.data.equals(other.data))
			return false;
		return true;
	}

	@Override
	@Pure
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.kind == null) ? 0 : this.kind.hashCode());
		return prime * result + ((this.data == null) ? 0 : this.data.hashCode());
	}

	@Override
	@Pure
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.skipNulls();
		b.add("kind", this.kind);
		b.add("data", this.data);
		return b.toString();
	}
}
