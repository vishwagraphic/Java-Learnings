package com.viswa.learnspringboot1.courses.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String author;
	
	
	public Course() {
		
	}
	
	public long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	public String getName() {
		return name;
	}


	public String getAuthor() {
		return author;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	

}
