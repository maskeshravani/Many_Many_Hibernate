package com.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
        name = "student_course", 
        joinColumns = @JoinColumn(name = "student_id"), 
        inverseJoinColumns = @JoinColumn(name = "course_id") 
    )
    private List<Cources> courses = new ArrayList<>();

    
    public Student() {
    	
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cources> getCourses() {
        return courses;
    }

    public void setCourses(List<Cources> courses) {
        this.courses = courses;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
	}
    
}
