package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
