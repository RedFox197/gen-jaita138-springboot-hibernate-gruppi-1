package com.github.redfox197.demo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redfox197.demo.database.entity.Libro;
import com.github.redfox197.demo.database.repository.LibroRepo;

// TODO fare un metodo findAll che carica anche l'autore, ma non i generi
// TODO fare un metodo findAll che carica sia autore che genere
// TODO fare un metodo per avere tutti i libri che iniziano con la p (usando la query method della repo)
// TODO come coso sopra, da fare anche per libri prodotti fra 2000 e 2020
// TODO come coso sopra, da fare metodo per libro con isbn 978-3-16-148410-0
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

}