<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@ page import="com.test.model.Employee"%>
<%@ page import="com.test.model.Electronics"%>
<%@page import="com.test.service.ElectronicsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.test.service.EmployeeLocalServiceUtil"%>
<%@ page language="java" import="java.util.*" errorPage=""%>
<portlet:defineObjects/>


<portlet:actionURL name="updatePurchase" var="updatePurchaseActionURL"/>

<aui:form action="${updatePurchaseActionURL}" name="purchaseForm" method="POST"/>

<% 

   String purchaseId = renderRequest.getParameter("purchaseId");
   String purchaseDate = renderRequest.getParameter("purchaseDate");
   String employeeId = renderRequest.getParameter("employeeId");
   String electronicsId = renderRequest.getParameter("electronicsId");
%>

<aui:form action="${updatePurchaseActionURL}" method="post">

     <aui:input name="purchaseId" type="hidden" value="<%=Long.parseLong(purchaseId)%>"/>
     
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
     
     <aui:input name="employeeId" disabled="true" type="hidden">
     <aui:select name="employeeId" value="${purchase.employeeId}">
    <c:forEach items="<%=empList%>" var="emp">
     <aui:option value="${emp.getEmployeeId()}">${emp.getFirstname()} ${emp.getLastname()}</aui:option>
    </c:forEach>
   </aui:select>
      <aui:validator name="required"/>
    </aui:input>
     <aui:input name="electronicsId" disabled="true" type="hidden">
     <aui:select name="electronicsId" value="${purchase.electronicsId}">
    <c:forEach items="<%=elList%>" var="el">
     <aui:option value="${el.getElectronicsId()}">${el.getName()}</aui:option>
    </c:forEach>
   </aui:select>
      <aui:validator name="required"/>
     </aui:input>

     <aui:input type="submit" value="Update" name="update"></aui:input>
            
</aui:form>