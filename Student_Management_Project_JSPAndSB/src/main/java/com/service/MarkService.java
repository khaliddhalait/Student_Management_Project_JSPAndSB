package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MarkDaoImpl;
import com.entity.Attendance;
import com.entity.Mark;
import com.repository.MarkRepo;

@Service
public class MarkService {

	@Autowired
	private MarkRepo mrepo;

	@Autowired
	private MarkDaoImpl mdao;

	public Mark addMark(Mark mark) {
		return mrepo.save(mark);
	}

	public List<Mark> getMarkByIdAndSemestar(int sid, String semestar) {
		List<Mark> list = mdao.markBySid(sid, semestar);
		return list;
	}

	public Mark getMarkById(int id) {
		return mrepo.getById(id);
	}

	public boolean deleteMark(int id) {
		mrepo.deleteById(id);
		return mrepo.existsById(id) == false ? true : false;

	}

	public boolean updateMarkById(int id, int mark) {
		int i = mdao.updateMark(id, mark);
		if (i == 1)
			return true;
		else
			return false;

	}
}
