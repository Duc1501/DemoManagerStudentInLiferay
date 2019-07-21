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

package com.lcd.demo.model.impl;

import com.lcd.demo.model.Student;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Smile
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", age=");
		sb.append(age);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", address=");
		sb.append(address);
		sb.append(", fileImage=");
		sb.append(fileImage);
		sb.append(", linkImage=");
		sb.append(linkImage);
		sb.append("}");

		return sb.toString();
	}

	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(studentId);

		if (name == null) {
			studentImpl.setName(StringPool.BLANK);
		}
		else {
			studentImpl.setName(name);
		}

		studentImpl.setAge(age);

		if (gender == null) {
			studentImpl.setGender(StringPool.BLANK);
		}
		else {
			studentImpl.setGender(gender);
		}

		studentImpl.setPhone(phone);

		if (address == null) {
			studentImpl.setAddress(StringPool.BLANK);
		}
		else {
			studentImpl.setAddress(address);
		}

		studentImpl.setFileImage(fileImage);

		if (linkImage == null) {
			studentImpl.setLinkImage(StringPool.BLANK);
		}
		else {
			studentImpl.setLinkImage(linkImage);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	public long studentId;
	public String name;
	public int age;
	public String gender;
	public int phone;
	public String address;
	public long fileImage;
	public String linkImage;
}