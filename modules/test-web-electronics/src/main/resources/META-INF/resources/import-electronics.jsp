<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="importCsvElectronics" var="importCsvElectronicsActionURL" windowState="normal"></portlet:actionURL>

<p>
	<b>Add product to Liferay DB from CSV</b>
</p>

<form action="${importCsvElectronicsActionURL}" enctype="multipart/form-data" method="post" id="csvElectronicsForm">
	<div>
		<label>Upload Electronics Data CSV :</label>
		<input type="file" name="electronics" id="electronics"></input>
	</div>
	<div>
		<input type="submit" value="Upload" name="upload"></input>
	</div>
</form>