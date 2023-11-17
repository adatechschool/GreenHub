package com.greenhub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// indique a spring que la classe est un composant pour qu'au démarrage la classe soit prise en compte dans le balayage auto qui a lieu au lancement de spring
@Component
public class firstPrint2 implements CommandLineRunner {
    // CommandLineRunner  =  interface de SpringBoot qui permet de run du code         (il existe d'autre manière d'utiliser commandLineRunner)
    // qd commandLineRunner dans une classe => le bean (classe au sein du contexte spring)
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World 2");
    }
}
