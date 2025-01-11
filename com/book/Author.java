package com.book;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;

    @ManyToMany
    @JoinTable(
        name = "author_book", // Join table name
        joinColumns = @JoinColumn(name = "author_id"), // Foreign key for Author
        inverseJoinColumns = @JoinColumn(name = "book_id") // Foreign key for Book
    )
    private Set<Book> books = new HashSet<>();

    // Constructors
    public Author() {
    	
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", nationality=" + nationality + ", books=" + books + "]";
	}
    
}
