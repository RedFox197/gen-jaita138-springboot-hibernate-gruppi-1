package com.github.redfox197.demo.database.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redfox197.demo.database.entity.Genere;
import com.github.redfox197.demo.database.repository.GenereRepo;

import jakarta.transaction.Transactional;

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

    public Genere findById(Long id) {
        return genereRepo.findById(id).orElse(null);
    }

    public List<Genere> findAll() {
        return genereRepo.findAll();
    }

    @Transactional
    public List<Genere> findAllWithBook() {
        List<Genere> generi = genereRepo.findAll();
        for (Genere genere : generi) {
            Hibernate.initialize(genere.getLibri());
        }
        return generi;
    }
}
