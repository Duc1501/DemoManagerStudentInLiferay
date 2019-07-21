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

import com.lcd.demo.model.StudentClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"Student-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"Student-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "Student-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(StudentClp.class.getName())) {
			return translateInputStudent(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputStudent(BaseModel<?> oldModel) {
		StudentClp oldCplModel = (StudentClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.lcd.demo.model.impl.StudentImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setStudentId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getStudentId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setAge",
						new Class[] { Integer.TYPE });

				Integer value2 = new Integer(oldCplModel.getAge());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setGender",
						new Class[] { String.class });

				String value3 = oldCplModel.getGender();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setPhone",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getPhone());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value5 = oldCplModel.getAddress();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setFileImage",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getFileImage());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLinkImage",
						new Class[] { String.class });

				String value7 = oldCplModel.getLinkImage();

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.lcd.demo.model.impl.StudentImpl")) {
			return translateOutputStudent(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputStudent(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				StudentClp newModel = new StudentClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getStudentId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setStudentId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getAge");

				Integer value2 = (Integer)method2.invoke(oldModel,
						(Object[])null);

				newModel.setAge(value2);

				Method method3 = oldModelClass.getMethod("getGender");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setGender(value3);

				Method method4 = oldModelClass.getMethod("getPhone");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setPhone(value4);

				Method method5 = oldModelClass.getMethod("getAddress");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setAddress(value5);

				Method method6 = oldModelClass.getMethod("getFileImage");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setFileImage(value6);

				Method method7 = oldModelClass.getMethod("getLinkImage");

				String value7 = (String)method7.invoke(oldModel, (Object[])null);

				newModel.setLinkImage(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}