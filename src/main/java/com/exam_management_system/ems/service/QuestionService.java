package com.exam_management_system.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exam_management_system.ems.dto.QuestionRequest;
import com.exam_management_system.ems.dto.QuestionResponse;
import com.exam_management_system.ems.exception.ResourceNotFoundException;
import com.exam_management_system.ems.model.Exam;
import com.exam_management_system.ems.model.Question;
import com.exam_management_system.ems.repository.ExamRepo;
import com.exam_management_system.ems.repository.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private ExamRepo examRepo;

	private QuestionResponse mapToResponse(Question question) {
	    return new QuestionResponse(
	            question.getId(),
	            question.getQuestionText(),
	            question.getOptionA(),
	            question.getOptionB(),
	            question.getOptionC(),
	            question.getOptionD(),
	            question.getMarks()  
	    );
	}
	public QuestionResponse addQuestions(QuestionRequest request, Long id) {
		
		Exam exam = examRepo.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id " + id)); 
		Question question = new Question();
		question.setExam(exam);
		question.setCorrectOption(request.correctOption());
		question.setMarks(request.marks());
		question.setOptionA(request.optionA());
		question.setOptionB(request.optionB());
		question.setOptionC(request.optionC());
		question.setOptionD(request.optionD());
		question.setQuestionText(request.questionText());
		
		questionRepo.save(question);

		QuestionResponse response = mapToResponse(question);
		return response;
	}

}
