package com.main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.entity.Cources;
import com.entity.Student;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
       
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Cources.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Scanner sc = new Scanner(System.in);

        Cources c = new Cources();
        System.out.println("Enter the Course Name: ");
        c.setName(sc.next());
        System.out.println("Enter the Duration: ");
        c.setDuration(sc.next());
        System.out.println("Enter the Fee: ");
        c.setFee(sc.nextInt());

        ss.persist(c);
        
        Student s = new Student();
        System.out.println("Enter the Student Name: ");
        s.setName(sc.next());
        System.out.println("Enter the Email: ");
        s.setEmail(sc.next());

        c.getStudents().add(s); 
        s.getCourses().add(c); 
       
        ss.persist(s);

      
        tr.commit();

        ss.close();
      
        System.out.println("Data Saved Successfully!");
    }
}
