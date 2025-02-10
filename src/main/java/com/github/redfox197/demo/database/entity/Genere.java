package com.github.redfox197.demo.database.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity // nome
public class Genere {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String nome;
    @ManyToMany
    private List<Libro> libri;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    public long getId() {
        return id;
    }

    
    public Genere(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genere [nome=" + nome + ", libri=" + libri + "]";
    }
    
}
