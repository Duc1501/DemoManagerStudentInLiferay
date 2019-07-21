package com.lcd.demo.service.persistence;

import java.util.ArrayList;
import java.util.List;
import com.lcd.demo.model.Student;
import com.lcd.demo.model.impl.StudentImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class StudentFinderImpl extends BasePersistenceImpl<Student>implements StudentFinder{
	public static String COUNT_BY_N_A_G = StudentFinder.class.getName()
			+ ".countByN_A_G";
	public static String FIND_BY_N_A_G = StudentFinder.class.getName()
			+ ".findByN_A_G";
	
	public static String COUNT_BY_NAME = StudentFinder.class.getName()
			+ ".countByName";
	public static String FIND_BY_NAME = StudentFinder.class.getName()
			+ ".findByName";
	
	public static String FIND_BY_ADDRESS = StudentFinder.class.getName()
			+ ".findByAddress";
	public static String FIND_BY_GENDER = StudentFinder.class.getName()
			+ ".findByGender";
	
	public List<Student> findByName(String name, int start, int end) throws SystemException{
		Session session = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_NAME);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("student", StudentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%" + name + "%");
			return (List<Student>)QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e) {
			try{
				throw new SystemException(e);
			}catch (SystemException se) {
				se.printStackTrace();
			}
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public List<Student> findByAddress(String address, int start, int end) throws SystemException{
		Session session = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_ADDRESS);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("student", StudentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%" + address + "%");
			return (List<Student>)QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e) {
			try{
				throw new SystemException(e);
			}catch (SystemException se) {
				se.printStackTrace();
			}
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public List<Student> findByGender(String gender, int start, int end) throws SystemException{
		Session session = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_GENDER);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("student", StudentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%" + gender + "%");
			return (List<Student>)QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e) {
			try{
				throw new SystemException(e);
			}catch (SystemException se) {
				se.printStackTrace();
			}
		}finally{
			closeSession(session);
		}
		return null;
	}

	public List<Student> findByN_A_G(String name,String address, String gender, int start, int end )throws SystemException{
		Session session = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_N_A_G);
			SQLQuery q= session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("student", StudentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add("%" + name + "%");
			qPos.add("%" + address + "%");
			qPos.add("%" + gender + "%");
			return (List<Student>)QueryUtil.list(q, getDialect(), start, end);
		}catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
//	private List<Student> assembleStudents(List<Object[]> rateStudents){
//		List<Student> students = new ArrayList();
//		for(Object[] ratedS: rateStudents){
//			StudentImpl student = new StudentImpl();
//			student.setName(String.valueOf(ratedS[0]));
//			student.setGender(String.valueOf(ratedS[1]));
//			student.setAddress(String.valueOf(ratedS[2]));
//			students.add(student);
//		}
//		return students;
//	}
}
