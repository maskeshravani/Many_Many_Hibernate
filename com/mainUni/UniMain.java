package com.mainUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.university.StudeEx;
import com.university.University;

import java.util.Scanner;

public class UniMain {

    public static void main(String[] args) {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(University.class);
        cfg.addAnnotatedClass(StudeEx.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter University Name: ");
        String universityName = sc.nextLine();
        University university = new University(universityName);

        System.out.print("How many students to add? ");
        int numOfStudents = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= numOfStudents; i++) {
        	StudeEx s = new StudeEx();
            System.out.println("Enter details for Student " + i);
          
            System.out.print("Enter Student Name: ");
            s.setName(sc.next());

            System.out.print("Enter Student Course: ");
            s.setCourse(sc.next());

  
            university.addStudent(s);
            ss.persist(s);
        }

        ss.persist(university);

        tr.commit();
        ss.close();
       

        sc.close();

        System.out.println("Data saved successfully!");
    }
}
