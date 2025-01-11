package com.library;

import jakarta.persistence.*;

@Entity
public class Book1 {

    @Id
  
    private int id;

    private String title;
    private String author;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

	public Book1() {
		
	}

	public Book1(int id, String title, String author, Library library) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.library = library;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Book1 [id=" + id + ", title=" + title + ", author=" + author + ", library=" + library + "]";
	}

    
    
}
