package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Muscle {
	
	
	private String id;
	
	private String group;
	private String info;
	
	
	
	
	public Muscle() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Muscle(String group, String info) {
		super();
		this.group = group;
		this.info = info;
	}


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
