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

package com.lcd.demo.service.persistence;

import com.lcd.demo.model.Student;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Smile
 * @see StudentPersistenceImpl
 * @see StudentUtil
 * @generated
 */
public interface StudentPersistence extends BasePersistence<Student> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public void cacheResult(com.lcd.demo.model.Student student);

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public void cacheResult(java.util.List<com.lcd.demo.model.Student> students);

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public com.lcd.demo.model.Student create(long studentId);

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student remove(long studentId)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lcd.demo.model.Student updateImpl(
		com.lcd.demo.model.Student student, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student with the primary key or throws a {@link com.lcd.demo.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByPrimaryKey(long studentId)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student fetchByPrimaryKey(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where name LIKE &#63;.
	*
	* @param name the name
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the primary key of the current student
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student[] findByName_PrevAndNext(long studentId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where address LIKE &#63;.
	*
	* @param address the address
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByAddress(
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where address LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByAddress(
		java.lang.String address, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where address LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByAddress(
		java.lang.String address, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where address LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByAddress_First(
		java.lang.String address,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where address LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByAddress_Last(
		java.lang.String address,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where address LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the primary key of the current student
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student[] findByAddress_PrevAndNext(
		long studentId, java.lang.String address,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where gender LIKE &#63;.
	*
	* @param gender the gender
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByGender(
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByGender(
		java.lang.String gender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByGender(
		java.lang.String gender, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByGender_First(
		java.lang.String gender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByGender_Last(
		java.lang.String gender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the primary key of the current student
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student[] findByGender_PrevAndNext(
		long studentId, java.lang.String gender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where name = &#63; and address = &#63;.
	*
	* @param name the name
	* @param address the address
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByN_A(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where name = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByN_A(
		java.lang.String name, java.lang.String address, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where name = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByN_A(
		java.lang.String name, java.lang.String address, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where name = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByN_A_First(java.lang.String name,
		java.lang.String address,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where name = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByN_A_Last(java.lang.String name,
		java.lang.String address,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where name = &#63; and address = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the primary key of the current student
	* @param name the name
	* @param address the address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student[] findByN_A_PrevAndNext(long studentId,
		java.lang.String name, java.lang.String address,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByN_A_G(
		java.lang.String name, java.lang.String address, java.lang.String gender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByN_A_G(
		java.lang.String name, java.lang.String address,
		java.lang.String gender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findByN_A_G(
		java.lang.String name, java.lang.String address,
		java.lang.String gender, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByN_A_G_First(java.lang.String name,
		java.lang.String address, java.lang.String gender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.lcd.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student findByN_A_G_Last(java.lang.String name,
		java.lang.String address, java.lang.String gender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studentId the primary key of the current student
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lcd.demo.model.Student[] findByN_A_G_PrevAndNext(
		long studentId, java.lang.String name, java.lang.String address,
		java.lang.String gender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lcd.demo.NoSuchStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students.
	*
	* @return the students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lcd.demo.model.Student> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where name LIKE &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where address LIKE &#63; from the database.
	*
	* @param address the address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAddress(java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where gender LIKE &#63; from the database.
	*
	* @param gender the gender
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGender(java.lang.String gender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where name = &#63; and address = &#63; from the database.
	*
	* @param name the name
	* @param address the address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_A(java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63; from the database.
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_A_G(java.lang.String name, java.lang.String address,
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where name LIKE &#63;.
	*
	* @param name the name
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where address LIKE &#63;.
	*
	* @param address the address
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByAddress(java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where gender LIKE &#63;.
	*
	* @param gender the gender
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByGender(java.lang.String gender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where name = &#63; and address = &#63;.
	*
	* @param name the name
	* @param address the address
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_A(java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	*
	* @param name the name
	* @param address the address
	* @param gender the gender
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_A_G(java.lang.String name, java.lang.String address,
		java.lang.String gender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Student remove(Student student) throws SystemException;
}