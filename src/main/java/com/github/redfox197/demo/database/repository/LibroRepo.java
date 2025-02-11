package com.github.redfox197.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.redfox197.demo.database.entity.Libro;

// TODO fare una query method per avere tutti i libri che iniziano con una determinata lettera
// TODO fare una query method per avere tutti i libri prodotti in un determinato range di anno pubblicazione
// TODO fare una query method per avere un libro in base ad un ISBN
@Repository
public interface LibroRepo extends JpaRepository<Libro, Long>{

}
