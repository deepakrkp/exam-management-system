package com.exam_management_system.ems.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam_management_system.ems.dto.ExamRequest;
import com.exam_management_system.ems.dto.ExamResponse;
import com.exam_management_system.ems.model.Exam;
import com.exam_management_system.ems.service.ExamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ExamController {
	
	private final ExamService examService;
	
	public ExamController(ExamService examService) {
		this.examService = examService;
	}
	
	@PostMapping("/exam")
	public ResponseEntity<ExamResponse> createExamDetails(@Valid @RequestBody ExamRequest request){
		
		ExamResponse saveExamResponse = examService.createExamDetails(request);
		return ResponseEntity.status(HttpStatus.CREATED)
							.body(saveExamResponse);		
		
	}
	
	@GetMapping("/exams")
	public ResponseEntity<List<ExamResponse>> getAllExams(){
		
		List<ExamResponse> response = examService.getAllExams();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/exam/{id}")
	public ResponseEntity<ExamResponse> getExamById(@PathVariable Long id){
		
		
		ExamResponse examResponse = examService.getExamById(id);
		
		return ResponseEntity.ok(examResponse);
		
	}
	
	@PutMapping("/exam/{id}")
	public ResponseEntity<ExamResponse> updateExamById(@Valid @RequestBody ExamRequest request,@PathVariable Long id){
		ExamResponse updateExamResponse = examService.updateExamById(request,id);
		return ResponseEntity.ok(updateExamResponse);
	}
	
	@DeleteMapping("/exam/{id}")
	public ResponseEntity<Void> deleteExamById(@PathVariable Long id){
		
		 examService.deleteExamById(id);
		 return ResponseEntity.noContent().build();
	}
		
	}
