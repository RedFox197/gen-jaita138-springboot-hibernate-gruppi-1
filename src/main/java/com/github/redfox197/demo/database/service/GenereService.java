package com.github.redfox197.demo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redfox197.demo.database.entity.Genere;
import com.github.redfox197.demo.database.repository.GenereRepo;

// TODO fare un findall che carica anche i libri
@Service
public class GenereService {

    @Autowired
    private GenereRepo genereRepo;

    public void save(Genere genere) {
        genereRepo.save(genere);
    }

    public void delete(Genere genere) {
        genereRepo.delete(genere);
    }

    public Genere findById(long id) {
        return genereRepo.findById(id).orElse(null);
    }

    public List<Genere> findAll() {
        return genereRepo.findAll();
    }
}
