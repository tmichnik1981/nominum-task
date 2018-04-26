package com.nomi.model;

import com.nomi.model.converters.GradeConverter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users_courses")
public class UserCourse implements Serializable {

    @EmbeddedId
    private UserCoursePK id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Basic
    @Convert(converter = GradeConverter.class)
    @Column(name = "grade")
    private Grade grade;

    public UserCoursePK getId() {
        return id;
    }

    public void setId(UserCoursePK id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public UserCourse(UserCoursePK id) {
        this.id = id;
    }

    public UserCourse() {
    }
}
