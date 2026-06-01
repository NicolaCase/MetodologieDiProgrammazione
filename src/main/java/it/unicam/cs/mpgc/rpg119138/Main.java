package it.unicam.cs.mpgc.rpg119138;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Entita;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Orco;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;

public class Main {
    public static void main(String[] args) {
        Entita eroe = new Guerriero("Thorin", 150, 1, 20, 0, 0);
        Entita nemico = new Orco("Gork", 100, 15);

        System.out.println("Partita iniziata con: " + eroe.getNome());
        eroe.attacca(nemico);
        System.out.println("Gli hp dei " + nemico.getNome() + " dopo l'attacco sono: " + nemico.getHp());
    }
}
