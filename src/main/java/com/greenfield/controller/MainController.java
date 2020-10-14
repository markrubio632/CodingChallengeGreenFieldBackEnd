package com.greenfield.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.dao.EnrolleeDaoImpl;
import com.greenfield.model.Enrollee;
import com.greenfield.repository.EnrolleeRepo;

@RestController
@RequestMapping(path = "/main")
@RepositoryRestController
public class MainController {
	
	@Autowired
	EnrolleeDaoImpl eDaoImpl;
	
	@Autowired
	EnrolleeRepo enrolleeRepo;
	
	@PostMapping("/useradd")
	public String saveUser() {
		//this gives error due to duplicate id
		//create a way to auto increment idea (cant use a counter in main)(pull max id from DB and increment from there?)
		enrolleeRepo.save(new Enrollee(0, "Mark", "Rubio", true, new Date(), "(928)928-9289", 0));
		return "useradd";
	}
	
	@PostMapping("/name")
	public String checkName(String firstName) {
		
		eDaoImpl.FindByFirstName(firstName);
		
		return "name";
	}
	
	

}
