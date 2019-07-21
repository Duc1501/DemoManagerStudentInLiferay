<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.lcd.demo.service.StudentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.lcd.demo.service.persistence.StudentUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.lcd.demo.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/html/jsps/init.jsp" %>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<%
String redirect = ParamUtil.getString(request, "redirect");
String keywords = ParamUtil.getString(request, "keywords");
String keywordsAddress = ParamUtil.getString(request, "keywordsAddress");
String keywordsGender = ParamUtil.getString(request, "keywordsGender");
String currentURL = PortalUtil.getCurrentURL(request);
%>

<liferay-portlet:renderURL varImpl="searchURL">
 <portlet:param name="jspPage" value="/html/jsps/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
 		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
 	<liferay-ui:header	backURL="<%=redirect%>" title="search" />
<span class="aui-search-bar">
	<aui:input inlineField="<%= true %>" label="Name :" name="keywords" size="30" title="search-entries" type="text" />&emsp;&emsp;
 	<aui:input inlineField="<%= true %>" label="Address :" name=" keywordsAddress " size="30" title="search-entries" type="text" />&emsp;&emsp;
 	<aui:input inlineField="<%= true %>" label="Gender :" name="keywordsGender" size="30" title="search-entries" type="text" />&emsp;&emsp;
 	<aui:button type="submit" value="search" /><br><br>
</span>
<%
SearchContext searchContext = SearchContextFactory.getInstance(request);
searchContext.setKeywords(keywords);
searchContext.setKeywords(keywordsAddress);
searchContext.setKeywords(keywordsGender);
searchContext.setStart(0);
searchContext.setEnd(10);
List<Student> resultsAddress = StudentLocalServiceUtil.getAddress(keywordsAddress,0, 100);
List<Student> resultsGender = StudentLocalServiceUtil.getGender(keywordsGender,0, 100);
List<Student> resultsName = StudentLocalServiceUtil.getStudent(keywords, keywords, keywords, 0, 10);
List<Student> resultsNameGenderAddress = StudentLocalServiceUtil.getNamGenderAddress(keywords, keywordsAddress, keywordsGender, 0, 100);

%>
<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
        <liferay-ui:search-container-results
                results="<%= resultsNameGenderAddress %>"
                total="<%= resultsNameGenderAddress.size() %>"
        />

        <liferay-ui:search-container-row
                className="com.lcd.demo.model.Student"
                keyProperty="studentId" modelVar="student" escapedModel="<%=true%>">
                <liferay-ui:search-container-column-text property="name" />
                <liferay-ui:search-container-column-text property="age" />                
                <liferay-ui:search-container-column-text property="gender" />
                <liferay-ui:search-container-column-text property="phone" />
                <liferay-ui:search-container-column-text property="address" />
                <liferay-ui:search-container-column-text 
              		align="center" name="Choose" >
              		<a href="
                             <portlet:renderURL>
                             	<portlet:param name="jspPage" value="/html/jsps/update_Student.jsp" /> 
                             	<portlet:param name="Id_Student" value="<%=StringUtil.valueOf(student.getStudentId()) %>" />
                             	 
                             </portlet:renderURL>                                    	                    
                    	"><b>Update</b></a>
              &nbsp;|&nbsp;
               		<a href="
                            <portlet:actionURL name="deleteStudent">
                                   <portlet:param name="Id_Student" value="<%=StringUtil.valueOf(student.getStudentId()) %>" />
                             </portlet:actionURL>                                        
                         "><b>Delete</b></a>
				</liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

</aui:form>
