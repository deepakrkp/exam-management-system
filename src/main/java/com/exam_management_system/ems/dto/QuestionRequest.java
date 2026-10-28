package com.exam_management_system.ems.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record QuestionRequest (
	
	@NotBlank(message="questionText not empty")
	String questionText,
	
	@NotBlank(message="optionA not empty")
	String optionA,
	
	@NotBlank(message="optionB not empty")
	String optionB,
	
	@NotBlank(message="optionC not empty")
	String optionC,
	
	@NotBlank(message="optionD not empty")
	String optionD,
	
	@NotBlank(message="correctOption not empty")
	String correctOption,
	
	@NotNull(message="mark cannot be null")
	@Min(value=1,message="	Marks must be at least 1")
	Integer marks

) {}
