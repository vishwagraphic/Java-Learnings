package com.viswa.learnSpringBoot.learnspringbootwithh2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.viswa.learnSpringBoot.learnspringbootwithh2.Course;

@Component
public class JdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcrepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1, "Learn AWS NEW", "Vishwa111"));
		
		
		repository.deleteById(10005);
		
		System.out.println(repository.findById(1));
		System.out.println(repository.findById(10004));
	}

}
