package it.unicam.cs.mpgc.rpg119138;

// Importiamo le classi dai nuovi sottopacchetti
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Vampiro;

public class Main {
    public static void main(String[] args) {
        // 1. Creazione dei contendenti
        Eroe giocatore = new Guerriero("Aragorn");
        Mostro nemico = new Vampiro("Alucard");

        System.out.println("--- INIZIO TEST SCONTRO ---");
        System.out.println(giocatore.getNome() + " (HP: " + giocatore.getPuntiVita() + ") VS "
                + nemico.getNome() + " (HP: " + nemico.getHp() + ")");
        System.out.println("---------------------------");

        // 2. Simulazione Round 1
        // L'eroe attacca
        giocatore.attacca();
        nemico.riceviDanno(giocatore.getForza());

        // Il mostro risponde
        if (nemico.getHp() > 0) {
            nemico.attaccaNemico();
            giocatore.riceviDanno(nemico.getForza());
        }

        // 3. Verifiche finali
        System.out.println("---------------------------");
        System.out.println("Stato finale HP: " + giocatore.getNome() + ": " + giocatore.getPuntiVita());
        System.out.println("Stato finale HP: " + nemico.getNome() + ": " + nemico.getHp());
    }
}