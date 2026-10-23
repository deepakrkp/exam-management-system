package com.exam_management_system.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam_management_system.ems.dto.ExamRequest;
import com.exam_management_system.ems.dto.ExamResponse;
import com.exam_management_system.ems.exception.ResourceNotFoundException;
import com.exam_management_system.ems.model.Exam;
import com.exam_management_system.ems.repository.ExamRepo;

@Service
public class ExamService {
	
	private final ExamRepo examRepo;
	
	
	public ExamService(ExamRepo examRepo) {
		this.examRepo= examRepo;
	}

	private ExamResponse mapToResponse(Exam exam) {
	    return new ExamResponse(
	            exam.getId(),
	            exam.getTitle(),
	            exam.getDescription(),
	            exam.getDurationMinutes(),
	            exam.getTotalMarks(),
	            exam.getActive()
	    );
	}
	public ExamResponse createExamDetails(ExamRequest request) {
		
		//Request DTO -> Entity
        Exam changesExam = new Exam();
        changesExam.setTitle(request.getTitle());
        changesExam.setDescription(request.getDescription());
        changesExam.setDurationMinutes(request.getDurationMinutes());
        changesExam.setTotalMarks(request.getTotalMarks());

        // Save entity to database
        Exam savedExam = examRepo.save(changesExam);

        // Saved entity -> Response DTO
        return mapToResponse(savedExam);
	}

	public List<ExamResponse> getAllExams() {
	    return examRepo.findAll()
	    			   .stream()
	    			   .map(exam->mapToResponse(exam))
	    			   .toList();

	}

	public ExamResponse getExamById(Long id) {
		
		Exam exam = examRepo.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + id));
		
		
		ExamResponse response = mapToResponse(exam);
		return response;
		
	}

	public ExamResponse updateExamById(ExamRequest request, Long id) {
		
		Exam dbExam = examRepo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + id));
		dbExam.setTitle(request.getTitle());
		dbExam.setDescription(request.getDescription());
		dbExam.setDurationMinutes(request.getDurationMinutes());
		dbExam.setTotalMarks(request.getTotalMarks());

	
		Exam savedExam = examRepo.save(dbExam);

        // Saved entity -> Response DTO
        return mapToResponse(savedExam);
	}

	public void deleteExamById(Long id) {
		
		Exam dbExam = examRepo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + id));
		examRepo.delete(dbExam);
		
	}
	
}
