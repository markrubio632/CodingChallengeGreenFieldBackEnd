package com.greenfield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;

import com.greenfield.model.Enrollee;
import com.greenfield.repository.DependentRepo;
import com.greenfield.repository.EnrolleeRepo;

@Service
public class MainService {

	@Autowired
	EnrolleeRepo enrolleeRepo;
	
	@Autowired
	DependentRepo dependentRepo;

	//generates an ID using the last ID used plus 1
	public long generateId() {
		long userCounter = 0;

		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll(Sort.by(Sort.Direction.DESC, "_id")); //Sorts the ID fields by the biggest ID first, then descending

		for (Enrollee enroll : eList) {
			if (enroll.getEnrolleeId() >= userCounter) {
				userCounter = enroll.getEnrolleeId() + 1;
			}
		}
		return userCounter;
	}
	
}
