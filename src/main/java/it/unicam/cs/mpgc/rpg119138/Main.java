package it.unicam.cs.mpgc.rpg119138; // <--- Fai attenzione al pacchetto!

import it.unicam.cs.mpgc.rpg119138.modello.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.Guerriero;
import it.unicam.cs.mpgc.rpg119138.modello.Arciere;
import it.unicam.cs.mpgc.rpg119138.modello.Mago;

public class Main {
    public static void main(String[] args) {
        // Creiamo un Guerriero e lo trattiamo come un "Eroe" generico (Polimorfismo)
        Eroe Guerriero = new Guerriero("Aragorn");
        Eroe Mago = new Mago("Merlino");
        Eroe Arciere = new Arciere("Legolas");

        System.out.println("Eroe creato: " + Guerriero.getNome());
        System.out.println("Vita: " + Guerriero.getPuntiVita());
        System.out.println("--- Inizio Combattimento ---");

        System.out.println("Eroe creato: " + Mago.getNome());
        System.out.println("Vita: " + Mago.getPuntiVita());
        System.out.println("--- Inizio Combattimento ---");

        System.out.println("Eroe creato: " + Arciere.getNome());
        System.out.println("Vita: " + Arciere.getPuntiVita());
        System.out.println("--- Inizio Combattimento ---");

        // Chiama l'attacco specifico del Guerriero
        Guerriero.attacca();
        Mago.attacca();
        Arciere.attacca();
    }
}
