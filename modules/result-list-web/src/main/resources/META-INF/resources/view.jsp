<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<portlet:renderURL var="getTotalAmountRenderURL">
  <portlet:param name="mvcPath" value="/total-cost.jsp"/>
</portlet:renderURL>

<div class="mb-5">
    <a href="${getTotalAmountRenderURL}" class="btn btn-info btn-lg">
        <i class="glyphicon glyphicon-plus"></i> Cash payment total amount
    </a>
</div>


<portlet:renderURL var="getPurchaseCountRenderURL">
  <portlet:param name="mvcPath" value="/purchase-count.jsp"/>
</portlet:renderURL>

<div class="mb-5">
    <a href="${getPurchaseCountRenderURL}" class="btn btn-info btn-lg">
        <i class="glyphicon glyphicon-plus"></i> Amount of audio equipment
    </a>
</div>

<portlet:renderURL var="getBestEmployeeRenderURL">
  <portlet:param name="mvcPath" value="/best-employee.jsp"/>
</portlet:renderURL>

<div class="mb-5">
    <a href="${getBestEmployeeRenderURL}" class="btn btn-info btn-lg">
        <i class="glyphicon glyphicon-plus"></i> Get best employee
    </a>
</div>

