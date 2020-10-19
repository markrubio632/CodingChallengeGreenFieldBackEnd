package com.greenfield.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.greenfield.model.Dependent;
import com.greenfield.model.Enrollee;
import com.greenfield.repository.DependentRepo;
import com.greenfield.repository.EnrolleeRepo;
import com.greenfield.service.MainService;

@Component
public class EnrolleeDaoImpl implements EnrolleeDao {

	@Autowired
	EnrolleeRepo enrolleeRepo;
	
	@Autowired
	DependentRepo dependentRepo;
	
	@Autowired
	MainService service;

	//used to find all Enrollees and place them into a list
	public List<Enrollee> FindAllEnrollees() {
		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll();
		for (Enrollee e : eList) {
			eList.add(e);
		}
		return eList;
	}

	//Used to find an Enrollee using and ID to search for
	public Enrollee FindById(int id) {

		Enrollee enroll = new Enrollee();

		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll();
		
		List<Dependent> depList = new ArrayList<Dependent>();

		for (Enrollee e : eList) {

			if (e.getEnrolleeId() == id) {
				depList = e.getDependents();
				enroll = new Enrollee(e.getEnrolleeId(), e.getFirstName(), e.getLastName(), e.isActiveStatus(),
						e.getBirthday(), e.getPhoneNumber(), depList);
				return enroll;
			}

		}

		return enroll;
	}

	//Deletes and Enrollee from the DB
	public void DeleteEnrollee(int id) {
		List<Enrollee> eList = new ArrayList<Enrollee>();

		eList = enrolleeRepo.findAll();

		for (Enrollee e : eList) {
			if (e.getEnrolleeId() == id) {
				enrolleeRepo.delete(e);
			}
		}

	}

	//Updates an enrollee while keeping the same dependents
	public void UpdateEnrollee(int id, String firstName, String lastName, boolean isActiveStatus, Date birthday,
			String phoneNumber) {

		int idToKeep;

		Enrollee enrollee = new Enrollee();
		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll();

		for (Enrollee e : eList) {
			if (e.getEnrolleeId() == id) {
				idToKeep = e.getEnrolleeId();
				DeleteEnrollee(e.getEnrolleeId());
				enrollee = new Enrollee(idToKeep, firstName, lastName, isActiveStatus, birthday, phoneNumber, e.getDependents());
				enrolleeRepo.save(enrollee);
			}
		}

	}
	
	//Saves an Enrollee
	public void SaveEnrollee(String firstName, String lastName, boolean isActiveStatus, Date birthday, String phoneNumber) {
		
		List<Dependent> depList = new ArrayList<Dependent>();
		
		Enrollee newApplicant = new Enrollee();
		newApplicant.setEnrolleeId((int) service.generateId());
		newApplicant.setFirstName(firstName);
		newApplicant.setLastName(lastName);
		newApplicant.setActiveStatus(isActiveStatus);
		newApplicant.setBirthday(birthday);
		newApplicant.setPhoneNumber(phoneNumber);
		newApplicant.setDependents(depList);
		
		enrolleeRepo.save(newApplicant);
	}

}
