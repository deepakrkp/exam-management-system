package com.exam_management_system.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam_management_system.ems.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long>{

	List<Question> findByExamId(Long examId);

}
