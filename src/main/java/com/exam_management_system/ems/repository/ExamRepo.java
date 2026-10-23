package com.exam_management_system.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam_management_system.ems.model.Exam;

@Repository
public interface ExamRepo extends JpaRepository<Exam,Long> {
	

}
