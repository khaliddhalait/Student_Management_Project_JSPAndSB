package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.entity.Notice;
import com.repository.NoticeRepo;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepo nrepo;

	public List<Notice> getAllNotice() {
		return nrepo.findAll();
	}

	public boolean addNotice(Notice notice) {
		Notice n = nrepo.save(notice);
		return n != null ? true : false;
	}

	public boolean deleteNoticeById(int id) {
		nrepo.deleteById(id);
		if (nrepo.existsById(id))
			return false;
		else
			return true;
	}
}
