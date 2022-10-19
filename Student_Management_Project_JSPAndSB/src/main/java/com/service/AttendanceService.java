package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.AttendanceDaoImpl;
import com.dao.StudentDaoImpl;
import com.entity.Attendance;
import com.repository.AttendanceRepo;

import java.util.List;
import java.util.Map;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepo arepo;
	
	@Autowired
	private AttendanceDaoImpl adao;
	
	public Attendance addAttendance(Attendance attendance) {
		return arepo.save(attendance);
	}
	
	public List<Attendance> getAttendanceById(int sid, String semestar) {
		List<Attendance> list = adao.AttendanceBySid(sid, semestar);
		return list;
	}
	
	public boolean deleteAttendance(int id) {
		arepo.deleteById(id);
		return arepo.existsById(id)==false ? true:false;
	}
	
	public Attendance getAttendanceById(int id) {
		return arepo.getById(id);
	}
	
	public boolean updateAttendanceById(int id, String days) {
		int i = adao.updateAttendance(id, days);
		return i == 1 ? true : false;
	}
	
}
