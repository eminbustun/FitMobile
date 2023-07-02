package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {

	
	@Id
	private String id;
	
	private String content;
	
	
	private Exercise exercise;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String content, Exercise exercise) {
		super();
		this.exercise = exercise;
		this.content = content;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [content=" + content + "]";
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	
	
	
	
	
	
}
