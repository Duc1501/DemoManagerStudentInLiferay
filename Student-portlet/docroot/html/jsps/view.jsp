<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.lcd.demo.service.StudentLocalServiceUtil"%>
<%@ include file="/html/jsps/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.lcd.demo.model.Student"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<liferay-ui:tabs names="Manager Student,Faculty,tab3" refresh="false" tabsValues="tab1,tab2,tab3">
<liferay-ui:section>

<portlet:renderURL  var="addStudent">
	<portlet:param name="jspPage" value="/html/jsps/add_Student.jsp"/>
</portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="jspPage" value="/html/jsps/search.jsp"></portlet:param>
</liferay-portlet:renderURL>
<%
List<Student> studentList=StudentLocalServiceUtil.getStudents(0,100);
String currentURL = PortalUtil.getCurrentURL(request);
%>
<h2 align="center">STUDENT MANAGER</h2>

<a href="<%=addStudent.toString()%>"><b>Add Student</b></a><br><br>

<aui:form action="<%= searchURL %>" method="get" name="fm0">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:input name="redirect" type="hidden" value="<%=currentURL %>" />
 <div class="portlet-toolbar search-form">
 	<span class="aui-search-bar">
 		<aui:input inlineField="<%= true %>" label="Name :" name="keywords" size="30" title="search-entries" type="text" />&emsp;&emsp;
 		<aui:input inlineField="<%= true %>" label="Address :" name="keywordsAddress" size="30" title="search-entries" type="text" />&emsp;&emsp;
 		<aui:input inlineField="<%= true %>" label="Gender :" name="keywordsGender" size="30" title="search-entries" type="text" />&emsp;&emsp;
 		<aui:button type="submit" value="search" />
 	</span>
 </div>
</aui:form>

<liferay-ui:search-container delta="10"> 
       <liferay-ui:search-container-results
              results="<%=ListUtil.subList(studentList, searchContainer.getStart(),searchContainer.getEnd())%>"
              total="<%=studentList.size() %>"/>
       <liferay-ui:search-container-row
       		className="com.lcd.demo.model.Student"
       		keyProperty="studentId"
       		modelVar="student" > 
  
       		<liferay-ui:search-container-column-text 
              		name="ID"  property="studentId"/>
              <liferay-ui:search-container-column-text 
              		name="Student Name"  property="name"/>
              <liferay-ui:search-container-column-text 
              		name="Student Age"  property="age"/>
              <liferay-ui:search-container-column-text 
              		name="Student Gender"  property="gender"/>
              <liferay-ui:search-container-column-text 
              		name="Student Phone"  property="phone"/>
              <liferay-ui:search-container-column-text 
              		name="Student Address" property="address"/>
              <liferay-ui:search-container-column-text 
              		name="File Image" property="fileImage"/>
              <liferay-ui:search-container-column-text 
              		name="Choose" align="left">
              		<a href="
                             <portlet:renderURL>
                             	<portlet:param name="jspPage" value="/html/jsps/update_Student.jsp" /> 
                             	<portlet:param name="Id_Student" value="<%=StringUtil.valueOf(student.getStudentId()) %>" />
                             	 
                             </portlet:renderURL>                                    	                    
                    	"><b>Update</b></a>
              &nbsp;|&nbsp;
               		<a href="
                            <portlet:actionURL name="deleteStudent">
                                   <portlet:param name="Id_Student" value="<%= StringUtil.valueOf(student.getStudentId()) %>" />
                             </portlet:actionURL>                                        
                         "><b>Delete</b></a>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
     <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="true" />   
</liferay-ui:search-container>
<br/>
<br/>
<br/>
<hr/>
</liferay-ui:section>

<liferay-ui:section>
<h3>Choose :</h3><select >
  <option value="volvo">CNTT</option>
  <option value="saab">ATTT</option>
  <option value="opel">VT</option>
  <option value="audi">DT</option>
</select>
<aui:button type="submit" value="Show" />
</liferay-ui:section>

<liferay-ui:section>
        <%@ include file="search.jsp" %>
</liferay-ui:section>

</liferay-ui:tabs>