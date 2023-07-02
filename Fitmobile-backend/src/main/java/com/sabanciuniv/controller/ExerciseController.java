package com.sabanciuniv.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.model.Comment;
import com.sabanciuniv.model.Exercise;
import com.sabanciuniv.model.Muscle;
import com.sabanciuniv.repo.CommentRepo;
import com.sabanciuniv.repo.ExerciseRepo;
import com.sabanciuniv.repo.MuscleRepo;

@RestController
@RequestMapping("/muscle")
public class ExerciseController {
	
	@Autowired CommentRepo commentRepo;
	@Autowired ExerciseRepo exerciseRepo;
	@Autowired MuscleRepo muscleRepo;

	@GetMapping("/groups")
	public List<Muscle> getAllMuscleGroups(){
		
		List<Muscle> muscleGroups = muscleRepo.findAll();
		
		return muscleGroups;
	}
	
	
	@GetMapping("/exercises")
	public List<Exercise> getAllExercises(){
		
		List<Exercise> exercises = exerciseRepo.findAll();
		return exercises;
	}
	
	
	@GetMapping("/groups/{name}")
	public List<Exercise> getExercisesByGroup(@PathVariable("name") String name){
		
		List<Exercise> ex = exerciseRepo.findByMuscleGroup(name);
		
		return ex;
	
	}
	
	@GetMapping("/exercises/{name}")
	public List<Exercise> getExercisesByName(@PathVariable("name") String name){
		
		List<Exercise> exercises = exerciseRepo.findByNameLikeIgnoreCase(name);
		return exercises;
	}
	
	
	
}
