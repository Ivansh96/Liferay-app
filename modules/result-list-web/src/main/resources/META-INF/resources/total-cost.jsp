<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page  language="java" import="java.util.*" errorPage="" %>
<%@ page import="com.test.model.Electronics" %>
<%@ page import="com.test.service.ElectronicsLocalServiceUtil" %>
<portlet:defineObjects/>

<portlet:actionURL name="getTotalAmount" var="getTotalAmountActionURL" />

<div class="separator"></div>
<h2><b>Total amount of revenue in cash:</b></h2><br/>

<% List<Electronics> elList = ElectronicsLocalServiceUtil.getElectronicsByPurchaseType(2);
   long sum = 0;
      
       for(int i = 0; i < elList.size(); i++) {
    	   sum += elList.get(i).getPrice(); 
       }   
%>
<%="Total: " + sum%>
<br/>


