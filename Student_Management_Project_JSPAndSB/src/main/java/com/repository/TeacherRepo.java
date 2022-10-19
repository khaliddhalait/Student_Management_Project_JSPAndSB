package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Teacher;


public interface TeacherRepo extends JpaRepository<Teacher, Integer>{
}
