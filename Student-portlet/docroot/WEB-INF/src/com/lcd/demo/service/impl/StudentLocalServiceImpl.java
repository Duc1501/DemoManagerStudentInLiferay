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

package com.lcd.demo.service.impl;
import java.util.List;


import com.lcd.demo.model.Student;
import com.lcd.demo.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	public Student addStudents(String name, int age, String gender, int phone, String address,
			long fileImage,String linkImage, ServiceContext serviceContext)throws PortalException, SystemException{		
		long studentId = counterLocalService.increment(Student.class.getName());	
		//update student
		Student student = studentLocalService.createStudent(studentId);
		student.setName(name);
		student.setAge(age);
		student.setGender(gender);			
		student.setPhone(phone);
		student.setAddress(address);
//		student.setFileImage(fileImage);
//		student.setLinkImage(linkImage);

//		long fileEntryId = counterLocalService.increment();			
//		DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.createDLFileEntry(fileEntryId); 
		// luu file
		// fileImage = dlFileEntryLocalServiceUtil.updateFile
		
		student.setFileImage(fileImage);
		
		// update 		
		return studentLocalService.updateStudent(student);
	}
	

	public Student updateStudent(long studentId, String nameNew, int ageNew, String genderNew, int phoneNew, String addressNew, long fileImage,String linkImage, ServiceContext serviceContext)throws PortalException,SystemException{
		Student student = studentPersistence.findByPrimaryKey(studentId);			
		student.setName(nameNew);
		student.setAge(ageNew);
		student.setGender(genderNew);
		student.setPhone(phoneNew);
		student.setAddress(addressNew);	
		student.setFileImage(fileImage);
		student.setLinkImage(linkImage);
		
		// dlFileEntryLocalServiceUtil.updateFile
		
		student = studentLocalService.updateStudent(student);
		
		return student;
	}

	@Override
	public List<Student> getStudent(String name, String gender, String address,
			int start, int end) throws SystemException {
		List<Student> student =studentFinder.findByName(name, start, end);
		return student;
	}
	
	public List<Student> getNamGenderAddress(String name, String address , String gender,
			int start, int end) throws SystemException {
		List<Student> student =studentFinder.findByN_A_G(name, address, gender, start, end);
		return student;
	}
	
	public List<Student> getAddress(String address, int start, int end) throws SystemException {
		List<Student> student =studentFinder.findByAddress(address, start, end);
		return student;
	}
	
	public List<Student> getGender(String gender, int start, int end) throws SystemException {
		List<Student> student =studentFinder.findByGender(gender, start, end);
		return student;
	}
}