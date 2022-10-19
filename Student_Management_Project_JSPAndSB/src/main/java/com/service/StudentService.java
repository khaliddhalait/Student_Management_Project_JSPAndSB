package com.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AttendanceDaoImpl;
import com.dao.MarkDaoImpl;
import com.dao.StudentDaoImpl;
import com.entity.*;
import com.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo srepo;

	@Autowired
	private StudentDaoImpl sdao;

	@Autowired
	private MarkDaoImpl mdao;

	@Autowired
	private AttendanceDaoImpl adao;

	public boolean addStudent(Student student) {
		Student s = srepo.save(student);
		return s != null ? true : false;
	}

	public List<Student> getStudent() {
		return srepo.findAll();
	}

	public int getStudentCount() {
		List<Student> list = getStudent();
		return list.size();
	}

	public List<Student> getStudent(String course, String semestar) {
		List<Student> s = getStudent();
		List<Student> allstd = new ArrayList<Student>();
		for (Student l : s) {
			String c = l.getCourse();
			String sem = l.getSemestar();
			if (course.equals(c) && semestar.equals(sem)) {
				allstd.add(l);
			}
		}
		return allstd;
	}

	public boolean deleteStudentById(int id) {
		try {
			mdao.deleteByStudentId(id);
			adao.deleteByStudentId(id);
			srepo.deleteById(id);
			if (srepo.existsById(id))
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(String email, String password) {
		Student s = sdao.loginValidation(email);
		if (s != null) {
			if (s.getPassword().equals(password))
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public Student getLogin(String email, String password) {
		return sdao.loginValidation(email);
	}

	public boolean updateProfile(Student student) {
		int i = sdao.updateStudent(student);
		return i == 1 ? true : false;
	}

	public Student getStudentById(int id) {
		return srepo.getById(id);
	}

	public boolean updatePassword(String cpassword, String npassword, String email) {
		if (validate(email, cpassword)) {
			int i = sdao.updatePassword(npassword, email);

			if (i == 1) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}
