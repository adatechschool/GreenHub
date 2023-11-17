package com.greenhub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//
@Component
public class firstPrint implements CommandLineRunner {
    // CommandLineRunner  =  interface de SpringBoot qui permet de run du code         (il existe d'autre manière d'utiliser commandLineRunner)
    // qd commandLineRunner dans une classe => le bean (classe au sein du contexte spring)
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
    }
}

