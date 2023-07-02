package com.sabanciuniv.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.model.Comment;
import com.sabanciuniv.payload.Message;
import com.sabanciuniv.repo.CommentRepo;
import com.sabanciuniv.repo.ExerciseRepo;
import com.sabanciuniv.repo.MuscleRepo;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired CommentRepo commentRepo;
	@Autowired ExerciseRepo exerciseRepo;
	@Autowired MuscleRepo muscleRepo;
	
	
	@GetMapping("/all")
	public List<Comment> allComments(){
		List<Comment> cmms = commentRepo.findAll();
		return cmms;
	}
	
	
	@PostMapping("/post")
	public Message saveComment(@RequestBody Comment comment) {
		
		commentRepo.insert(comment);
		
		return new Message("Comment has been saved!", LocalDateTime.now());
		
	}
	
	@GetMapping("/exercise/{name}")
	public List<Comment> getCommentsOfAnExercise(@PathVariable("name") String name){
		List<Comment> cmms = commentRepo.findByExerciseName(name);
		return cmms;
	}
	
	
	
}
