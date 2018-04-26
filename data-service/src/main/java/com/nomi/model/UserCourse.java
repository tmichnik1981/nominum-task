package com.nomi.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "users_courses")
@AssociationOverrides( {
    @AssociationOverride(name = "pk.user",
        joinColumns = @JoinColumn(name = "user_id")),
    @AssociationOverride(name = "pk.course",
        joinColumns = @JoinColumn(name = "course_id"))})
public class UserCourse implements Serializable {

    @EmbeddedId
    private UserCoursePK id = new UserCoursePK();

    @Transient
    private User user;

    @Transient
    private Course course;

    public UserCourse(UserCoursePK id) {
        this.id = id;
    }

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


}
