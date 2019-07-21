<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.upload.UploadPortletRequest"%>
<%@page import="com.lcd.demo.ManagerStudent"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.lcd.demo.service.StudentLocalServiceUtil"%>
<%@ include file="/html/jsps/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.lcd.demo.model.Student"%>

<portlet:defineObjects />
	<portlet:actionURL var="updateStudentActionURL"  name="updateStudent">
</portlet:actionURL>

<portlet:renderURL  var="backHome">
	<portlet:param name="jspPage" value="/html/jsps/view.jsp"/>
</portlet:renderURL>

<%
List<Student> studentList=StudentLocalServiceUtil.getStudents(0,StudentLocalServiceUtil.getStudentsCount());
%>
<h1><b> Update Student</b></h1>
<a href="<%=backHome.toString()%>"><b>Back Home</b></a><br/><br/>

<portlet:actionURL var="updateCategoryURL" name="updateCategory"/>
<%
Long idStudent = ParamUtil.getLong(renderRequest, "Id_Student");
Student student= StudentLocalServiceUtil.getStudent(idStudent);

%>
<form action="<%=updateStudentActionURL %>" name="" method="post" enctype="multipart/form-data">
<img alt="" src="<%=student.getLinkImage()%>"  width="120"	height="120"/><br/><br/>
<b>ID :</b><br/>
<input  type="text" name="<portlet:namespace/>id" id="<portlet:namespace/>name"  value="<%= student.getStudentId()%>"/><br/><br/>
<b>Full Name :</b><br/>
<input  type="text" name="<portlet:namespace/>name" id="<portlet:namespace/>name"  value="<%=student.getName() %>"/><br/><br/>
<b>Age :</b><br/>
<input type="text" name="<portlet:namespace/>age" id="<portlet:namespace/>age"  value="<%=student.getAge() %>"/><br/><br/>
<b>Gender :</b><br/>
<input type="text" name="<portlet:namespace/>gender" id="<portlet:namespace/>gender"  value="<%= student.getGender() %>"/><br/><br/>
<b>Phone :</b><br/>
<input type="text" name="<portlet:namespace/>phone" id="<portlet:namespace/>phone"  value="<%= student.getPhone() %>"/><br/><br/>
<b>Address :</b><br/>
<input type="text" name="<portlet:namespace/>address" id="<portlet:namespace/>address"  value="<%= student.getAddress() %>"/><br/><br/>
<b>Image :</b><br/>
<input type="file" name="fileImage"/><br/><br/>


<input type="submit" name="addStudent" id="addStudent" value="Update Student" /><br>
     
</form>