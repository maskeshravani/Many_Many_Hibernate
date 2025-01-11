package com.MainLibrary;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.library.Book1;
import com.library.Library;

public class MainLibrary {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Library.class);
		cfg.addAnnotatedClass(Book1.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Scanner sc = new Scanner(System.in);

		Library library = new Library();
		System.out.println("ID:");
		library.setId(sc.nextInt());
		System.out.print("Enter Library Name: ");
		library.setName(sc.next());
		ss.persist(library);

		Book1 b1 = new Book1();
		System.out.println("ID:");
		b1.setId(sc.nextInt());
		System.out.print("Enter Book 1 Title: ");
		b1.setTitle(sc.next());
		System.out.print("Enter Book 1 Author: ");
		b1.setAuthor(sc.next());
		b1.setLibrary(library);
		ss.persist(b1);

		Book1 b2 = new Book1();
		System.out.println("ID:");
		b2.setId(sc.nextInt());
		System.out.print("Enter Book 2 Title: ");
		b2.setTitle(sc.next());
		System.out.print("Enter Book 2 Author: ");
		b2.setAuthor(sc.next());
		b2.setLibrary(library);

		ss.persist(b2);

		tr.commit();

		ss.close();
		sf.close();

		System.out.println("Data saved successfully!");
	}
}
