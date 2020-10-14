package com.greenfield.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Enrollee")
public class Enrollee {

	@Id
	private int enrolleeId;
	private String firstName;
	private String lastName;
	private boolean activeStatus;
	private Date birthday;
	private String phoneNumber;
	//@OneToMany(targetEntity = com.greenfield.model.Dependent.class, cascade=CascadeType.ALL, mappedBy="Dependent")
	private int dependents; // used to determine a numerical amount of deps

	public int getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
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

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getDependents() {
		return dependents;
	}

	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

	@Override
	public String toString() {
		return "Enrollee [enrolleeId=" + enrolleeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", activeStatus=" + activeStatus + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber
				+ ", dependents=" + dependents + "]";
	}

	public Enrollee() {
		super();
	}

	public Enrollee(int enrolleeId, String firstName, String lastName, boolean activeStatus, Date birthday,
			String phoneNumber, int dependents) {
		super();
		this.enrolleeId = enrolleeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeStatus = activeStatus;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.dependents = dependents;
	}

}
