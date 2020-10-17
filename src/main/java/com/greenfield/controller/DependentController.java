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
import com.greenfield.model.Dependent;
import com.greenfield.repository.DependentRepo;

@RestController
@RequestMapping(path = "/Dependent")
@RepositoryRestController
public class DependentController {

	@Autowired
	DependentDaoImpl depDaoImpl;

	@Autowired
	DependentRepo dependentRepo;

	// creates dependent through parameters and binds it with the enrollee
	// dependent created in Dependent collection and referenced in Enrollee
	// collection
	@PostMapping
	public ResponseEntity<String> AddDependentToEnrollee(@RequestParam int enrolleeId, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam Date birthday) {

		depDaoImpl.InsertDependentWithEnrollee(enrolleeId, firstName, lastName, birthday);

		return new ResponseEntity<String>("Dependent has been added to Enrollee!", HttpStatus.CREATED);

	}

	// finds a dependent from the Dependent collection
	@GetMapping
	public ResponseEntity<String> FindDependent(@RequestParam int id) {

		Dependent d = new Dependent();
		d = depDaoImpl.FindDependentById(id);
		System.out.println(d.toString());

		return new ResponseEntity<String>("found dependents", HttpStatus.FOUND);
	}

	// delete dependent
	@DeleteMapping
	public ResponseEntity<String> DeleteDependent(@RequestParam int id) {

		depDaoImpl.DeleteDependent(id);

		return new ResponseEntity<String>("Dependent has been removed", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> UpdateDependent(@RequestParam int id, @RequestParam String firstName, 
			@RequestParam String lastName, @RequestParam Date birthday){
		
		depDaoImpl.UpdateSoloDependent(id, firstName, lastName, birthday);
		
		
		return new ResponseEntity<String>("Dependent has been updated!", HttpStatus.ACCEPTED);
	}

}
