package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Exercise;
import com.sabanciuniv.model.Muscle;

public interface MuscleRepo extends MongoRepository<Muscle, String>{

	
	public List<Muscle> findAll(); 
	
}
