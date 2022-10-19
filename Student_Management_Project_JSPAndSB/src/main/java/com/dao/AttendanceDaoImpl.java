package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Attendance;
import com.entity.Student;

@Repository
public class AttendanceDaoImpl extends JdbcDaoSupport {
	@Autowired
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Attendance> AttendanceBySid(int sid, String semestar) {
		try {
			String sql = "select * from attendance where sid=? and semestar=?";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { sid, semestar });
			List<Attendance> list = new ArrayList<Attendance>();
			for (Map row : rows) {
				Attendance a = new Attendance();
				a.setId((int) row.get("id"));
				a.setCourse(row.get("course").toString());
				a.setDays(row.get("days").toString());
				a.setMonth(row.get("month").toString());
				a.setSid(sid);
				a.setSname(row.get("sname").toString());
				a.setYear(row.get("year").toString());
				a.setSemestar(semestar);
				list.add(a);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * public void updateAttendance(int id,String days) {
	 * 
	 * try { String sql="update attendance set days=? where id=?"; Attendance a =
	 * getJdbcTemplate().queryForObject(sql, new Object[] {days,id},new
	 * RowMapper<Attendance>() {
	 * 
	 * @Override public Attendance mapRow(ResultSet rs, int rowNum) throws
	 * SQLException{ Attendance a= new Attendance(); return a; } });
	 * 
	 * } catch (Exception e) {
	 * 
	 * } }
	 */

	public int updateAttendance(int id, String days) {
		int i = 0;
		try {
			String sql = "update attendance set days=? where id=?";
			i = jdbcTemplate.update(sql, new Object[] { days, id });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deleteByStudentId(int sid) {
		int i = 0;
		try {
			String sql = "delete from attendance where sid=?";
			i = jdbcTemplate.update(sql, new Object[] { sid });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}
}
