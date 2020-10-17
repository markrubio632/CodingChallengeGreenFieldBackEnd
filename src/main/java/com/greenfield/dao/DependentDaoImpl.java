package com.greenfield.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

import com.greenfield.model.Dependent;
import com.greenfield.model.Enrollee;
import com.greenfield.repository.DependentRepo;
import com.greenfield.repository.EnrolleeRepo;
import com.greenfield.service.MainService;

@Component
public class DependentDaoImpl implements DependentDao {

	@Autowired
	EnrolleeDaoImpl enrolleeDaoImpl;

	@Autowired
	MainService service;

	@Autowired
	DependentRepo dependentRepo;

	@Autowired
	EnrolleeRepo enrolleeRepo;

	public List<Dependent> FindAllDependents() {

		List<Dependent> depList = new ArrayList<Dependent>();

		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll();
		for (Enrollee e : eList) {
			depList = e.getDependents();
		}
		return depList;
	}

	public Dependent FindDependentById(int id) {

		Dependent dependent = new Dependent();

		List<Dependent> depList = new ArrayList<Dependent>();
		depList = FindAllDependents();
		for (Dependent d : depList) {
			if (d.getDependentId() == id) {
				dependent = new Dependent(d.getDependentId(), d.getFirstName(), d.getLastName(), d.getBirthday());
			}
		}

		return dependent;
	}

	@Override
	public List<Dependent> AddNewDependent(Dependent dependent) {
		List<Dependent> depList = new ArrayList<Dependent>();
		depList.add(dependent);
		return depList;
	}

	public List<Dependent> AddToListOfDependents(List<Dependent> depList, Dependent dependent) {

		List<Dependent> list = new ArrayList<Dependent>();
		list = depList;
		list.add(dependent);

		return list;

	}

	public void InsertDependentWithEnrollee(int enrolleeId, String firstName, String lastName, Date birthday) {

		Enrollee enrollee = new Enrollee();
		Dependent dependent = new Dependent((int) service.generateId(), firstName, lastName, birthday);

		List<Enrollee> eList = new ArrayList<Enrollee>();
		eList = enrolleeRepo.findAll();

		List<Dependent> dList = new ArrayList<Dependent>();

		for (Enrollee e : eList) {
			if (e.getEnrolleeId() == enrolleeId) {
				dList = AddToListOfDependents(e.getDependents(), dependent);

				System.out.println(dList.toString());

				enrolleeDaoImpl.DeleteEnrollee(e.getEnrolleeId());

				enrollee = new Enrollee(e.getEnrolleeId(), e.getFirstName(), e.getLastName(), e.isActiveStatus(),
						e.getBirthday(), e.getPhoneNumber(), dList);
				System.out.println(e.toString());
				enrolleeRepo.save(enrollee);
				dependentRepo.save(dependent);
			}
		}
	}
	
	public void DeleteDependent(int id) {
		List<Dependent> depList = new ArrayList<Dependent>();
		
		depList = FindAllDependents();
		
		for(Dependent d : depList) {
			if(d.getDependentId() == id) {
				dependentRepo.delete(d);
			}
		}
	}

	@Override
	public void UpdateSoloDependent(int id, String firstName, String lastName, Date birthday) {
		
		Dependent dependent = new Dependent();
		
		List<Dependent> depList = new ArrayList<Dependent>();
		depList = dependentRepo.findAll();
		
		for(Dependent d : depList) {
			if(d.getDependentId() == id) {
				DeleteDependent(d.getDependentId());
				dependent = new Dependent(d.getDependentId(), firstName, lastName, birthday);
				dependentRepo.save(dependent);
			}
		}
		
	}

}
