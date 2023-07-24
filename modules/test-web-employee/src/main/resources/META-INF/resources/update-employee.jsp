<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<portlet:defineObjects/>



<portlet:actionURL name="updateEmployee" var="updateEmployeeActionURL"/>

<aui:form action="${updateEmployeeActionURL}" name="employeeForm" method="POST"/>

<%
   String employeeId = renderRequest.getParameter("employeeId");
   String firstname = renderRequest.getParameter("firstname");
   String lastname = renderRequest.getParameter("lastname");
   String patronymic = renderRequest.getParameter("patronymic");
   String birthdate = renderRequest.getParameter("birthdate");
   String gender = renderRequest.getParameter("gender");
%>

<aui:form action="${updateEmployeeActionURL}" method="post">

     <aui:input name="employeeId" type="hidden" value="<%=Long.parseLong(employeeId)%>"/>
     <aui:input name="firstname" type="text" value="${employee.firstname}">
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
     </aui:input>
     <aui:input name="lastname" type="text" value="${employee.lastname}">
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
     </aui:input>
     <aui:input name="patronymic" type="text" value="${employee.patronymic}">
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
     </aui:input>
     
     
  <%
   Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale);

   int startDateValue = cal.get(Calendar.DATE);
   int startMonthValue = cal.get(Calendar.MONTH);
   int startYearValue = cal.get(Calendar.YEAR);
  %>
     
     <aui:fieldset>
     <aui:field-wrapper label="birthdate">
     </aui:field-wrapper>
   </aui:fieldset>
   
   <div class="field-row">
<liferay-ui:input-date 
                       dayParam="schedulerStartDateDay" 
                       dayValue="<%=startDateValue %>" 
                       disabled="<%= false %>" 
                       monthParam="schedulerStartDateMonth" 
                       monthValue="<%=startMonthValue%>" 
                       name="birthdate" 
                       yearParam="schedulerStartDateYear" 
                       yearValue="<%=startYearValue%>">                   
<aui:validator name="date" errorMessage="Invalid date"></aui:validator>
</liferay-ui:input-date></div>
     
     
     
     <aui:input name="gender" type="text" value="${employee.gender}" disabled="true">
      <aui:select name="gender">   
       <aui:option value="true">Female</aui:option>     
       <aui:option value="false">Male</aui:option>     
      </aui:select>     
       <aui:validator name="required"/>
     </aui:input>
     
     <aui:input type="submit" value="Update" name="update"></aui:input>
            
</aui:form>
