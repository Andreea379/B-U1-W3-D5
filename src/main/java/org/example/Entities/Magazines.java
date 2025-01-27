package org.example.Entities;

import org.example.Enumeration.Periodicity;

import javax.persistence.*;

@Entity
@Table (name="magazines")
public class Magazines extends Catalog{
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazines(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicity periodicity) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicity = periodicity;
    }

    public Magazines(){

    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazines{" +
                "periodicity=" + periodicity +
                '}';
    }
}
