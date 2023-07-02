package com.sabanciuniv.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Exercise {
	
	@Id
	private String id;
	
	private String name;
	private String explanation;
	private String level; // It is hardness --> {EASY, MEDIUM, HARD}
	private String videoUrl;
	private String imagePath;
	
	private Muscle muscle;
	
	@DBRef
	private List<Comment> comments;
	
	
	
	public Exercise() {
		// TODO Auto-generated constructor stub
	}



	public Exercise(String name, String explanation, String level , String videoUrl, Muscle muscle, String imagePath) {
		super();
		this.name = name;
		this.level = level;
		this.explanation = explanation;
		this.videoUrl = videoUrl;
		this.muscle = muscle;
		this.imagePath = imagePath;
	}
	



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
	


	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public String getExplanation() {
		return explanation;
	}



	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	

	public String getVideoUrl() {
		return videoUrl;
	}



	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}



	public Muscle getMuscle() {
		return muscle;
	}



	public void setMuscle(Muscle muscle) {
		this.muscle = muscle;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	



	


	
	
	
	
	
	
}
