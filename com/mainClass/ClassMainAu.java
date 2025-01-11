package com.mainClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.book.Author;
import com.book.Book;

import java.util.Scanner;

public class ClassMainAu {
	public static void main(String[] args) {
		// Hibernate configuration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Author.class);
		cfg.addAnnotatedClass(Book.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Scanner sc = new Scanner(System.in);

		Book b = new Book();
		
		System.out.println("Enter details for Book 1:");
		System.out.print("Title: ");
		b.setTitle(sc.nextLine());
		
		System.out.print("Genre: ");
		b.setGenre(sc.next());
		ss.persist(b);
		
		System.out.println("Enter details for Book 2:");
		System.out.print("Title: ");
		b.setTitle(sc.next());
		System.out.print("Genre: ");
		b.setGenre(sc.next());
		
		ss.persist(b);
		
		
		Author a = new Author();
		
		System.out.println("Enter details for Author 1:");
		System.out.print("Name: ");
		a.setName(sc.next());
		
		System.out.print("Nationality: ");
		a.setNationality(sc.next());
		ss.persist(a);

		System.out.println("Enter details for Author 2:");
		System.out.print("Name: ");
		a.setName(sc.next());
		System.out.print("Nationality: ");
		a.setNationality(sc.next());
		ss.persist(a);
		
		b.getAuthors().add(a);
		a.getBooks().add(b);
		
	
		
		tr.commit();

		ss.close();
		sf.close();

		System.out.println("Data Saved Successfully!");
	}
}
