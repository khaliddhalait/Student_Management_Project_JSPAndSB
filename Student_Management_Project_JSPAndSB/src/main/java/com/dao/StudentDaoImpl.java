package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Student;

@Repository
public class StudentDaoImpl extends JdbcDaoSupport {
	@Autowired
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Student loginValidation(String email) {
		try {
			String sql = "select * from student where email=?";
			return getJdbcTemplate().queryForObject(sql, new Object[] { email }, new RowMapper<Student>() {
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student s = new Student();
					s.setEmail(email);
					s.setPassword(rs.getString(8));
					s.setId(rs.getInt(1));
					s.setAddress(rs.getString(2));
					s.setCourse(rs.getString(3));
					s.setDob(rs.getString(4));
					s.setGender(rs.getString(6));
					s.setName(rs.getString(7));
					s.setRoll(rs.getString(9));
					s.setSemestar(rs.getString(10));
					return s;
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * public Student updateStudent(Student st ) { try { String
	 * sql="update student set dob=?,name=?,gender=?,address=? where id=?"; return
	 * getJdbcTemplate().queryForObject(sql, new Object[] {st.getDob(),st.getName(),
	 * st.getGender(),st.getAddress(),st.getId()},new RowMapper<Student>() {
	 * 
	 * @Override public Student mapRow(ResultSet rs, int rowNum) throws
	 * SQLException{ Student s= new Student(); s.setEmail(rs.getString(5));
	 * s.setPassword(rs.getString(8)); s.setId(rs.getInt(1));
	 * s.setAddress(rs.getString(2)); s.setCourse(rs.getString(3));
	 * s.setDob(rs.getString(4)); s.setGender(rs.getString(6));
	 * s.setName(rs.getString(7)); s.setRoll(rs.getString(9));
	 * s.setSemestar(rs.getString(10)); return s; } }); } catch (Exception e) {
	 * return null; } }
	 */

	public int updateStudent(Student st) {
		int i = 0;
		try {
			String sql = "update student set dob=?,name=?,gender=?,address=? where id=?";
			i = jdbcTemplate.update(sql,
					new Object[] { st.getDob(), st.getName(), st.getGender(), st.getAddress(), st.getId() });
		} catch (Exception e) {

		}
		return i;
	}

	public int updatePassword(String password, String email) {
		int i=0;
		try {
			String sql = "update student set password=? where email=?";
			i = jdbcTemplate.update(sql, new Object[] {password,email });
		} catch (Exception e) {

		}
		return i;
	}

}
