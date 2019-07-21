package com.lcd.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.lcd.demo.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * Portlet implementation class ManagerStudent
 */
public class ManagerStudent extends MVCPortlet {
	private static String ROOT_FOLDER_NAME = PortletProps.get("fileupload.folder.name");
	
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException, SystemException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try{
			String name =ParamUtil.getString(uploadRequest, "studentName");
			int age = ParamUtil.getInteger(uploadRequest,"studentAge");
			String gender = ParamUtil.getString(uploadRequest,"studentGender");
			int phone = ParamUtil.getInteger(uploadRequest,"studentPhone");
			String address = ParamUtil.getString(uploadRequest,"studentAddress");		
			File file = uploadRequest.getFile("fileImage");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			String fileName = uploadRequest.getFileName("fileImage");
			String mimeType = uploadRequest.getContentType("fileImage");
			DLFolder folder= DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, ROOT_FOLDER_NAME);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			DLFileEntry dlFileEntry = null;
			InputStream is = null;
			if(fileName != null){	
				is = new FileInputStream(file);				
				//them file
				dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId,
						groupId, folder.getFolderId(), fileName, mimeType, fileName, "",
						"",0, null, file, is, file.length(), serviceContext);				
			}
			String linkImage = "/documents/" + dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();

			long fileImage = dlFileEntry.getFileEntryId();
			// update student
			StudentLocalServiceUtil.addStudents(name, age, gender, phone, address,fileImage,linkImage, serviceContext);
			
			actionResponse.setRenderParameter("jspPage", "/html/jsps/view.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateStudent(ActionRequest actionRequest, ActionResponse actionResponse)throws IOException, PortletException{
		UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			long studentId =ParamUtil.getLong(upload,"id");
			String nameNew =ParamUtil.getString(upload,"name");
			int ageNew = ParamUtil.getInteger(upload,"age");
			String genderNew = ParamUtil.getString(upload,"gender");
			int phoneNew = ParamUtil.getInteger(upload,"phone");
			String addressNew = ParamUtil.getString(upload,"address");
			
			File file = upload.getFile("fileImage");
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			String fileName = upload.getFileName("fileImage");
			String mimeType = upload.getContentType("fileImage");

			DLFolder folder= DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, ROOT_FOLDER_NAME);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);	
			
			DLFileEntry dlFileEntry = null;
			InputStream is = null;
			if(fileName != null){
				 is = new FileInputStream( file );
				dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId,
					groupId, folder.getFolderId(), fileName, mimeType, fileName, "",
					"",0, null, file, is, file.length(), serviceContext);
				DLFileEntryLocalServiceUtil.updateFileEntry(folder.getUserId(), dlFileEntry.getFileEntryId(),
					file.getName(), mimeType, fileName, "", "", true, 0, null, file, is, file.getTotalSpace(), serviceContext);
			}
			String linkImage = "/documents/" + dlFileEntry.getGroupId() + "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle();
			long fileImage = dlFileEntry.getFileEntryId();	
			StudentLocalServiceUtil.updateStudent(studentId, nameNew, ageNew, genderNew, phoneNew, addressNew, fileImage,linkImage, serviceContext);
			actionResponse.setRenderParameter("jspPage","/html/jsps/view.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(ActionRequest actionRequest,
			ActionResponse actionResponse)throws IOException,PortletException{
		try{
			long studentId = ParamUtil.getLong(actionRequest,"Id_Student");
			StudentLocalServiceUtil.deleteStudent(studentId);			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void createDLFolder(RenderRequest renderRequest, ThemeDisplay themeDisplay, String folderName, String description) throws PortalException, SystemException{
//		long userId = themeDisplay.getUserId();
//		long groupId = themeDisplay.getScopeGroupId();
//		long repositoryId = themeDisplay.getScopeGroupId();
//		boolean mountPoint = false;
//		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), renderRequest);
//		DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, mountPoint, parentFolderId, folderName, description, serviceContext);		
//	}
}
