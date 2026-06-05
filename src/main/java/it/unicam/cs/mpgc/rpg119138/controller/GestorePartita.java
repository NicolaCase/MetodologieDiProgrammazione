package it.unicam.cs.mpgc.rpg119138.controller;

import it.unicam.cs.mpgc.rpg119138.modello.Livello;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Arciere;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Mago;

import java.util.ArrayList;
import java.util.List;

public class GestorePartita {

    private final List<Eroe> eroi;
    private final List<Livello> livelli;
    private Eroe eroeCorrente;
    private int indiceLivelloCorrente;

    public GestorePartita() {
        this.eroi = creaEroi();
        this.livelli = new GestoreLivelli().caricaLivelli();
        this.indiceLivelloCorrente = 0;
    }

    private List<Eroe> creaEroi() {
        List<Eroe> lista = new ArrayList<>();
        lista.add(new Guerriero("Guerriero", 150, 1, 20, 0, 0));
        lista.add(new Mago("Mago", 80, 1, 0, 40, 0));
        lista.add(new Arciere("Arciere", 115, 1, 0, 0, 25));
        return lista;
    }

    public void iniziaPartita(Eroe eroe) {
        if (eroe == null) throw new IllegalArgumentException("L'eroe non può essere nullo");
        this.eroeCorrente = eroe;
        this.indiceLivelloCorrente = 0;
    }

    public GestoreCombattimento avviaLivello(Livello livello) {
        if (!livello.isSbloccato()) throw new IllegalStateException("Il livello non è ancora sbloccato");
        if (eroeCorrente == null) throw new IllegalStateException("Nessun eroe selezionato");
        return new GestoreCombattimento(eroeCorrente, livello.getNemici());
    }

    public void completaLivello() {
        if (haLivelloSuccessivo()) {
            indiceLivelloCorrente++;
            livelli.get(indiceLivelloCorrente).sblocca();
        }
    }

    public boolean haLivelloSuccessivo() {
        return indiceLivelloCorrente < livelli.size() - 1;
    }

    public List<Eroe> getEroi() { return eroi; }
    public List<Livello> getLivelli() { return livelli; }
    public Eroe getEroeCorrente() { return eroeCorrente; }
    public Livello getLivelloCorrente() { return livelli.get(indiceLivelloCorrente); }
}
