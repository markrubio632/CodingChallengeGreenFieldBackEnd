package com.greenfield.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dependent")
public class Dependent {

	@Id
	private int dependentId;
	private String firstName;
	private String lastName;
	private Date birthday;

	public Dependent() {
		super();
	}

	public Dependent(int dependentId, String firstName, String lastName, Date birthday) {
		super();
		this.dependentId = dependentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}

	public int getDependentId() {
		return dependentId;
	}

	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Dependent [dependentId=" + dependentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + "]";
	}

}
