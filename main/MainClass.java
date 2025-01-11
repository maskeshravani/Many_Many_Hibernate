package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Scanner sc = new Scanner(System.in);
		
		Department d = new Department();
		System.out.println("Enter the Id: ");
		d.setD_id(sc.nextInt());
		
		System.out.println("Enter the deparment name: ");
		d.setD_name(sc.next());
		
		d.setEmp(null);
		
		Employee e = new Employee();
		System.out.println("Enter the Name:  ");
		e.setE_name(sc.next());
		
		System.out.println("Enter the Name:  ");
		e.setE_name(sc.next());
		
		System.out.println("Enter the Name:  ");
		e.setE_name(sc.next());
		
		e.setDept(null);
		
		
		tr.commit();

		ss.close();
		sf.close();

	}

}
