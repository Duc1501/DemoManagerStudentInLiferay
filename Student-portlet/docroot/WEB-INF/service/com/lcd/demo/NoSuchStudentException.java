/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.lcd.demo;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Smile
 */
public class NoSuchStudentException extends NoSuchModelException {

	public NoSuchStudentException() {
		super();
	}

	public NoSuchStudentException(String msg) {
		super(msg);
	}

	public NoSuchStudentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchStudentException(Throwable cause) {
		super(cause);
	}

}