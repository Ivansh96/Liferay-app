<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page  language="java" import="java.util.*" errorPage="" %>
<%@ page import="com.test.model.Purchase" %>
<%@ page import="com.test.service.PurchaseLocalServiceUtil" %>
<portlet:defineObjects/>

<portlet:actionURL name="getPurchaseCount" var="getPurchaseCountActionURL" />

<div class="separator"></div>
<h2><b>Amount of audio equipment sold in the last month up to 15000:</b></h2><br/>

<% 
   Calendar calendar = new GregorianCalendar(2023, 4, 31);
   Date date = calendar.getTime();
   
   List<Purchase> purchaseList = PurchaseLocalServiceUtil.getPurchaseCount(5, 1500000, date);
   int purchaseCount = purchaseList.size();
%>
<%="Quantity: " + purchaseCount%>
<br/>