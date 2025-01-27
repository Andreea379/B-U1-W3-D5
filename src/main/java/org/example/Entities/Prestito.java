package org.example.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "utente id", nullable = false)

    private User user;

    @ManyToMany
    @JoinTable(
            name="prestiti catalog",
            joinColumns  =  @JoinColumn(name= "prestito_id"),
            inverseJoinColumns= @JoinColumn(name = "catalog_id")
    )
    private List<Catalog> elementiPrestati = new ArrayList<>(); //relazione

    @Column(nullable = false)
    private LocalDate dataľnizioPrestito;
    private LocalDate datallestituzionePrevista;
    private LocalDate datallestituzioneEffettiva;

    public Prestito(User user, List<Catalog> elementiPrestati, LocalDate dataľnizioPrestito, LocalDate datallestituzionePrevista, LocalDate datallestituzioneEffettiva) {
        this.user = user;
        this.elementiPrestati = elementiPrestati;
        this.dataľnizioPrestito = dataľnizioPrestito.plusDays(30);
        this.datallestituzionePrevista = datallestituzionePrevista;
        this.datallestituzioneEffettiva = datallestituzioneEffettiva;
    }
    public Prestito(User userById, List<Catalog> prestitiUser4, LocalDate localDate){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Catalog> getElementiPrestati() {
        return elementiPrestati;
    }

    public void setElementiPrestati(List<Catalog> elementiPrestati) {
        this.elementiPrestati = elementiPrestati;
    }

    public LocalDate getDataľnizioPrestito() {
        return dataľnizioPrestito;
    }

    public void setDataľnizioPrestito(LocalDate dataľnizioPrestito) {
        this.dataľnizioPrestito = dataľnizioPrestito;
    }

    public LocalDate getDatallestituzionePrevista() {
        return datallestituzionePrevista;
    }

    public void setDatallestituzionePrevista(LocalDate datallestituzionePrevista) {
        this.datallestituzionePrevista = datallestituzionePrevista;
    }

    public LocalDate getDatallestituzioneEffettiva() {
        return datallestituzioneEffettiva;
    }

    public void setDatallestituzioneEffettiva(LocalDate datallestituzioneEffettiva) {
        this.datallestituzioneEffettiva = datallestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", user=" + user +
                ", elementiPrestati=" + elementiPrestati +
                ", dataľnizioPrestito=" + dataľnizioPrestito +
                ", datallestituzionePrevista=" + datallestituzionePrevista +
                ", datallestituzioneEffettiva=" + datallestituzioneEffettiva +
                '}';
    }
}
