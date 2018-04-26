package com.nomi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "indentifier", nullable = false)
    private String indentifier;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<UserCourse> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndentifier() {
        return indentifier;
    }

    public void setIndentifier(String indentifier) {
        this.indentifier = indentifier;
    }

    public Set<UserCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<UserCourse> courses) {
        this.courses = courses;
    }
}
