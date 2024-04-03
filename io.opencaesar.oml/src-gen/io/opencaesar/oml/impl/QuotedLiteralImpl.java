/**
 * 
 * Copyright 2019-2022 California Institute of Technology ("Caltech").
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
package io.opencaesar.oml.impl;

import io.opencaesar.oml.Literal;
import io.opencaesar.oml.OmlPackage;
import io.opencaesar.oml.QuotedLiteral;
import io.opencaesar.oml.Scalar;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quoted Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.opencaesar.oml.impl.QuotedLiteralImpl#getValue <em>Value</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.QuotedLiteralImpl#getLangTag <em>Lang Tag</em>}</li>
 *   <li>{@link io.opencaesar.oml.impl.QuotedLiteralImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuotedLiteralImpl extends LiteralImpl implements QuotedLiteral {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLangTag() <em>Lang Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLangTag()
	 * @generated
	 * @ordered
	 */
	protected static final String LANG_TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLangTag() <em>Lang Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLangTag()
	 * @generated
	 * @ordered
	 */
	protected String langTag = LANG_TAG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Scalar type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuotedLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OmlPackage.Literals.QUOTED_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.QUOTED_LITERAL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLangTag() {
		return langTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLangTag(String newLangTag) {
		String oldLangTag = langTag;
		langTag = newLangTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.QUOTED_LITERAL__LANG_TAG, oldLangTag, langTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scalar getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Scalar)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OmlPackage.QUOTED_LITERAL__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scalar basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Scalar newType) {
		Scalar oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OmlPackage.QUOTED_LITERAL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLexicalValue() {
		String _value = this.getValue();
		String _plus = ("\"" + _value);
		String _plus_1 = (_plus + "\"");
		String _xifexpression = null;
		String _langTag = this.getLangTag();
		boolean _tripleNotEquals = (_langTag != null);
		if (_tripleNotEquals) {
			String _langTag_1 = this.getLangTag();
			_xifexpression = ("$" + _langTag_1);
		}
		else {
			String _xifexpression_1 = null;
			Scalar _type = this.getType();
			boolean _tripleNotEquals_1 = (_type != null);
			if (_tripleNotEquals_1) {
				String _abbreviatedIri = this.getType().getAbbreviatedIri();
				_xifexpression_1 = ("^^" + _abbreviatedIri);
			}
			else {
				_xifexpression_1 = "";
			}
			_xifexpression = _xifexpression_1;
		}
		return (_plus_1 + _xifexpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTypeIri() {
		String _xifexpression = null;
		Scalar _type = this.getType();
		boolean _tripleNotEquals = (_type != null);
		if (_tripleNotEquals) {
			_xifexpression = this.getType().getIri();
		}
		else {
			_xifexpression = "http://www.w3.org/2001/XMLSchema#string";
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OmlPackage.QUOTED_LITERAL__VALUE:
				return getValue();
			case OmlPackage.QUOTED_LITERAL__LANG_TAG:
				return getLangTag();
			case OmlPackage.QUOTED_LITERAL__TYPE:
				if (resolve) return getType();
				return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OmlPackage.QUOTED_LITERAL__VALUE:
				setValue((String)newValue);
				return;
			case OmlPackage.QUOTED_LITERAL__LANG_TAG:
				setLangTag((String)newValue);
				return;
			case OmlPackage.QUOTED_LITERAL__TYPE:
				setType((Scalar)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OmlPackage.QUOTED_LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case OmlPackage.QUOTED_LITERAL__LANG_TAG:
				setLangTag(LANG_TAG_EDEFAULT);
				return;
			case OmlPackage.QUOTED_LITERAL__TYPE:
				setType((Scalar)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OmlPackage.QUOTED_LITERAL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case OmlPackage.QUOTED_LITERAL__LANG_TAG:
				return LANG_TAG_EDEFAULT == null ? langTag != null : !LANG_TAG_EDEFAULT.equals(langTag);
			case OmlPackage.QUOTED_LITERAL__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Literal.class) {
			switch (baseOperationID) {
				case OmlPackage.LITERAL___GET_LEXICAL_VALUE: return OmlPackage.QUOTED_LITERAL___GET_LEXICAL_VALUE;
				case OmlPackage.LITERAL___GET_TYPE_IRI: return OmlPackage.QUOTED_LITERAL___GET_TYPE_IRI;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OmlPackage.QUOTED_LITERAL___GET_LEXICAL_VALUE:
				return getLexicalValue();
			case OmlPackage.QUOTED_LITERAL___GET_TYPE_IRI:
				return getTypeIri();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(", langTag: ");
		result.append(langTag);
		result.append(')');
		return result.toString();
	}

} //QuotedLiteralImpl
