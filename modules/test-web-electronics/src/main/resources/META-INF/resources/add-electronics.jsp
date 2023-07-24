<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>

<portlet:actionURL var="addElectronicsURL" name="addElectronics"/>
 
<h2>New electronics form</h2>

<aui:form action="${addElectronicsURL}" name="electronicsForm" method="POST">
   <aui:input name="name" >
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">75</aui:validator>
   </aui:input>
   <aui:input name="price" >
      <aui:validator name="required"/>
      <aui:validator name="number"/>
   </aui:input>
   <aui:input name="count" >
      <aui:validator name="required"/>
      <aui:validator name="number"/>
   </aui:input>
   <aui:input name="inStock" disabled="true" type="hidden" >
    <aui:select name="inStock">   
     <aui:option value="true">In stock</aui:option>     
     <aui:option value="false">Not in stock</aui:option>     
    </aui:select>
      <aui:validator name="required"/>
   </aui:input>
   <aui:input name="archive" disabled="true" type="hidden" >
    <aui:select name="archive">   
     <aui:option value="true">In archive</aui:option>     
     <aui:option value="false">On sale</aui:option>     
    </aui:select>
      <aui:validator name="required"/>
   </aui:input>
   <aui:input name="description" >
      <aui:validator name="required"/>
      <aui:validator name="maxLength" errorMessage="You've reached the limit">5000</aui:validator>
   </aui:input>
   <aui:input name="etype" disabled="true" type="hidden">
    <aui:select name="etype">   
     <aui:option value="1">TV</aui:option>     
     <aui:option value="2">PC</aui:option>
     <aui:option value="3">Smartphone</aui:option>  
     <aui:option value="4">Fridge</aui:option>
     <aui:option value="5">Audio</aui:option>         
    </aui:select>
      <aui:validator name="required"/>
   </aui:input>
   
   <aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form> 
