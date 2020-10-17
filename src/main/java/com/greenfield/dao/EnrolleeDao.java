package com.greenfield.dao;

import java.util.Date;
import java.util.List;

import com.greenfield.model.Enrollee;

public interface EnrolleeDao{
	
	public List<Enrollee> FindAllEnrollees();
	
	public Enrollee FindById(int id);
	
	public void DeleteEnrollee(int id);
	
	public void UpdateEnrollee(int id, String firstName, String lastName, boolean isActiveStatus, Date birthday,
			String phoneNumber);
	
	public void SaveEnrollee(String firstName, String lastName, boolean isActiveStatus, Date birthday, String phoneNumber);

}
