package io.opencaesar.oml.dsl.naming

import org.eclipse.xtext.naming.QualifiedName

class OmlQualifiedName extends QualifiedName {
	
	static def OmlQualifiedName create(String fragment) {
		new OmlQualifiedName(fragment)
	}

	static def OmlQualifiedName create(String base, String sep) {
		new OmlQualifiedName(base, sep)
	}

	static def OmlQualifiedName create(String base, String sep, String fragment) {
		new OmlQualifiedName(base, sep, fragment)
	}

	String sep
	
	protected new(String fragment) {
		this(#[fragment], null)
	}

	protected new(String base, String sep) {
		this(#[base], sep)
	}
	
	protected new(String base, String sep, String fragment) {
		this(#[base, fragment], sep)
	}

	protected new(String[] segments, String sep) {
		super(segments)
		this.sep = sep
	}

	def String getSeparator() {
		sep
	}

	override String toString() {
		return toString(sep);
	}

	override String toString(String delimiter) {
		val segmentCount = getSegmentCount();
		switch (segmentCount) {
			case 0: return ""
			case 1: return getFirstSegment()
			default: {
				val builder = new StringBuilder();
				builder.append(getFirstSegment());
				for (var i = 1; i < segmentCount; i++) {
					builder.append(delimiter);
					builder.append(segments.get(i));
				}
				return builder.toString();
			}
		}
	}

	override boolean equals(Object obj) {
		if (obj===this)
			return true
		if (obj instanceof OmlQualifiedName) {
			return segments.join(sep) == obj.segments.join(sep)
		}
		return false;
	}

	override QualifiedName append(String segment) {
		val temp = this.toString()
		new OmlQualifiedName(temp, sep, segment)
	}

	override QualifiedName append(QualifiedName relativeQualifiedName) {
		val temp = this.toString()
		new OmlQualifiedName(temp, sep, relativeQualifiedName.toString())
	}

	override QualifiedName toLowerCase() {
		new OmlQualifiedName(this.toString().toLowerCase, sep)
	}

	override QualifiedName toUpperCase() {
		new OmlQualifiedName(this.toString().toUpperCase, sep)
	}

	override QualifiedName skipFirst(int skipCount) {
		val temp = super.skipFirst(skipCount)
		new OmlQualifiedName(temp.segments, sep)
	}

	override QualifiedName skipLast(int skipCount) {
		val temp = super.skipLast(skipCount)
		new OmlQualifiedName(temp.segments, sep)
	}

}