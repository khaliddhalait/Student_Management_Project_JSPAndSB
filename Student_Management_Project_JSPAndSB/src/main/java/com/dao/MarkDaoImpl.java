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
import com.entity.Mark;
import com.entity.Student;

@Repository
public class MarkDaoImpl extends JdbcDaoSupport {
	@Autowired
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Mark> markBySid(int sid, String semestar) {
		try {
			String sql = "select * from mark where sid=? and semestar=? order by subject";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { sid, semestar });
			List<Mark> list = new ArrayList<Mark>();
			for (Map row : rows) {
				Mark m = new Mark();
				m.setId((int) row.get("id"));
				m.setCourse(row.get("course").toString());
				m.setMark((int) row.get("mark"));
				m.setRoll(row.get("roll").toString());
				m.setSid(sid);
				m.setSname(row.get("sname").toString());
				m.setSubject(row.get("subject").toString());
				m.setSemestar(semestar);
				list.add(m);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int updateMark(int id, int mark) {
		int i = 0;
		try {
			String sql = "update mark set mark=? where id=?";
			i = jdbcTemplate.update(sql, new Object[] { mark, id });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deleteByStudentId(int sid) {
		int i = 0;
		try {
			String sql = "delete from mark where sid=?";
			i = jdbcTemplate.update(sql, new Object[] {sid });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
