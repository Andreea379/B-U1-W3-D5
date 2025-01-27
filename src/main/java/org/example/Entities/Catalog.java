package org.example.Entities;

import javax.persistence.*;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_element", discriminatorType = DiscriminatorType.STRING)

public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    private int pubblicationYear;
    private int pages;
    public Catalog() {
    }
public Catalog(String isbn, String title, int pubblicationYear, int pages){
        this.isbn= isbn;
        this.title = title;
        this.pubblicationYear= pubblicationYear;
        this.pages= pages;
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return title;
    }

    public void setTitolo(String title) {
        this.title = title;
    }

    public int getAnnoPubblicazione() {
        return pubblicationYear;
    }

    public void setAnnoPubblicazione(int pubblicationYear) {
        this.pubblicationYear = pubblicationYear;
    }

    public int getNumeroPagine() {
        return pages;
    }

    public void setNumeroPagine(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", pubblicationYear=" + pubblicationYear +
                ", pages=" + pages +
                '}';
    }
}




