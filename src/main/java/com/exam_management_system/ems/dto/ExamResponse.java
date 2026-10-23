package com.exam_management_system.ems.dto;

public record ExamResponse (
		Long id,
		String title,
		String description,
		Integer durationMinutes,
		Integer totalMarks,
		boolean active
		)
{}