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

import com.lcd.demo.service.StudentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Smile
 */
public class StudentClp extends BaseModelImpl<Student> implements Student {
	public StudentClp() {
	}

	public Class<?> getModelClass() {
		return Student.class;
	}

	public String getModelClassName() {
		return Student.class.getName();
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_studentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public int getPhone() {
		return _phone;
	}

	public void setPhone(int phone) {
		_phone = phone;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public long getFileImage() {
		return _fileImage;
	}

	public void setFileImage(long fileImage) {
		_fileImage = fileImage;
	}

	public String getLinkImage() {
		return _linkImage;
	}

	public void setLinkImage(String linkImage) {
		_linkImage = linkImage;
	}

	public void persist() throws SystemException {
		StudentLocalServiceUtil.updateStudent(this);
	}

	@Override
	public Student toEscapedModel() {
		return (Student)Proxy.newProxyInstance(Student.class.getClassLoader(),
			new Class[] { Student.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentClp clone = new StudentClp();

		clone.setStudentId(getStudentId());
		clone.setName(getName());
		clone.setAge(getAge());
		clone.setGender(getGender());
		clone.setPhone(getPhone());
		clone.setAddress(getAddress());
		clone.setFileImage(getFileImage());
		clone.setLinkImage(getLinkImage());

		return clone;
	}

	public int compareTo(Student student) {
		int value = 0;

		if (getStudentId() < student.getStudentId()) {
			value = -1;
		}
		else if (getStudentId() > student.getStudentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StudentClp student = null;

		try {
			student = (StudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", age=");
		sb.append(getAge());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", fileImage=");
		sb.append(getFileImage());
		sb.append(", linkImage=");
		sb.append(getLinkImage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.lcd.demo.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>age</column-name><column-value><![CDATA[");
		sb.append(getAge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileImage</column-name><column-value><![CDATA[");
		sb.append(getFileImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkImage</column-name><column-value><![CDATA[");
		sb.append(getLinkImage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private String _name;
	private int _age;
	private String _gender;
	private int _phone;
	private String _address;
	private long _fileImage;
	private String _linkImage;
}