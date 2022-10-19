package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer> {

}
