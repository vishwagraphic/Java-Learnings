package com.viswa.learnSpringBoot.learnspringbootwithh2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.viswa.learnSpringBoot.learnspringbootwithh2.Course;

@Repository
public class CourseJdbcrepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY= """
				insert into course(id, name, author) values(?, ?, ?)
			""";
	
	private static String DELETE_QUERY= """
			delete from course where id = ?
		""";
	
	private static String SELECT_QUERY= """
			select * from course where id = ?
		""";
	
	public void insert(Course course1) {
		springJdbcTemplate.update(INSERT_QUERY, course1.getId(), course1.getName(), course1.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}


}
