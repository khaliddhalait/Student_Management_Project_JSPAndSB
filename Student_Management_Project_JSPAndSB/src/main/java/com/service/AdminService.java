package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.entity.Student;
import com.repository.AdminRepo;
import com.repository.NoticeRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo adrepo;

	public boolean validateAdmin(String email, String password) {
		boolean b = false;
		if (email.equals("admin@gmail.com") && password.equals("YWRtaW4xMjM=")) {//admin123
			b = true;
		}
		return b;
	}

}
