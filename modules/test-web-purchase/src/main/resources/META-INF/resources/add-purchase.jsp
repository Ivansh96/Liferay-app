<%@page import="com.test.service.ElectronicsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.test.service.EmployeeLocalServiceUtil"%>
<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@ page import="com.test.model.Employee"%>
<%@ page import="com.test.model.Electronics"%>
<%@ page language="java" import="java.util.*" errorPage=""%>

<portlet:defineObjects />

<portlet:actionURL name="addPurchase" var="addPurchaseActionURL" />

<h2>New purchase form</h2>

<aui:form action="${addPurchaseActionURL}" name="purchaseForm" method="POST">


<%
   Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale);

   int startDateValue = cal.get(Calendar.DATE);
   int startMonthValue = cal.get(Calendar.MONTH);
   int startYearValue = cal.get(Calendar.YEAR);
   %>
 <%
   List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
   List<Electronics> elList = ElectronicsLocalServiceUtil.getElectronicses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
 %>  
   
    <aui:fieldset>
     <aui:field-wrapper label="purchaseDate">
     </aui:field-wrapper>
   </aui:fieldset>
   
     <div class="field-row">
<liferay-ui:input-date 
                       dayParam="schedulerStartDateDay" 
                       dayValue="<%=startDateValue %>" 
                       disabled="<%= false %>" 
                       monthParam="schedulerStartDateMonth" 
                       monthValue="<%=startMonthValue%>" 
                       name="purchaseDate" 
                       yearParam="schedulerStartDateYear" 
                       yearValue="<%=startYearValue%>">
 <aui:validator name="date" errorMessage="Invalid date"></aui:validator>                                      
</liferay-ui:input-date></div>

   <aui:input name="employee" disabled="true" type="hidden">
   <aui:select name="employee">
    <c:forEach items="<%=empList%>" var="emp">
     <aui:option value="${emp.getEmployeeId()}">${emp.getFirstname()} ${emp.getLastname()}</aui:option>
    </c:forEach>
   </aui:select>
      <aui:validator name="required"/>
   </aui:input>
   <aui:input name="electronics" disabled="true" type="hidden">
   <aui:select name="electronics">
    <c:forEach items="<%=elList%>" var="el">
     <aui:option value="${el.getElectronicsId()}">${el.getName()}</aui:option>
    </c:forEach>
   </aui:select>
      <aui:validator name="required"/>
   </aui:input>
   <aui:input name="purchase-type" disabled="true" type="hidden">
   <aui:select name="purchase-type">   
     <aui:option value="1">Credit</aui:option>     
     <aui:option value="2">Cash</aui:option>     
    </aui:select>
      <aui:validator name="required"/>
   </aui:input>   
   <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>  