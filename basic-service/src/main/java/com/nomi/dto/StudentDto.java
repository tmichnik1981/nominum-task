package com.nomi.dto;

import java.util.Set;

public class StudentDto {

    private String user;
    private Integer total;
    private Set<StudentCourseDto> courses;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Set<StudentCourseDto> getCourses() {
        return courses;
    }

    public void setCourses(Set<StudentCourseDto> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDto{");
        sb.append("user='").append(user).append('\'');
        sb.append(", total=").append(total);
        sb.append(", courses=").append(courses);
        sb.append('}');
        return sb.toString();
    }
}
