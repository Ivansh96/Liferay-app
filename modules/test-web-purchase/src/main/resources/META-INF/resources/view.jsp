<%@ include file="init.jsp"%>
<%@ page language="java" import="java.util.*" errorPage=""%>
<%@ page import="com.test.model.Purchase"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<portlet:defineObjects />

<liferay-ui:error key="wrongEtype" message="wrong-etype" />
<liferay-ui:error key="emptyCount" message="empty-count" />
<liferay-ui:error key="wrongDate" message="wrong-date" />

<%
	List<Purchase> purchaseList = (List<Purchase>) request.getAttribute("purchaseList");
%>

<portlet:renderURL var="importCsvPurchaseRenderURL">
	<portlet:param name="mvcPath" value="/import-purchase.jsp" />
</portlet:renderURL>

<div class="mb-5">
	<a href="${importCsvPurchaseRenderURL}" class="btn btn-info btn-lg"> <i
		class="glyphicon glyphicon-plus"></i> Import CSV files
	</a>
</div>

<portlet:renderURL var="addPurchaseRenderURL">
	<portlet:param name="mvcPath" value="/add-purchase.jsp" />
</portlet:renderURL>

<div class="mb-5">
	<a href="${addPurchaseRenderURL}" class="btn btn-info btn-lg"> <i
		class="glyphicon glyphicon-plus"></i> Add Purchase
	</a>
</div>

<liferay-ui:search-container total="<%=purchaseList.size() %>"
	var="searchContainer" delta="5" deltaConfigurable="true"
	emptyResultsMessage="There is no purchase to display.">
	
	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(purchaseList, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row className="com.test.model.Purchase"
		modelVar="purchase" keyProperty="purchaseId">
		<liferay-ui:search-container-column-date name="Purchase Date"
			property="purchaseDate" />
		<liferay-ui:search-container-column-text name="Employee"
			property="employeeId" />
		<liferay-ui:search-container-column-text name="Electronics"
			property="electronicsId" />
		<liferay-ui:search-container-column-text name="Purchase type"
			property="purchaseTypeId" />

		<liferay-ui:search-container-column-text name="Edit">
			<portlet:renderURL var="updatePurchaseRenderURL">
				<portlet:param name="mvcPath" value="/update-purchase.jsp" />
				<portlet:param name="purchaseId" value="${purchase.purchaseId}" />
				<portlet:param name="purchaseDate" value="${purchase.purchaseDate}" />
				<portlet:param name="employeeId" value="${purchase.employeeId}" />
				<portlet:param name="electronicsId" value="${purchase.electronicsId}" />					
				<portlet:param name="purchaseTypeId" value="${purchase.purchaseTypeId}" />					
			</portlet:renderURL>
			<a href="${updatePurchaseRenderURL}">Edit</a>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Delete">
			<portlet:actionURL name="deletePurchase"
				var="deletePurchaseActionURL">
				<portlet:param name="purchaseId" value="${purchase.getPurchaseId()}" />
			</portlet:actionURL>
			<a href="${deletePurchaseActionURL}">Delete</a>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
