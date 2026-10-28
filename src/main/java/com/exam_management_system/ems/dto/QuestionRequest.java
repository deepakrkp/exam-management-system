package com.exam_management_system.ems.dto;

public record QuestionRequest (
	String questionText,
	String optionA,
	String optionB,
	String optionC,
	String optionD,
	String correctOption,
	Integer marks

) {}
