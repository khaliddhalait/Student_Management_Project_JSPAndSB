package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TeacherDaoImpl;
import com.entity.Student;
import com.entity.Teacher;
import com.repository.TeacherRepo;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepo trepo;

	@Autowired
	private TeacherDaoImpl tdao;

	public boolean addTeacher(Teacher teacher) {
		Teacher t = trepo.save(teacher);
		if (t != null)
			return true;
		else
			return false;
	}

	public List<Teacher> getTeacher() {
		return trepo.findAll();
	}

	public Teacher getTeacherById(int id) {
		return trepo.getById(id);
	}

	public int getTeacherCount() {
		List<Teacher> list = getTeacher();
		return list.size();
	}

	public boolean deleteTeacherById(int id) {
		trepo.deleteById(id);
		if (trepo.existsById(id))
			return false;
		else
			return true;
	}

	public boolean validate(String email, String password) {
		Teacher t = tdao.loginValidation(email);
		if (t != null) {
			if (t.getPassword().equals(password))
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public Teacher getLogin(String email, String password) {
		return tdao.loginValidation(email);
	}

	public boolean updatePassword(String cpassword, String npassword, String email) {
		if (validate(email, cpassword)) {
			int i = tdao.updatePassword(npassword, email);

			if (i == 1) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public boolean updateProfile(Teacher teacher) {
		int i = tdao.updateStudent(teacher);
		if (i == 1)
			return true;
		else
			return false;
	}
}
