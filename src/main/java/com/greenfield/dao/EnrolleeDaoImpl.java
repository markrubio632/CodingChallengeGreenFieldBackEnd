package com.greenfield.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greenfield.model.Enrollee;
import com.greenfield.repository.EnrolleeRepo;

@Component
public class EnrolleeDaoImpl implements EnrolleeDao {

	@Autowired
	EnrolleeRepo enrollRepo;

	@Override
	public Enrollee FindByFirstName(String firstName) {

		Enrollee enrollee = new Enrollee();

		for (Enrollee enroll : enrollRepo.findAll()) {

			if (enroll.getFirstName().equals(firstName)) {
				enrollee = enroll;
				return enrollee;
			}

		}
		System.out.println(enrollee.toString());

		return enrollee;
	}

}
