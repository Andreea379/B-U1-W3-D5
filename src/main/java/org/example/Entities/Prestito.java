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
    private List<Catalog> elementsPrestati = new ArrayList<>(); //relazione

    @Column(nullable = false)
    private LocalDate dataľnizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(User user, List<Catalog> elementsPrestati, LocalDate dataľnizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.user = user;
        this.elementsPrestati = elementsPrestati;
        this.dataľnizioPrestito = dataľnizioPrestito.plusDays(30);
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
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
        return elementsPrestati;
    }

    public void setElementiPrestati(List<Catalog> elementsPrestati) {
        this.elementsPrestati = elementsPrestati;
    }

    public LocalDate getDataľnizioPrestito() {
        return dataľnizioPrestito;
    }

    public void setDataľnizioPrestito(LocalDate dataľnizioPrestito) {
        this.dataľnizioPrestito = dataľnizioPrestito;
    }

    public LocalDate getDatallestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDatallestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDatallestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDatallestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", user=" + user +
                ", elementsPrestati=" + elementsPrestati +
                ", dataľnizioPrestito=" + dataľnizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
