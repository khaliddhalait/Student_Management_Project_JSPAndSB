package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Notice;

public interface NoticeRepo extends JpaRepository<Notice, Integer> {

}
