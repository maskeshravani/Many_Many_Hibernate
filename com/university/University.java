package com.university;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "uni")
    private List<StudeEx> students = new ArrayList<>();
    public University() {
    }

    public University(String name) {
        this.name = name;
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

    public List<StudeEx> getStudents() {
        return students;
    }

    public void addStudent(StudeEx std) {
        std.setUniversity(this); // Establish relationship
        students.add(std);
    }

    @Override
    public String toString() {
        return "University [id=" + id + ", name=" + name + "]";
    }
}
