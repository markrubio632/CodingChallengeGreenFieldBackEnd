package com.greenfield.dao;

import com.greenfield.model.Enrollee;

public interface EnrolleeDao{
	
	public Enrollee FindByFirstName(String firstName);

}
