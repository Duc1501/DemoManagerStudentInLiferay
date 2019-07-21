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

package com.lcd.demo.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Smile
 */
public class StudentLocalServiceClp implements StudentLocalService {
	public StudentLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addStudentMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addStudent", com.lcd.demo.model.Student.class);

		_createStudentMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createStudent", long.class);

		_deleteStudentMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteStudent", long.class);

		_deleteStudentMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteStudent", com.lcd.demo.model.Student.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchStudentMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchStudent", long.class);

		_getStudentMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getStudent", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getStudentsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getStudents", int.class, int.class);

		_getStudentsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getStudentsCount");

		_updateStudentMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateStudent", com.lcd.demo.model.Student.class);

		_updateStudentMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateStudent", com.lcd.demo.model.Student.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_addStudentsMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"addStudents", java.lang.String.class, int.class,
				java.lang.String.class, int.class, java.lang.String.class,
				long.class, java.lang.String.class,
				com.liferay.portal.service.ServiceContext.class);

		_updateStudentMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateStudent", long.class, java.lang.String.class, int.class,
				java.lang.String.class, int.class, java.lang.String.class,
				long.class, java.lang.String.class,
				com.liferay.portal.service.ServiceContext.class);

		_getStudentMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getStudent", java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_getNamGenderAddressMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getNamGenderAddress", java.lang.String.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_getAddressMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAddress", java.lang.String.class, int.class, int.class);

		_getGenderMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getGender", java.lang.String.class, int.class, int.class);
	}

	public com.lcd.demo.model.Student addStudent(
		com.lcd.demo.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addStudentMethodKey0,
				ClpSerializer.translateInput(student));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public com.lcd.demo.model.Student createStudent(long studentId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createStudentMethodKey1,
				studentId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteStudentMethodKey2,
				studentId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteStudent(com.lcd.demo.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteStudentMethodKey3,
				ClpSerializer.translateInput(student));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.lcd.demo.model.Student fetchStudent(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchStudentMethodKey8,
				studentId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public com.lcd.demo.model.Student getStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getStudentMethodKey9,
				studentId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.lcd.demo.model.Student> getStudents(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getStudentsMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.lcd.demo.model.Student>)ClpSerializer.translateOutput(returnObj);
	}

	public int getStudentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getStudentsCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.lcd.demo.model.Student updateStudent(
		com.lcd.demo.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateStudentMethodKey13,
				ClpSerializer.translateInput(student));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public com.lcd.demo.model.Student updateStudent(
		com.lcd.demo.model.Student student, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateStudentMethodKey14,
				ClpSerializer.translateInput(student), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.lcd.demo.model.Student addStudents(java.lang.String name,
		int age, java.lang.String gender, int phone, java.lang.String address,
		long fileImage, java.lang.String linkImage,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addStudentsMethodKey17,
				ClpSerializer.translateInput(name), age,
				ClpSerializer.translateInput(gender), phone,
				ClpSerializer.translateInput(address), fileImage,
				ClpSerializer.translateInput(linkImage),
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public com.lcd.demo.model.Student updateStudent(long studentId,
		java.lang.String nameNew, int ageNew, java.lang.String genderNew,
		int phoneNew, java.lang.String addressNew, long fileImage,
		java.lang.String linkImage,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateStudentMethodKey18,
				studentId, ClpSerializer.translateInput(nameNew), ageNew,
				ClpSerializer.translateInput(genderNew), phoneNew,
				ClpSerializer.translateInput(addressNew), fileImage,
				ClpSerializer.translateInput(linkImage),
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.lcd.demo.model.Student)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.lcd.demo.model.Student> getStudent(
		java.lang.String name, java.lang.String gender,
		java.lang.String address, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getStudentMethodKey19,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(gender),
				ClpSerializer.translateInput(address), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.lcd.demo.model.Student>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.lcd.demo.model.Student> getNamGenderAddress(
		java.lang.String name, java.lang.String address,
		java.lang.String gender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getNamGenderAddressMethodKey20,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(address),
				ClpSerializer.translateInput(gender), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.lcd.demo.model.Student>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.lcd.demo.model.Student> getAddress(
		java.lang.String address, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAddressMethodKey21,
				ClpSerializer.translateInput(address), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.lcd.demo.model.Student>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.lcd.demo.model.Student> getGender(
		java.lang.String gender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getGenderMethodKey22,
				ClpSerializer.translateInput(gender), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.lcd.demo.model.Student>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addStudentMethodKey0;
	private MethodKey _createStudentMethodKey1;
	private MethodKey _deleteStudentMethodKey2;
	private MethodKey _deleteStudentMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchStudentMethodKey8;
	private MethodKey _getStudentMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getStudentsMethodKey11;
	private MethodKey _getStudentsCountMethodKey12;
	private MethodKey _updateStudentMethodKey13;
	private MethodKey _updateStudentMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _addStudentsMethodKey17;
	private MethodKey _updateStudentMethodKey18;
	private MethodKey _getStudentMethodKey19;
	private MethodKey _getNamGenderAddressMethodKey20;
	private MethodKey _getAddressMethodKey21;
	private MethodKey _getGenderMethodKey22;
}