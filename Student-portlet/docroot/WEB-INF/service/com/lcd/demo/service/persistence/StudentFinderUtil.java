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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Smile
 */
public class StudentFinderUtil {
	public static java.util.List<com.lcd.demo.model.Student> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByName(name, start, end);
	}

	public static java.util.List<com.lcd.demo.model.Student> findByAddress(
		java.lang.String address, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByAddress(address, start, end);
	}

	public static java.util.List<com.lcd.demo.model.Student> findByGender(
		java.lang.String gender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByGender(gender, start, end);
	}

	public static java.util.List<com.lcd.demo.model.Student> findByN_A_G(
		java.lang.String name, java.lang.String address,
		java.lang.String gender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByN_A_G(name, address, gender, start, end);
	}

	public static StudentFinder getFinder() {
		if (_finder == null) {
			_finder = (StudentFinder)PortletBeanLocatorUtil.locate(com.lcd.demo.service.ClpSerializer.getServletContextName(),
					StudentFinder.class.getName());

			ReferenceRegistry.registerReference(StudentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StudentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StudentFinderUtil.class, "_finder");
	}

	private static StudentFinder _finder;
}