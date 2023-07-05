<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="importCsvPurchase" var="importCsvPurchaseActionURL" windowState="normal"></portlet:actionURL>

<p>
	<b>Add purchase to Liferay DB from CSV</b>
</p>

<form action="${importCsvPurchaseActionURL}" enctype="multipart/form-data" method="post" id="csvPurchaseForm">
	<div>
		<label>Upload Purchase Data CSV :</label>
		<input type="file" name="purchase" id="purchase"></input>
	</div>
	<div>
		<input type="submit" value="Upload" name="upload"></input>
	</div>
</form>