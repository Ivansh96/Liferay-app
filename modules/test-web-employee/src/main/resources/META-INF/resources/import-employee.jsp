<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="importCsvEmployee" var="importCsvEmployeeActionURL" windowState="normal"></portlet:actionURL>

<p>
	<b>Add employee to Liferay DB from CSV</b>
</p>

<form action="${importCsvEmployeeActionURL}" enctype="multipart/form-data" method="post" id="csvEmployeeForm">
	<div>
		<label>Upload Employee Data CSV :</label>
		<input type="file" name="employee" id="employee"></input>
	</div>
	<div>
		<input type="submit" value="Upload" name="upload"></input>
	</div>
</form>