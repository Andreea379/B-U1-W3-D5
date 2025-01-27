package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name="users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private LocalDate bithdayDate;
    @Column(nullable=  false, unique = true)
    private long number;
    public user() {
    }

    public User(String name, String surname, LocalDate bithdayDate, long number) {
        this.name = name;
        this.surname = surname;
        this.bithdayDate = bithdayDate;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getCognome() {
        return surname;
    }

    public void setCognome(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataDiNascita() {
        return bithdayDate;
    }

    public void setDataDiNascita(LocalDate bithdayDate) {
        this.bithdayDate = bithdayDate;
    }

    public long getNumeroDiTessera() {
        return number;
    }

    public void setNumeroDiTessera(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bithdayDate=" + bithdayDate +
                ", number=" + number +
                '}';
    }
}
