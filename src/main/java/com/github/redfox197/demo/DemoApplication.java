package com.github.redfox197.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.redfox197.demo.cli.CliManager;
import com.github.redfox197.demo.database.service.AutoreService;
import com.github.redfox197.demo.database.service.GenereService;
import com.github.redfox197.demo.database.service.LibroService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private LibroService libroService;
	@Autowired
	private GenereService genereService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(libroService, autoreService, genereService);
	}

}
