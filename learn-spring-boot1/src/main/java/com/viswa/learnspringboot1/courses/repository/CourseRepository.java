package com.viswa.learnspringboot1.courses.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viswa.learnspringboot1.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {



}
