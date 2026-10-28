package com.exam_management_system.ems.dto;

public record QuestionResponse(
		Long id,
		String questionText,
		String optionA,
		String optionB,
		String optionC,
		String optionD,
		Integer marks
) {

}
