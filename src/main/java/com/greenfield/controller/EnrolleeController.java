package com.greenfield.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.dao.DependentDaoImpl;
import com.greenfield.dao.EnrolleeDaoImpl;
import com.greenfield.model.Enrollee;
import com.greenfield.repository.DependentRepo;
import com.greenfield.repository.EnrolleeRepo;
import com.greenfield.service.MainService;

@RestController
@RequestMapping(path = "/Enrollee")
@RepositoryRestController
public class EnrolleeController {

	@Autowired
	EnrolleeDaoImpl enrollDaoImpl;

	@Autowired
	DependentDaoImpl depDaoImpl;

	@Autowired
	EnrolleeRepo enrolleeRepo;

	@Autowired
	DependentRepo dependentRepo;

	@Autowired
	MainService service;

	@PostMapping
	public ResponseEntity<String> SaveEnrollee(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam boolean isActiveStatus, @RequestParam Date birthday, @RequestParam String phoneNumber) {

		enrollDaoImpl.SaveEnrollee(firstName, lastName, isActiveStatus, birthday, phoneNumber);

		return new ResponseEntity<String>("Enrollee Added Successfully", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<String> FindEnrolleeById(@RequestParam int id) {

		Enrollee e = new Enrollee();
		e = enrollDaoImpl.FindById(id);
		System.out.println(e.toString());

		return new ResponseEntity<String>("Found Enrollee", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> DeleteEnrollee(@RequestParam int id) {

		enrollDaoImpl.DeleteEnrollee(id);

		if (enrollDaoImpl.FindById(id).equals(null)) {
			return new ResponseEntity<String>("Enrollee was not deleted", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Enrollee deleted", HttpStatus.ACCEPTED);
		}

	}

	@PutMapping
	public ResponseEntity<String> UpdateEnrollee(@RequestParam int enrolleeId, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam boolean isActiveStatus, @RequestParam Date birthday,
			@RequestParam String phoneNumber) {

		enrollDaoImpl.UpdateEnrollee(enrolleeId, firstName, lastName, isActiveStatus, birthday, phoneNumber);

		return new ResponseEntity<String>("Enrollee updated", HttpStatus.ACCEPTED);
	}

}
