package com.nomi.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

	private Integer user;
	private Integer total;
	private List<CourseDto> courses = new ArrayList<>();
	
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<CourseDto> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseDto> courses) {
		this.courses = courses;
	}
	
	
	
}
