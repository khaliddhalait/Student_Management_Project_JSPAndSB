package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.Teacher;

@Repository
public class TeacherDaoImpl extends JdbcDaoSupport {

	@Autowired
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Teacher loginValidation(String email) {
		try {
			String sql="select * from teacher where email=?";
			return getJdbcTemplate().queryForObject(sql, new Object[] {email},new RowMapper<Teacher>() {
				@Override
				public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException{
					Teacher t= new Teacher();
					t.setEmail(email);
					t.setPassword(rs.getString(6));
					t.setId(rs.getInt(1));
					t.setDob(rs.getString(2));
					t.setGender(rs.getString(4));
					t.setName(rs.getString(5));
					t.setQualification(rs.getString(7));
					return t;
				}
			});
		} catch (Exception e) {
			return null;
		}
	}
	
	public int updatePassword(String password, String email) {
		int i=0;
		try {
			String sql = "update teacher set password=? where email=?";
			i = jdbcTemplate.update(sql, new Object[] {password,email });
		} catch (Exception e) {

		}
		return i;
	}

	public int updateStudent(Teacher t) {
		int i = 0;
		try {
			String sql = "update teacher set dob=?,name=?,gender=?,qualification=? where id=?";
			i = jdbcTemplate.update(sql,
					new Object[] { t.getDob(), t.getName(), t.getGender(), t.getQualification(), t.getId() });
		} catch (Exception e) {

		}
		return i;
	}
}
