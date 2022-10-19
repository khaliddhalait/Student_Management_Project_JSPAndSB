package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
