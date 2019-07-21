/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lcd.demo.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author    Smile
 * @see       Student
 * @generated
 */
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
	}

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
	}

	/**
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	public void setPrimaryKey(long primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the student ID of this student.
	*
	* @return the student ID of this student
	*/
	public long getStudentId() {
		return _student.getStudentId();
	}

	/**
	* Sets the student ID of this student.
	*
	* @param studentId the student ID of this student
	*/
	public void setStudentId(long studentId) {
		_student.setStudentId(studentId);
	}

	/**
	* Returns the name of this student.
	*
	* @return the name of this student
	*/
	public java.lang.String getName() {
		return _student.getName();
	}

	/**
	* Sets the name of this student.
	*
	* @param name the name of this student
	*/
	public void setName(java.lang.String name) {
		_student.setName(name);
	}

	/**
	* Returns the age of this student.
	*
	* @return the age of this student
	*/
	public int getAge() {
		return _student.getAge();
	}

	/**
	* Sets the age of this student.
	*
	* @param age the age of this student
	*/
	public void setAge(int age) {
		_student.setAge(age);
	}

	/**
	* Returns the gender of this student.
	*
	* @return the gender of this student
	*/
	public java.lang.String getGender() {
		return _student.getGender();
	}

	/**
	* Sets the gender of this student.
	*
	* @param gender the gender of this student
	*/
	public void setGender(java.lang.String gender) {
		_student.setGender(gender);
	}

	/**
	* Returns the phone of this student.
	*
	* @return the phone of this student
	*/
	public int getPhone() {
		return _student.getPhone();
	}

	/**
	* Sets the phone of this student.
	*
	* @param phone the phone of this student
	*/
	public void setPhone(int phone) {
		_student.setPhone(phone);
	}

	/**
	* Returns the address of this student.
	*
	* @return the address of this student
	*/
	public java.lang.String getAddress() {
		return _student.getAddress();
	}

	/**
	* Sets the address of this student.
	*
	* @param address the address of this student
	*/
	public void setAddress(java.lang.String address) {
		_student.setAddress(address);
	}

	/**
	* Returns the file image of this student.
	*
	* @return the file image of this student
	*/
	public long getFileImage() {
		return _student.getFileImage();
	}

	/**
	* Sets the file image of this student.
	*
	* @param fileImage the file image of this student
	*/
	public void setFileImage(long fileImage) {
		_student.setFileImage(fileImage);
	}

	/**
	* Returns the link image of this student.
	*
	* @return the link image of this student
	*/
	public java.lang.String getLinkImage() {
		return _student.getLinkImage();
	}

	/**
	* Sets the link image of this student.
	*
	* @param linkImage the link image of this student
	*/
	public void setLinkImage(java.lang.String linkImage) {
		_student.setLinkImage(linkImage);
	}

	public boolean isNew() {
		return _student.isNew();
	}

	public void setNew(boolean n) {
		_student.setNew(n);
	}

	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	public int compareTo(com.lcd.demo.model.Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.lcd.demo.model.Student> toCacheModel() {
		return _student.toCacheModel();
	}

	public com.lcd.demo.model.Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_student.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Student getWrappedStudent() {
		return _student;
	}

	public Student getWrappedModel() {
		return _student;
	}

	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private Student _student;
}