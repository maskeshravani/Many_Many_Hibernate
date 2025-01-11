package com.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String duration;
    private int fee;

    @ManyToMany(mappedBy = "courses") 
    private Set<Student> students = new HashSet<>();

    public Cources() {
    	
    }

    public Cources(String name, String duration, int fee) {
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

	@Override
	public String toString() {
		return "Cources [id=" + id + ", name=" + name + ", duration=" + duration + ", fee=" + fee + ", students="
				+ students + "]";
	}
    
    
}
