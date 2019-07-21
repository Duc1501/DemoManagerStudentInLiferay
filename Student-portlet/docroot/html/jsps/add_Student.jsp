<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/jsps/init.jsp" %>
<portlet:defineObjects />
<portlet:actionURL var="addStudentActionURL"  name="addStudent">
</portlet:actionURL>

<portlet:renderURL  var="backHome">
	<portlet:param name="jspPage" value="/html/jsps/view.jsp"/>
</portlet:renderURL>

<h1><b> Add Student</b></h1>
<a href="<%=backHome.toString()%>"><b>Back Home</b></a><br/><br/>

<form action="<%=addStudentActionURL%>" name="studentform"  method="POST" enctype="multipart/form-data">
<b>Full Name :</b><br/>
<input  type="text" name="<portlet:namespace/>studentName" id="<portlet:namespace/>studentName"/><br/><br/>
<b>Age :</b><br/>
<input type="text" name="<portlet:namespace/>studentAge" id="<portlet:namespace/>studentAge"/><br/><br/>
<b>Gender :</b><br/>
<input type="text" name="<portlet:namespace/>studentGender" id="<portlet:namespace/>studentGender"/><br/><br/>
<b>Phone :</b><br/>
<input type="text" name="<portlet:namespace/>studentPhone" id="<portlet:namespace/>studentPhone"/><br/><br/>
<b>Address :</b><br/>
<input type="text" name="<portlet:namespace/>studentAddress" id="<portlet:namespace/>studentAddress"/><br/><br/>
<b>Image :</b><br/>
<input type="file" name="fileImage" /><br/><br/>
<input type="submit" name="addStudent" id="addStudent" value="Add Student"/><br>
</form>