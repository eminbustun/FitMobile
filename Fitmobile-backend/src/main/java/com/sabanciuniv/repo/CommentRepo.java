package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sabanciuniv.model.Comment;
import com.sabanciuniv.model.Exercise;

public interface CommentRepo extends MongoRepository<Comment, String>{
	
	
	public List<Comment> findAll();
	
	
	@Query("{'exercise.name':?0}")
	public List<Comment> findByExerciseName(String name);

}
