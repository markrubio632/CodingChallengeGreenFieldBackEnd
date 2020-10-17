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

	public long generateId() {
		long userCounter = 0;

		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll(Sort.by(Sort.Direction.DESC, "_id"));

		for (Enrollee enroll : eList) {
			if (enroll.getEnrolleeId() >= userCounter) {
				System.out.println("user counter before" + userCounter);
				userCounter = enroll.getEnrolleeId() + 1;
				System.out.println("user counter after" + userCounter);
			}
		}
		return userCounter;
	}
	
}
