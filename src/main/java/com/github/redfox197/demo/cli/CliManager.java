package com.github.redfox197.demo.cli;

import com.github.redfox197.demo.database.service.AutoreService;
import com.github.redfox197.demo.database.service.GenereService;
import com.github.redfox197.demo.database.service.LibroService;

public class CliManager {
    private LibroService libroService;
    private AutoreService autoreService;
    private GenereService genereService;

    public CliManager(LibroService libroService, AutoreService autoreService, GenereService genereService) {
        this.libroService = libroService;
        this.autoreService = autoreService;
        this.genereService = genereService;

        printOptions();
    }

    public void printOptions() {
        System.out.println("Opzioni...");
    }
}
