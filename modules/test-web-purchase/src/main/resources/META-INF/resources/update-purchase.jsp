<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
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
     
     <aui:input name="employeeId" type="text" value="${purchase.employeeId}">
      <aui:validator name="required"/>
     </aui:input>
     <aui:input name="electronicsId" type="text" value="${purchase.electronicsId}">
      <aui:validator name="required"/>
     </aui:input>

     <aui:input type="submit" value="Update" name="update"></aui:input>
            
</aui:form>