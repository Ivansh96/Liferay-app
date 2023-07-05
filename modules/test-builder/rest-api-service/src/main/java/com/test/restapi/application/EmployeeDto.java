package com.test.restapi.application;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private String patronymic;
	private Date birthdate;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
