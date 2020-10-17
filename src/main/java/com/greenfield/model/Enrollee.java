package com.greenfield.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

@Document(collection = "Enrollee")
public class Enrollee {

	@Id
	private int enrolleeId;
	private String firstName;
	private String lastName;
	private boolean activeStatus;
	private Date birthday;
	@Nullable
	private String phoneNumber;
	@DBRef
	private List<Dependent> dependents;

	public Enrollee() {
		super();
	}

	public Enrollee(int enrolleeId, String firstName, String lastName, boolean activeStatus, Date birthday,
			String phoneNumber, List<Dependent> dependents) {
		super();
		this.enrolleeId = enrolleeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeStatus = activeStatus;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.dependents = dependents;
	}

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

	@Override
	public String toString() {
		return "Enrollee [enrolleeId=" + enrolleeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", activeStatus=" + activeStatus + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber
				+ ", dependents=" + dependents + "]";
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

}
