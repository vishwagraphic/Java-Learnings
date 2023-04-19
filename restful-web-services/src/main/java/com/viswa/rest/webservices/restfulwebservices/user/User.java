package com.viswa.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viswa.rest.webservices.restfulwebservices.posts.Posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


//@JsonIgnoreProperties({"name","birthDate"})
//@JsonFilter("SomeUsers")
@Entity(name = "user_details")
public class User {
	protected User() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, message="name should have atleast 2 characters")
	//@JsonProperty("user_name")
	private String name;
	@Past(message="Birth date should be in the past")
	//@JsonIgnore
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Posts> posts;
	
	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	
	
	
}
