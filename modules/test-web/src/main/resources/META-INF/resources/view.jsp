<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="init.jsp"%>
<%@ page language="java" import="java.util.*" errorPage=""%>
<%@ page import="com.test.model.Employee"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<portlet:defineObjects />

<liferay-ui:error key="wrongDate" message="wrong-date" />

<%
	List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
%>


<portlet:renderURL var="importCsvEmployeeRenderURL">
	<portlet:param name="mvcPath" value="/import-employee.jsp" />
</portlet:renderURL>

<div class="mb-5">
	<a href="${importCsvEmployeeRenderURL}" class="btn btn-info btn-lg"> <i
		class="glyphicon glyphicon-plus"></i> Import CSV files
	</a>
</div>


<portlet:renderURL var="addEmployeeRenderURL">
	<portlet:param name="mvcPath" value="/add-employee.jsp" />
</portlet:renderURL>

<div class="mb-5">
	<a href="${addEmployeeRenderURL}" class="btn btn-info btn-lg"> <i
		class="glyphicon glyphicon-plus"></i> Add Employee
	</a>
</div>

<liferay-ui:search-container total="<%=employeeList.size() %>"
	var="searchContainer" delta="5" deltaConfigurable="true"
	emptyResultsMessage="There are no employees to display.">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(employeeList, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row className="com.test.model.Employee"
		modelVar="employee" keyProperty="employeeId">
		<liferay-ui:search-container-column-text name="Firstname"
			property="firstname" />
		<liferay-ui:search-container-column-text name="Lastname"
			property="lastname" />
		<liferay-ui:search-container-column-text name="Patronymic"
			property="patronymic" />
		<liferay-ui:search-container-column-date name="Birthdate"
			property="birthdate" />
		<liferay-ui:search-container-column-text name="Gender"
			property="gender" />
		<liferay-ui:search-container-column-text name="Position"
			property="positionTypeId" />
			


		<liferay-ui:search-container-column-text name="Edit">
			<portlet:renderURL var="updateEmployeeRenderURL">
				<portlet:param name="mvcPath" value="/update-employee.jsp" />
				<portlet:param name="employeeId" value="${employee.employeeId}" />
				<portlet:param name="firstname" value="${employee.firstname}" />
				<portlet:param name="lastname" value="${employee.lastname}" />
				<portlet:param name="patronymic" value="${employee.patronymic}" />
				<portlet:param name="birthdate" value="${employee.birthdate}" />
				<portlet:param name="gender" value="${employee.gender}" />
			</portlet:renderURL>
			<a href="${updateEmployeeRenderURL}">Edit</a>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Delete">
			<portlet:actionURL name="deleteEmployee"
				var="deleteEmployeeActionURL">
				<portlet:param name="employeeId" value="${employee.getEmployeeId()}" />
			</portlet:actionURL>
			<a href="${deleteEmployeeActionURL}">Delete</a>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>







