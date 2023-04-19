package com.viswa.learnspringboot1.courses.controller;

//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viswa.learnspringboot1.courses.bean.Course;
import com.viswa.learnspringboot1.courses.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	//@RequestMapping
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		//return Arrays.asList(new Course(1, "Learn Aws", "Viswa"), new Course(2, "Learn Java", "Akshay"))
		return repository.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id){
		 Optional<Course> course = repository.findById(id);
		 if(course.isEmpty()) {
			 throw new RuntimeException("Couse is not aviale for the id " + id);
		 }
		 return course.get();
		
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course){
		 
		 repository.save(course);
		
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course){
		 repository.save(course);
		
	}
	
	@DeleteMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id){
		 repository.deleteById(id);
		
	}

}
