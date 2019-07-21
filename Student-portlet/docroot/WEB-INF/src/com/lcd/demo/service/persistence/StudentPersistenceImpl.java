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

import com.lcd.demo.NoSuchStudentException;
import com.lcd.demo.model.Student;
import com.lcd.demo.model.impl.StudentImpl;
import com.lcd.demo.model.impl.StudentModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Smile
 * @see StudentPersistence
 * @see StudentUtil
 * @generated
 */
public class StudentPersistenceImpl extends BasePersistenceImpl<Student>
	implements StudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			StudentModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESS = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAddress",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAddress",
			new String[] { String.class.getName() },
			StudentModelImpl.ADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ADDRESS = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAddress",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGender",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGender",
			new String[] { String.class.getName() },
			StudentModelImpl.GENDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GENDER = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGender",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_N_A = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByN_A",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByN_A",
			new String[] { String.class.getName(), String.class.getName() },
			StudentModelImpl.NAME_COLUMN_BITMASK |
			StudentModelImpl.ADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_A = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_A",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_N_A_G = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByN_A_G",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A_G = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByN_A_G",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			StudentModelImpl.NAME_COLUMN_BITMASK |
			StudentModelImpl.ADDRESS_COLUMN_BITMASK |
			StudentModelImpl.GENDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_N_A_G = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByN_A_G",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public void cacheResult(Student student) {
		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		student.resetOriginalValues();
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public void cacheResult(List<Student> students) {
		for (Student student : students) {
			if (EntityCacheUtil.getResult(
						StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, student.getPrimaryKey()) == null) {
				cacheResult(student);
			}
			else {
				student.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	public Student create(long studentId) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(studentId);

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student remove(long studentId)
		throws NoSuchStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(StudentImpl.class,
					Long.valueOf(studentId));

			if (student == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studentId);
				}

				throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					studentId);
			}

			return studentPersistence.remove(student);
		}
		catch (NoSuchStudentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the student from the database. Also notifies the appropriate model listeners.
	 *
	 * @param student the student
	 * @return the student that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(Student student) throws SystemException {
		return super.remove(student);
	}

	@Override
	protected Student removeImpl(Student student) throws SystemException {
		student = toUnwrappedModel(student);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, student);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey());

		return student;
	}

	@Override
	public Student updateImpl(com.lcd.demo.model.Student student, boolean merge)
		throws SystemException {
		student = toUnwrappedModel(student);

		boolean isNew = student.isNew();

		StudentModelImpl studentModelImpl = (StudentModelImpl)student;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, student, merge);

			student.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { studentModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { studentModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS,
					args);

				args = new Object[] { studentModelImpl.getAddress() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalGender()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER,
					args);

				args = new Object[] { studentModelImpl.getGender() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalName(),
						
						studentModelImpl.getOriginalAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A,
					args);

				args = new Object[] {
						studentModelImpl.getName(),
						
						studentModelImpl.getAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalName(),
						
						studentModelImpl.getOriginalAddress(),
						
						studentModelImpl.getOriginalGender()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_A_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A_G,
					args);

				args = new Object[] {
						studentModelImpl.getName(),
						
						studentModelImpl.getAddress(),
						
						studentModelImpl.getGender()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_N_A_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A_G,
					args);
			}
		}

		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		return student;
	}

	protected Student toUnwrappedModel(Student student) {
		if (student instanceof StudentImpl) {
			return student;
		}

		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setNew(student.isNew());
		studentImpl.setPrimaryKey(student.getPrimaryKey());

		studentImpl.setStudentId(student.getStudentId());
		studentImpl.setName(student.getName());
		studentImpl.setAge(student.getAge());
		studentImpl.setGender(student.getGender());
		studentImpl.setPhone(student.getPhone());
		studentImpl.setAddress(student.getAddress());
		studentImpl.setFileImage(student.getFileImage());
		studentImpl.setLinkImage(student.getLinkImage());

		return studentImpl;
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws com.liferay.portal.NoSuchModelException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.lcd.demo.NoSuchStudentException} if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws com.lcd.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByPrimaryKey(studentId);

		if (student == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studentId);
			}

			throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				studentId);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Student fetchByPrimaryKey(long studentId) throws SystemException {
		Student student = (Student)EntityCacheUtil.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, studentId);

		if (student == _nullStudent) {
			return null;
		}

		if (student == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				student = (Student)session.get(StudentImpl.class,
						Long.valueOf(studentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (student != null) {
					cacheResult(student);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, studentId, _nullStudent);
				}

				closeSession(session);
			}
		}

		return student;
	}

	/**
	 * Returns all the students where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Student> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

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
	public List<Student> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Student findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		List<Student> list = findByName(name, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		int count = countByName(name);

		List<Student> list = findByName(name, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student[] findByName_PrevAndNext(long studentId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByName_PrevAndNext(session, student, name,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByName_PrevAndNext(session, student, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByName_PrevAndNext(Session session, Student student,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students where address LIKE &#63;.
	 *
	 * @param address the address
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByAddress(String address)
		throws SystemException {
		return findByAddress(address, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Student> findByAddress(String address, int start, int end)
		throws SystemException {
		return findByAddress(address, start, end, null);
	}

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
	public List<Student> findByAddress(String address, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS;
			finderArgs = new Object[] { address };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESS;
			finderArgs = new Object[] { address, start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			if (address == null) {
				query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (address != null) {
					qPos.add(address);
				}

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Student findByAddress_First(String address,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		List<Student> list = findByAddress(address, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("address=");
			msg.append(address);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student findByAddress_Last(String address,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		int count = countByAddress(address);

		List<Student> list = findByAddress(address, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("address=");
			msg.append(address);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student[] findByAddress_PrevAndNext(long studentId, String address,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByAddress_PrevAndNext(session, student, address,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByAddress_PrevAndNext(session, student, address,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByAddress_PrevAndNext(Session session,
		Student student, String address, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		if (address == null) {
			query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_1);
		}
		else {
			if (address.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_3);
			}
			else {
				query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (address != null) {
			qPos.add(address);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students where gender LIKE &#63;.
	 *
	 * @param gender the gender
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByGender(String gender) throws SystemException {
		return findByGender(gender, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Student> findByGender(String gender, int start, int end)
		throws SystemException {
		return findByGender(gender, start, end, null);
	}

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
	public List<Student> findByGender(String gender, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER;
			finderArgs = new Object[] { gender };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER;
			finderArgs = new Object[] { gender, start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			if (gender == null) {
				query.append(_FINDER_COLUMN_GENDER_GENDER_1);
			}
			else {
				if (gender.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GENDER_GENDER_3);
				}
				else {
					query.append(_FINDER_COLUMN_GENDER_GENDER_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (gender != null) {
					qPos.add(gender);
				}

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Student findByGender_First(String gender,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		List<Student> list = findByGender(gender, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("gender=");
			msg.append(gender);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student findByGender_Last(String gender,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		int count = countByGender(gender);

		List<Student> list = findByGender(gender, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("gender=");
			msg.append(gender);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student[] findByGender_PrevAndNext(long studentId, String gender,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByGender_PrevAndNext(session, student, gender,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByGender_PrevAndNext(session, student, gender,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByGender_PrevAndNext(Session session, Student student,
		String gender, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		if (gender == null) {
			query.append(_FINDER_COLUMN_GENDER_GENDER_1);
		}
		else {
			if (gender.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GENDER_GENDER_3);
			}
			else {
				query.append(_FINDER_COLUMN_GENDER_GENDER_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (gender != null) {
			qPos.add(gender);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students where name = &#63; and address = &#63;.
	 *
	 * @param name the name
	 * @param address the address
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByN_A(String name, String address)
		throws SystemException {
		return findByN_A(name, address, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<Student> findByN_A(String name, String address, int start,
		int end) throws SystemException {
		return findByN_A(name, address, start, end, null);
	}

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
	public List<Student> findByN_A(String name, String address, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A;
			finderArgs = new Object[] { name, address };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_N_A;
			finderArgs = new Object[] {
					name, address,
					
					start, end, orderByComparator
				};
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_N_A_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_NAME_2);
				}
			}

			if (address == null) {
				query.append(_FINDER_COLUMN_N_A_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_ADDRESS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (address != null) {
					qPos.add(address);
				}

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Student findByN_A_First(String name, String address,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		List<Student> list = findByN_A(name, address, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", address=");
			msg.append(address);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student findByN_A_Last(String name, String address,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		int count = countByN_A(name, address);

		List<Student> list = findByN_A(name, address, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", address=");
			msg.append(address);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student[] findByN_A_PrevAndNext(long studentId, String name,
		String address, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByN_A_PrevAndNext(session, student, name, address,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByN_A_PrevAndNext(session, student, name, address,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByN_A_PrevAndNext(Session session, Student student,
		String name, String address, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_N_A_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_A_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_N_A_NAME_2);
			}
		}

		if (address == null) {
			query.append(_FINDER_COLUMN_N_A_ADDRESS_1);
		}
		else {
			if (address.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_A_ADDRESS_3);
			}
			else {
				query.append(_FINDER_COLUMN_N_A_ADDRESS_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (address != null) {
			qPos.add(address);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	 *
	 * @param name the name
	 * @param address the address
	 * @param gender the gender
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findByN_A_G(String name, String address, String gender)
		throws SystemException {
		return findByN_A_G(name, address, gender, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Student> findByN_A_G(String name, String address,
		String gender, int start, int end) throws SystemException {
		return findByN_A_G(name, address, gender, start, end, null);
	}

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
	public List<Student> findByN_A_G(String name, String address,
		String gender, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_N_A_G;
			finderArgs = new Object[] { name, address, gender };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_N_A_G;
			finderArgs = new Object[] {
					name, address, gender,
					
					start, end, orderByComparator
				};
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_N_A_G_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_G_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_G_NAME_2);
				}
			}

			if (address == null) {
				query.append(_FINDER_COLUMN_N_A_G_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_G_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_G_ADDRESS_2);
				}
			}

			if (gender == null) {
				query.append(_FINDER_COLUMN_N_A_G_GENDER_1);
			}
			else {
				if (gender.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_G_GENDER_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_G_GENDER_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (address != null) {
					qPos.add(address);
				}

				if (gender != null) {
					qPos.add(gender);
				}

				list = (List<Student>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Student findByN_A_G_First(String name, String address,
		String gender, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		List<Student> list = findByN_A_G(name, address, gender, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", address=");
			msg.append(address);

			msg.append(", gender=");
			msg.append(gender);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student findByN_A_G_Last(String name, String address, String gender,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		int count = countByN_A_G(name, address, gender);

		List<Student> list = findByN_A_G(name, address, gender, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", address=");
			msg.append(address);

			msg.append(", gender=");
			msg.append(gender);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Student[] findByN_A_G_PrevAndNext(long studentId, String name,
		String address, String gender, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByN_A_G_PrevAndNext(session, student, name, address,
					gender, orderByComparator, true);

			array[1] = student;

			array[2] = getByN_A_G_PrevAndNext(session, student, name, address,
					gender, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByN_A_G_PrevAndNext(Session session, Student student,
		String name, String address, String gender,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_N_A_G_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_A_G_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_N_A_G_NAME_2);
			}
		}

		if (address == null) {
			query.append(_FINDER_COLUMN_N_A_G_ADDRESS_1);
		}
		else {
			if (address.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_A_G_ADDRESS_3);
			}
			else {
				query.append(_FINDER_COLUMN_N_A_G_ADDRESS_2);
			}
		}

		if (gender == null) {
			query.append(_FINDER_COLUMN_N_A_G_GENDER_1);
		}
		else {
			if (gender.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_N_A_G_GENDER_3);
			}
			else {
				query.append(_FINDER_COLUMN_N_A_G_GENDER_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (address != null) {
			qPos.add(address);
		}

		if (gender != null) {
			qPos.add(gender);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 * @throws SystemException if a system exception occurred
	 */
	public List<Student> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Student> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Student> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT.concat(StudentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the students where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name) throws SystemException {
		for (Student student : findByName(name)) {
			studentPersistence.remove(student);
		}
	}

	/**
	 * Removes all the students where address LIKE &#63; from the database.
	 *
	 * @param address the address
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAddress(String address) throws SystemException {
		for (Student student : findByAddress(address)) {
			studentPersistence.remove(student);
		}
	}

	/**
	 * Removes all the students where gender LIKE &#63; from the database.
	 *
	 * @param gender the gender
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGender(String gender) throws SystemException {
		for (Student student : findByGender(gender)) {
			studentPersistence.remove(student);
		}
	}

	/**
	 * Removes all the students where name = &#63; and address = &#63; from the database.
	 *
	 * @param name the name
	 * @param address the address
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByN_A(String name, String address)
		throws SystemException {
		for (Student student : findByN_A(name, address)) {
			studentPersistence.remove(student);
		}
	}

	/**
	 * Removes all the students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @param address the address
	 * @param gender the gender
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByN_A_G(String name, String address, String gender)
		throws SystemException {
		for (Student student : findByN_A_G(name, address, gender)) {
			studentPersistence.remove(student);
		}
	}

	/**
	 * Removes all the students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Student student : findAll()) {
			studentPersistence.remove(student);
		}
	}

	/**
	 * Returns the number of students where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students where address LIKE &#63;.
	 *
	 * @param address the address
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAddress(String address) throws SystemException {
		Object[] finderArgs = new Object[] { address };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ADDRESS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			if (address == null) {
				query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_ADDRESS_ADDRESS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (address != null) {
					qPos.add(address);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ADDRESS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students where gender LIKE &#63;.
	 *
	 * @param gender the gender
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGender(String gender) throws SystemException {
		Object[] finderArgs = new Object[] { gender };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GENDER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			if (gender == null) {
				query.append(_FINDER_COLUMN_GENDER_GENDER_1);
			}
			else {
				if (gender.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GENDER_GENDER_3);
				}
				else {
					query.append(_FINDER_COLUMN_GENDER_GENDER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (gender != null) {
					qPos.add(gender);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GENDER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students where name = &#63; and address = &#63;.
	 *
	 * @param name the name
	 * @param address the address
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByN_A(String name, String address)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, address };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_N_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_N_A_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_NAME_2);
				}
			}

			if (address == null) {
				query.append(_FINDER_COLUMN_N_A_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_ADDRESS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (address != null) {
					qPos.add(address);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students where name LIKE &#63; and address LIKE &#63; and gender LIKE &#63;.
	 *
	 * @param name the name
	 * @param address the address
	 * @param gender the gender
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	public int countByN_A_G(String name, String address, String gender)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, address, gender };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_N_A_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_N_A_G_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_G_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_G_NAME_2);
				}
			}

			if (address == null) {
				query.append(_FINDER_COLUMN_N_A_G_ADDRESS_1);
			}
			else {
				if (address.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_G_ADDRESS_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_G_ADDRESS_2);
				}
			}

			if (gender == null) {
				query.append(_FINDER_COLUMN_N_A_G_GENDER_1);
			}
			else {
				if (gender.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_N_A_G_GENDER_3);
				}
				else {
					query.append(_FINDER_COLUMN_N_A_G_GENDER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (address != null) {
					qPos.add(address);
				}

				if (gender != null) {
					qPos.add(gender);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_A_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lcd.demo.model.Student")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Student>> listenersList = new ArrayList<ModelListener<Student>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Student>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StudentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STUDENT = "SELECT student FROM Student student";
	private static final String _SQL_SELECT_STUDENT_WHERE = "SELECT student FROM Student student WHERE ";
	private static final String _SQL_COUNT_STUDENT = "SELECT COUNT(student) FROM Student student";
	private static final String _SQL_COUNT_STUDENT_WHERE = "SELECT COUNT(student) FROM Student student WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "student.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "student.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(student.name IS NULL OR student.name LIKE ?)";
	private static final String _FINDER_COLUMN_ADDRESS_ADDRESS_1 = "student.address LIKE NULL";
	private static final String _FINDER_COLUMN_ADDRESS_ADDRESS_2 = "student.address LIKE ?";
	private static final String _FINDER_COLUMN_ADDRESS_ADDRESS_3 = "(student.address IS NULL OR student.address LIKE ?)";
	private static final String _FINDER_COLUMN_GENDER_GENDER_1 = "student.gender LIKE NULL";
	private static final String _FINDER_COLUMN_GENDER_GENDER_2 = "student.gender LIKE ?";
	private static final String _FINDER_COLUMN_GENDER_GENDER_3 = "(student.gender IS NULL OR student.gender LIKE ?)";
	private static final String _FINDER_COLUMN_N_A_NAME_1 = "student.name IS NULL AND ";
	private static final String _FINDER_COLUMN_N_A_NAME_2 = "student.name = ? AND ";
	private static final String _FINDER_COLUMN_N_A_NAME_3 = "(student.name IS NULL OR student.name = ?) AND ";
	private static final String _FINDER_COLUMN_N_A_ADDRESS_1 = "student.address IS NULL";
	private static final String _FINDER_COLUMN_N_A_ADDRESS_2 = "student.address = ?";
	private static final String _FINDER_COLUMN_N_A_ADDRESS_3 = "(student.address IS NULL OR student.address = ?)";
	private static final String _FINDER_COLUMN_N_A_G_NAME_1 = "student.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_N_A_G_NAME_2 = "student.name LIKE ? AND ";
	private static final String _FINDER_COLUMN_N_A_G_NAME_3 = "(student.name IS NULL OR student.name LIKE ?) AND ";
	private static final String _FINDER_COLUMN_N_A_G_ADDRESS_1 = "student.address LIKE NULL AND ";
	private static final String _FINDER_COLUMN_N_A_G_ADDRESS_2 = "student.address LIKE ? AND ";
	private static final String _FINDER_COLUMN_N_A_G_ADDRESS_3 = "(student.address IS NULL OR student.address LIKE ?) AND ";
	private static final String _FINDER_COLUMN_N_A_G_GENDER_1 = "student.gender LIKE NULL";
	private static final String _FINDER_COLUMN_N_A_G_GENDER_2 = "student.gender LIKE ?";
	private static final String _FINDER_COLUMN_N_A_G_GENDER_3 = "(student.gender IS NULL OR student.gender LIKE ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Student exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentPersistenceImpl.class);
	private static Student _nullStudent = new StudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Student> toCacheModel() {
				return _nullStudentCacheModel;
			}
		};

	private static CacheModel<Student> _nullStudentCacheModel = new CacheModel<Student>() {
			public Student toEntityModel() {
				return _nullStudent;
			}
		};
}