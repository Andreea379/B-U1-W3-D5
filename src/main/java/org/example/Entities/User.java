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
    private String nome;
    @Column(nullable = false)
    private String cognome;
    private LocalDate dataDiNascita;
    @Column(nullable=  false, unique = true)
    private long numeroDiTessera;
    public Utente() {

    }

    public User(String nome, String cognome, LocalDate dataDiNascita, long numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public long getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(long numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }
}
