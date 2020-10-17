package com.greenfield.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greenfield.model.Dependent;

@Repository("dependentRepo")
public interface DependentRepo extends MongoRepository<Dependent, String>{

}
