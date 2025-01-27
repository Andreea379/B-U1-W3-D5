package org.example.Entities;

import org.example.Enumeration.Periodicity;

import javax.persistence.*;

@Entity
@Table (name="magazines")
public class Magazines extends Catalog{
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazines(String isbn, String title, int pubblicationYear, int pages, Periodicity periodicity) {
        super(isbn, title, pubblicationYear, pages);
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
