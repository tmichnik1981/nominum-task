package com.nomi.dto;

import com.nomi.model.Grade;

public class CourseDto {	
	private String name;
	private Grade grade;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
