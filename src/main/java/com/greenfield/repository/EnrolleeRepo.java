package com.greenfield.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greenfield.model.Enrollee;

@Repository("enrolleeRepo")
public interface EnrolleeRepo extends MongoRepository<Enrollee, String>{

}
