package it.unicam.cs.mpgc.rpg119138.controller;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Entita;

/**
 * Coordina il flusso di gioco: caricamento livelli, selezione eroe, gestione combattimento.
 * Separato dal modello per rispettare il Single Responsibility Principle:
 * le entità di dominio (Eroe, Mostro) non devono conoscere la logica applicativa.
 */
public class GestorePartita {

    private Entita eroeCorrente;

    public void avviaPartita(Entita eroe) {
        this.eroeCorrente = eroe;
    }

    public Entita getEroeCorrente() {
        return eroeCorrente;
    }
}
