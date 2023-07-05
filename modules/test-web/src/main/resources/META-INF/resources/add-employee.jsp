<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.test.service.PositionTypeLocalServiceUtil"%>
<%@page import="com.test.service.PositionTypeLocalService"%>
<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />


<portlet:actionURL name="addEmployee" var="addEmployeeActionURL"/>


<h2>New employee form</h2>


<aui:form action="${addEmployeeActionURL}" name="employeeForm" method="POST">
   <aui:input name="firstname" >
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
   </aui:input>
   <aui:input name="lastname" >
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
   </aui:input>
   <aui:input name="patronymic" >
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
   
   <aui:input name="gender" disabled="true" type="hidden">
    <aui:select name="gender">   
     <aui:option value="true">Female</aui:option>     
     <aui:option value="false">Male</aui:option>     
    </aui:select>
      <aui:validator name="required"/>
   </aui:input>
   
   <aui:input name="position" disabled="true" type="hidden"> 
    <aui:select name="position">   
     <aui:option value="1">Manager</aui:option>     
     <aui:option value="2">Seller</aui:option>     
    </aui:select>
      <aui:validator name="required"/>     
   </aui:input>  

   <aui:input name="etype" disabled="true" type="hidden" >
    <aui:select name="etype">   
     <aui:option value="1">TV</aui:option>     
     <aui:option value="2">PC</aui:option>
     <aui:option value="3">Smartphone</aui:option>  
     <aui:option value="4">Fridge</aui:option>
     <aui:option value="5">Audio</aui:option>         
    </aui:select>
      <aui:validator name="required"/>
   </aui:input>
      
   <aui:button type="submit" name="" value="Submit"></aui:button>   
</aui:form>





  
   
 