<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ include file="init.jsp"%>
<%@ page language="java" import="java.util.*" errorPage=""%>
<%@ page import="com.test.model.Electronics"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<portlet:defineObjects />

<%
	List<Electronics> electronicsList = (List<Electronics>) request.getAttribute("electronicsList");
%>


<portlet:renderURL var="importCsvElectronicsRenderURL">
	<portlet:param name="mvcPath" value="/import-electronics.jsp" />
</portlet:renderURL>

<div class="mb-5">
	<a href="${importCsvElectronicsRenderURL}" class="btn btn-info btn-lg"> <i
		class="glyphicon glyphicon-plus"></i> Import CSV files
	</a>
</div>


<portlet:renderURL var="addElectronicsRenderURL">
	<portlet:param name="mvcPath" value="/add-electronics.jsp" />
</portlet:renderURL>

<div class="mb-5">
	<a href="${addElectronicsRenderURL}" class="btn btn-info btn-lg"> <i
		class="glyphicon glyphicon-plus"></i> Add Electronic
	</a>
</div>

<liferay-ui:search-container total="<%=electronicsList.size() %>"
	var="searchContainer" delta="5" deltaConfigurable="true"
	emptyResultsMessage="There are no products to display.">

	<liferay-ui:search-container-results 
	    results="<%=ListUtil.subList(electronicsList, searchContainer.getStart(), searchContainer.getEnd())%>" /> 
	<liferay-ui:search-container-row className="com.test.model.Electronics"
		modelVar="electronics" keyProperty="electronicsId">
		<liferay-ui:search-container-column-text name="Name" property="name" />
		<liferay-ui:search-container-column-text name="Price" property="price" />
		<liferay-ui:search-container-column-text name="Count" property="count" />
		<liferay-ui:search-container-column-text name="In stock"
			property="inStock" />
		<liferay-ui:search-container-column-text name="Archive"
			property="archive" />
		<liferay-ui:search-container-column-text name="Description"
			property="description" />
		<liferay-ui:search-container-column-text name="Electro type"
			property="electroTypeId" />

		<liferay-ui:search-container-column-text name="Edit">
			<portlet:renderURL var="updateElectronicsRenderURL">
				<portlet:param name="mvcPath" value="/update-electronics.jsp" />
				<portlet:param name="electronicsId"
					value="${electronics.electronicsId}" />
				<portlet:param name="name" value="${electronics.name}" />
				<portlet:param name="price" value="${electronics.price}" />
				<portlet:param name="count" value="${electronics.count}" />
				<portlet:param name="inStock" value="${electronics.inStock}" />
				<portlet:param name="archive" value="${electronics.archive}" />
				<portlet:param name="description" value="${electronics.description}" />
			</portlet:renderURL>
			<a href="${updateElectronicsRenderURL}">Edit</a>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Delete">
			<portlet:actionURL name="deleteElectronics"
				var="deleteElectronicsActionURL">
				<portlet:param name="electronicsId"
					value="${electronics.getElectronicsId()}" />
			</portlet:actionURL>
			<a href="${deleteElectronicsActionURL}">Delete</a>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
