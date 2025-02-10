package com.github.redfox197.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.redfox197.demo.database.entity.Genere;

@Repository
public interface GenereRepo extends JpaRepository<Genere, Long>{

}
