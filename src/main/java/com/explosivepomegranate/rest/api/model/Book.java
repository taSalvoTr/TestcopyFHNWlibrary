package com.explosivepomegranate.rest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@SecondaryTable(name = "borrowed")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private String ISBN;
    private String title;
    private String description;
    private int year;
    @Column(name = "book_status", table = "borrowed")
    private boolean currentlyBorrowed; //TODO the sql doesn't have that attribute

    //Connects the Book table with the Category table
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) @JsonIgnore
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;

    //Connects the Book table with the Author table
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) @JsonIgnore
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"))
    private Set<Author> authors;

    //Connects the book with borrowed
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy(value = "init_end_date")
    private List<Borrowed> borrowed;


    //Getters and Setters
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int id) {
        this.book_id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isCurrentlyBorrowed() {
        return currentlyBorrowed;
    }

    public void setCurrentlyBorrowed(boolean currentlyBorrowed) {
        this.currentlyBorrowed = getBorrowed().get(this.getBook_id()).isBookStatus();
    }

    public List<Borrowed> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(List<Borrowed> borrowed) {
        this.borrowed = borrowed;
    }
}
