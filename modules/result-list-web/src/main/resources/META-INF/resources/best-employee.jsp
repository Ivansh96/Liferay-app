<%@page import="com.test.service.ElectronicsLocalServiceUtil"%>
<%@page import="com.test.service.EmployeeLocalServiceUtil"%>
<%@page import="com.test.model.Electronics"%>
<%@page import="com.test.model.Employee"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page language="java" import="java.util.*" errorPage=""%>
<portlet:defineObjects />

<portlet:actionURL name="getBestEmployee" var="getBestEmployeeActionURL" />

<div class="separator"></div>
<h2>Best employee(Amount of proceeds):</h2>
<br />

<%
	List<Employee> empList = EmployeeLocalServiceUtil.getEmployeeByPosition(2);
	List<Electronics> elEmpList = new ArrayList<>();
	long totalSum = 0;
	String firstname = null;
	String lastname = null;
	String patronymic = null;
	
	for (int i = 0; i < empList.size(); i++) {

		elEmpList = ElectronicsLocalServiceUtil.getElectronicsByEmployeeId(empList.get(i).getEmployeeId());
		for (int j = 0; j < elEmpList.size(); j++) {

			long temp = elEmpList.get(j).getPrice();

			if (temp > totalSum) {				
				totalSum = temp;
				firstname = empList.get(i).getFirstname();
				lastname = empList.get(i).getLastname();
				patronymic = empList.get(i).getPatronymic();
			}
		}
	}
%>
<%=firstname + " " + patronymic + " " + lastname + " , " + "Total sum: " + totalSum %>

<div class="separator"></div>
<h2>Best employee(Number of items sold):</h2>
<br />

<%
   int count = 0;
   int totalCount = 0;
   String firstName = null;
   String lastName = null;
   String patr = null;
   
   for (int i = 0; i < empList.size(); i++) {
	   
	   elEmpList = ElectronicsLocalServiceUtil.getElectronicsByEmployeeId(empList.get(i).getEmployeeId());
	   for (int j = 0; j < elEmpList.size(); j++) {
		   
		   count = elEmpList.size();
		   
		   if(count > totalCount) {
			   totalCount = count;
			   firstName = empList.get(i).getFirstname();
			   lastName = empList.get(i).getLastname();
			   patr = empList.get(i).getPatronymic();
		   }
	   }
   }
%>
<%=firstName + " " + patr + " " + lastName + " , " + "Total amount: " + totalCount%>