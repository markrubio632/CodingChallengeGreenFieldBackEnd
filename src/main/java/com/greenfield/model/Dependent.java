package com.greenfield.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dependent")
public class Dependent {

	@Id
	private Integer dependentId;
	private String firstName;
	private String lastName;
	private int enrolleeId;

	public Dependent() {
		super();
	}

	public Dependent(Integer dependentId, String firstName, String lastName, int enrolleeId) {
		super();
		this.dependentId = dependentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enrolleeId = enrolleeId;
	}

	public Integer getDependentId() {
		return dependentId;
	}

	public void setDependentId(Integer dependentId) {
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

	public int getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	@Override
	public String toString() {
		return "Dependent [dependentId=" + dependentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", enrolleeId=" + enrolleeId + "]";
	}

}
