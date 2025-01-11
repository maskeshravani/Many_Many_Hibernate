package com.library;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {

    @Id
   
    private int id;
    private String Name;
    
    @OneToMany(mappedBy = "library")
    private List<Book1> books = new ArrayList<>(); 

	public Library() {
		
	}



	public Library(int id, String name, List<Book1> books) {
		super();
		this.id = id;
		Name = name;
		this.books = books;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public List<Book1> getBooks() {
		return books;
	}



	public void setBooks(List<Book1> books) {
		this.books = books;
	}

	public void addBook(Book1 book) {
        books.add(book);
        book.setLibrary(this);  // Set the reverse relationship
    }

	@Override
	public String toString() {
		return "Library [id=" + id + ", Name=" + Name + ", books=" + books + "]";
	}


    
    
}
