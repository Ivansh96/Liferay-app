<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>


<portlet:actionURL name="updateElectronics" var="updateElectronicsActionURL"/>

<aui:form action="${updateElectronicsActionURL}" name="electronicsForm" method="POST"/>

<%

   String electronicsId = renderRequest.getParameter("electronicsId");
   String name = renderRequest.getParameter("name");
   String price = renderRequest.getParameter("price");
   String count = renderRequest.getParameter("count");
   String inStock = renderRequest.getParameter("inStock");
   String archive = renderRequest.getParameter("archive");
   String description = renderRequest.getParameter("description");
%>

<aui:form action="${updateElectronicsActionURL}" method="post">

     <aui:input name="electronicsId" type="hidden" value="<%=Long.parseLong(electronicsId)%>"/>
     <aui:input name="name" type="text" value="${electronics.name}">
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
     </aui:input>
     <aui:input name="price" type="text" value="${electronics.price}">
      <aui:validator name="required"/>
      <aui:validator name="number"/>
     </aui:input>
     <aui:input name="count" type="text" value="${electronics.count}">
      <aui:validator name="required"/>
      <aui:validator name="number"/>
     </aui:input>
     
     <aui:input name="inStock" type="text" value="${electronics.inStock}" disabled="true">
      <aui:select name="inStock">   
       <aui:option value="true">In stock</aui:option>     
       <aui:option value="false">Not in stock</aui:option>     
      </aui:select>
      <aui:validator name="required"/>      
     </aui:input>
     
     <aui:input name="archive" type="text" value="${electronics.archive}" disabled="true">
      <aui:select name="archive">   
       <aui:option value="true">In archive</aui:option>     
       <aui:option value="false">On sale</aui:option>     
      </aui:select>
      <aui:validator name="required"/>     
     </aui:input>
     
     <aui:input name="description" type="text" value="${electronics.description}">
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">5000</aui:validator>
     </aui:input> 
     <aui:input type="submit" value="Update" name="update"></aui:input>
            
</aui:form>