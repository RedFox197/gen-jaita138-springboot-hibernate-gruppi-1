package com.github.redfox197.demo.cli;

import java.util.Scanner;

import com.github.redfox197.demo.database.entity.Autore;
import com.github.redfox197.demo.database.entity.Genere;
import com.github.redfox197.demo.database.entity.Libro;
import com.github.redfox197.demo.database.service.AutoreService;
import com.github.redfox197.demo.database.service.GenereService;
import com.github.redfox197.demo.database.service.LibroService;

public class CliManager {
    private LibroService libroService;
    private AutoreService autoreService;
    private GenereService genereService;
    private Scanner scanner;

    public CliManager(LibroService libroService, AutoreService autoreService, GenereService genereService) {
        this.libroService = libroService;
        this.autoreService = autoreService;
        this.genereService = genereService;

        scanner = new Scanner(System.in);
        printOptions();
    }

    public void printOptions() {
        System.out.println("Opzioni Disponibili:");
        System.out.println("1. Leggi tutti i libri");
        System.out.println("2. Leggi tutti i libri con autore");
        System.out.println("3. Leggi tutti i libri con autore e generi");
        System.out.println("4. Leggi tutti gli autori");
        System.out.println("5. Leggi tutti i generi");
        System.out.println("6. Aggiungi nuovo autore");
        System.out.println("7. Aggiungi nuovo genere");
        System.out.println("8. Aggiungi nuovo libro");
        System.out.println("9. Cerca libri con titolo che inizia per 'p'");
        System.out.println("10. Cerca libri tra il 2000 e il 2020");
        System.out.println("11. Cerca libro con ISBN specifico");
        System.out.println("12. Leggi autori con relativi libri");
        System.out.println("13. Leggi generi con relativi libri");
        System.out.println("14. Termina");
        System.out.println();

        System.out.print("Scelta: ");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 1 -> leggiTuttiLibri();
            case 2 -> leggiTuttiLibriConAutore();
            case 3 -> leggiTuttiLibriConAutoreEGeneri();
            case 4 -> leggiTuttiAutori();
            case 5 -> leggiTuttiGeneri();
            case 6 -> aggiungiAutore();
            case 7 -> aggiungiGenere();
            case 8 -> aggiungiLibro();
            case 9 -> cercaLibriTitolo();
            case 10 -> cercaLibriAnno();
            case 11 -> cercaLibriISBN();
            case 12 -> leggiAutoriConLibri();
            case 13 -> leggiGeneriConLibri();
            case 14 -> {
                return;
            }
            default -> System.out.println("Opzione scelta non valida.");
        }

        printOptions();
    }

    public void leggiTuttiLibri() {
        System.out.println("Libri: ");
        System.out.println(libroService.findAll());
        System.out.println();
    }

    public void leggiTuttiLibriConAutore() {
        System.out.println("I libri con gli autori: ");
        for (Libro conAutore : libroService.findConAutore()) {
            System.out.println(conAutore);
            System.out.println(conAutore.getAutore());
        }
    }

    public void leggiTuttiLibriConAutoreEGeneri() {
        System.out.println("I libri con autori e generi: ");
        for (Libro conAutoreEGenere : libroService.findAllWithGenereAndAutore()) {
            System.out.println(conAutoreEGenere);
            System.out.println(conAutoreEGenere.getAutore());
            System.out.println(conAutoreEGenere.getGeneri());
        }
    }

    public void leggiTuttiAutori() {
        System.out.println("Autori: ");
        System.out.println(autoreService.findAll());
        System.out.println();
    }

    public void leggiTuttiGeneri() {
        System.out.println("Generi: ");
        System.out.println(genereService.findAll());
        System.out.println();
    }

    public void aggiungiAutore() {
        System.out.println("Aggiungi Autore");
        Autore autore = new Autore();

        System.out.print("Nome: ");
        autore.setNome(scanner.nextLine());
        System.out.print("Cognome: ");
        autore.setCognome(scanner.nextLine());
        System.out.print("Nazionalità (es IT): ");
        autore.setNazionalita(scanner.nextLine());

        autoreService.save(autore);
        System.out.println("Autore Salvato!");
    }

    public void aggiungiGenere() {
        System.out.println("Aggiungi Genere");
        Genere genere = new Genere();

        System.out.print("Nome: ");
        genere.setNome(scanner.nextLine());

        genereService.save(genere);
        System.out.println("Genere Salvato!");
    }

    public void aggiungiLibro() {
        System.out.println("Aggiungi Libro");
        Libro libro = new Libro();

        System.out.print("Titolo: ");
        libro.setTitolo(scanner.nextLine());
        System.out.println("Anno di pubblicazione: ");
        libro.setAnnoPublicazione(scanner.nextInt());
        scanner.nextLine();
        System.out.print("ISBN: ");
        libro.setIBSN(scanner.nextLine());

        System.out.println("Imposta autore per il libro");
        leggiTuttiAutori();

        System.out.print("Autore id: ");
        Autore autore = autoreService.findById(scanner.nextLong());
        scanner.nextLine();
        if (autore == null) {
            System.out.println("Autore non trovato!");
            return;
        }
        libro.setAutore(autore);

        while (true) {
            System.out.println("Imposta genere per il libro");
            leggiTuttiGeneri();

            System.out.println("Vuoi aggiungere un genere? (y/n)");
            if (!scanner.nextLine().equalsIgnoreCase("y"))
                break;

            System.out.print("Genere id: ");
            Genere genere = genereService.findById(scanner.nextLong());
            scanner.nextLine();
            if (genere == null) {
                System.out.println("Genere non trovato!");
                continue;
            }

            libro.getGeneri().add(genere);
        }

        libroService.save(libro);
        System.out.println("Libro Salvato!");
    }

    public void cercaLibriTitolo() {
        System.out.println("I titoli dei Libri che iniziano con P: ");
        System.out.println(libroService.findByTitoloStartingWithP());
    }

    public void cercaLibriAnno() {
        System.out.println("Libri tra il 2000 e il 2020: ");
        System.out.println(libroService.findByAnnoBetween());
    }

    public void cercaLibriISBN() {
        System.out.println("Libri con ISBN:  ");
        System.out.println(libroService.findByIBSN());
    }


    public void leggiAutoriConLibri() {
        System.out.println("Autori con libri: ");
        for (Autore autore : autoreService.findAllWithBook()) {
            System.out.println(autore);
            System.out.println(autore.getLibri());
        }
       
    }

    public void leggiGeneriConLibri() {
        System.out.println("Generi con libri: ");
        for (Genere genere : genereService.findAllWithBook()) {
            System.out.println(genere);
            System.out.println(genere.getLibri());
        }
    }

}
