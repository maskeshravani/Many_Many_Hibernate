package com.university;

import jakarta.persistence.*;

@Entity
public class StudeEx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University uni;

    public StudeEx() {
    }

    public StudeEx(String name, String course) {
        this.name = name;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public University getUniversity() {
        return uni;
    }

    public void setUniversity(University university) {
        this.uni = university;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
    }
}
