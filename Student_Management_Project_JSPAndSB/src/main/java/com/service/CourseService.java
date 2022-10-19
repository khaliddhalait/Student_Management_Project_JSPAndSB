package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Course;
import com.entity.Teacher;
import com.repository.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo crepo;

	public boolean addCourse(String course) {
		Course c = new Course();
		c.setCourse(course);
		Course cn = crepo.save(c);
		if (cn != null)
			return true;
		else
			return false;
	}

	public List<Course> getCourse() {
		return crepo.findAll();
	}
}
