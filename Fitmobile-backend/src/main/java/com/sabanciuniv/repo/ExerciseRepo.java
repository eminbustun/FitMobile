package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sabanciuniv.model.Comment;
import com.sabanciuniv.model.Exercise;
import com.sabanciuniv.model.Muscle;

public interface ExerciseRepo extends MongoRepository<Exercise, String>{

	
	
	public List<Exercise> findAll(); 
	
	@Query("{'muscle.group':?0}")
	public List<Exercise> findByMuscleGroup(String group); 
	
	
	public List<Exercise> findByNameLikeIgnoreCase(String name); 
	
	
	
	
	
	
}
