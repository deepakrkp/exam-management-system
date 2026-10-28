package com.exam_management_system.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exam_management_system.ems.dto.QuestionRequest;
import com.exam_management_system.ems.dto.QuestionResponse;
import com.exam_management_system.ems.service.QuestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	
	@PostMapping("/questions/{id}")
	public ResponseEntity<QuestionResponse> addQuestions(@RequestBody QuestionRequest request,@PathVariable Long id) {	
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(questionService.addQuestions(request, id));	
	}
	
	@GetMapping("/question/{examId}")
	public ResponseEntity<List<QuestionResponse>> getQuestionsByExamId(@Valid @PathVariable Long examId){
		
		List<QuestionResponse> questionsByExamId = questionService.getQuestionsByExamId(examId);
		return ResponseEntity.status(HttpStatus.OK)
							 .body(questionsByExamId);
		
	}
	
	
}
