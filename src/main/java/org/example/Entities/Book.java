package org.example.Entities;

import javax.persistence.*;
@Entity
@Table(name="books")
public class Book extends Catalog {
    @Column(nullable = false)
    private String author;
    private String gener;
    public Book() {
    }

    public Book(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String author, String gener) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.author = author;
        this.gener = gener;
    }

    public String getAutore() {
        return author;
    }

    public void setAutore(String author) {
        this.author = author;
    }

    public String getGenere() {
        return gener;
    }

    public void setGenere(String gener) {
        this.gener = gener;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", gener='" + gener + '\'' +
                '}';
    }
}
