package com.lcd.demo.search;

import java.util.Locale;
import javax.portlet.PortletURL;
import com.lcd.demo.model.Student;
import com.lcd.demo.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;


public class StudentIndexer extends BaseIndexer{
	public static final String[] CLASS_NAMES = { Student.class.getName() };
    public static final String PORTLET_ID = "Student-portlet";
    
    public StudentIndexer(){
    	
        }
    
    @Override
	protected Summary doGetSummary(Document document, Locale locale,
            String snippet, PortletURL portletURL) throws Exception {
		String title = document.get(Field.TITLE);
		String content = snippet;
		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);
			if (Validator.isNull(content)) {
				content = StringUtil.shorten(
				document.get(Field.CONTENT), 200);
			}
		}	
			String studentId = document.get(Field.ENTRY_CLASS_PK);
			portletURL.setParameter("jspPage", "/html/jsps/view.jsp");
			portletURL.setParameter("studentId", studentId);
			return new Summary(title, content, portletURL);
	}
    
	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Student student = (Student)obj;
		Document document = new DocumentImpl();
			document.addUID(PORTLET_ID, student.getPrimaryKey());
			SearchEngineUtil.deleteDocument(
			student.getStudentId(), document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Student student = (Student)obj;

		long studentId = student.getPrimaryKey();		
		long[] assetCategoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(
		Student.class.getName(), studentId);
		String[] assetCategoryNames =AssetCategoryLocalServiceUtil.getCategoryNames(
		Student.class.getName(), studentId);
		String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
		Student.class.getName(), studentId); 
		
		Document document = new DocumentImpl();
		document.addUID(PORTLET_ID, studentId);
		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		document.addText(Field.CONTENT, student.getName());
		document.addText(Field.TITLE, student.getName());
		document.addText(Field.CONTENT, student.getAddress());
		document.addText(Field.TITLE, student.getAddress());
		document.addText(Field.CONTENT, student.getGender());
		document.addText(Field.TITLE, student.getGender());
		document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
		document.addKeyword("assetCategoryNames", assetCategoryNames);
		document.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);
		document.addKeyword(Field.ENTRY_CLASS_NAME,Student.class.getName());
		document.addKeyword(Field.ENTRY_CLASS_PK, studentId);
		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Student student = (Student)obj;
		SearchEngineUtil.updateDocument(
			student.getStudentId(), getDocument(student));
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
//		long studentId = GetterUtil.getLong(ids[0]);
//        reindexEntries(studentId);
	}

	@Override
	protected void doReindex(String Student, long studentId) throws Exception {
		Student student = StudentLocalServiceUtil.getStudent(studentId);
		doReindex(student);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

}
