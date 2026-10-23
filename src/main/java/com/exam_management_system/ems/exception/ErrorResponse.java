package com.exam_management_system.ems.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
	    int status,
	    String message,
	    LocalDateTime timestamp
	) 
{
	}