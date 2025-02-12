package com.github.redfox197.demo.database.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String titolo;

    int annoPublicazione;

    @Column(length = 64)
    private String IBSN;

    @ManyToOne
    private Autore autore;

    @ManyToMany(mappedBy = "libri")
    private List<Genere> generi = new ArrayList<>();

    public List<Genere> getGeneri() {
        return generi;
    }

    public void setGeneri(List<Genere> generi) {
        this.generi = generi;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public String getIBSN() {
        return IBSN;
    }

    public void setIBSN(String iBSN) {
        IBSN = iBSN;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titolo=" + titolo + ", annoPublicazione=" + annoPublicazione + ", IBSN=" + IBSN
                + "]";
    }

}
