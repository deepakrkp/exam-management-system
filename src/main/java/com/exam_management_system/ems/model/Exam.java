package com.exam_management_system.ems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exam{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Integer durationMinutes;
	private Integer totalMarks;
	private boolean active;
	
	
	public Exam(Long id, String title, String description, Integer durationMinutes, Integer totalMarks,boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.durationMinutes = durationMinutes;
		this.totalMarks = totalMarks;
		this.active = active;
	}
	
	

	public Exam() {
		super();
	}



	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	
	

}
