package com.github.redfox197.demo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redfox197.demo.database.entity.Autore;
import com.github.redfox197.demo.database.repository.AutoreRepo;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepo autoreRepo;

    public void save(Autore autore){
        autoreRepo.save(autore);
    }

    public void delete(Autore autore){
        autoreRepo.delete(autore);
    }

    public List<Autore> findAll(){
        return autoreRepo.findAll();
    }

    public Autore findById(Long id){
        return autoreRepo.findById(id).orElse(null);
    }
}
