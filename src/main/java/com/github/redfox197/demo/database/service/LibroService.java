package com.github.redfox197.demo.database.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redfox197.demo.database.entity.Libro;
import com.github.redfox197.demo.database.repository.LibroRepo;

import jakarta.transaction.Transactional;

@Service
public class LibroService {

    @Autowired
    LibroRepo libroRepo;

    public List<Libro> findAll() {
        return libroRepo.findAll();
    }

    public void save(Libro libro) {
        libroRepo.save(libro);
    }

    public void delete(Libro libro) {
        libroRepo.delete(libro);
    }

    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    @Transactional
    public List<Libro> findConAutore() {
        List<Libro> libri = libroRepo.findAll();
        for (Libro elemento : libri) {
            Hibernate.initialize(elemento.getAutore());

        }
        return libri;
    }

    @Transactional
    public List<Libro> findAllWithGenereAndAutore() {
        List<Libro> libri = libroRepo.findAll();
        for (Libro elemento : libri) {
            Hibernate.initialize(elemento.getGeneri());
            Hibernate.initialize(elemento.getAutore());
        }
        return libri;
    }

    public List<Libro> findByTitoloStartingWithP() {
        return libroRepo.findByTitoloStartingWithIgnoreCase("P");
    }

    public List<Libro> findByAnnoBetween() {
        return libroRepo.findByAnnoPublicazioneBetween(2000, 2020);
    }

    public List<Libro> findByIBSN() {
        return libroRepo.findByIBSNIgnoreCase("978-3-16-148410-0");
    }

}