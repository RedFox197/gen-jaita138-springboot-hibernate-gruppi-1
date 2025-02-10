package com.github.redfox197.demo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.redfox197.demo.database.entity.Libro;
import com.github.redfox197.demo.database.repository.LibroRepo;

@Service
public class LibroService {

    @Autowired
    LibroRepo libroRepo;

    public List<Libro> findall(){
        return libroRepo.findAll();
    }

    public void save(Libro libro){
        libroRepo.save(libro);
    }

    public void delete(Libro libro){
        libroRepo.delete(libro);
    }

    public Libro findbyid(Long id){
        return libroRepo.findById(id).orElse(null);
    }

}