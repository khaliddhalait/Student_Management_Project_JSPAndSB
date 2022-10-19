package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Student;
import com.entity.Subject;
import com.repository.SubjectRepo;

import java.util.List;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepo srepo;

	public boolean addSubject(String course, String semestar, String subject) {
		Subject sub = new Subject();
		sub.setCourse(course);
		sub.setSemestar(semestar);
		sub.setSubject(subject);
		Subject s = srepo.save(sub);
		if (s != null)
			return true;
		else
			return false;
	}

	public List<Subject> getAllSubject() {
		return srepo.findAll();
	}
}
