package it.unicam.cs.mpgc.rpg119138.controller;

import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;

import java.util.ArrayList;
import java.util.List;

public class GestoreCombattimento {

    private final Eroe eroe;
    private final List<Mostro> mostri;

    public GestoreCombattimento(Eroe eroe, List<Mostro> mostri) {
        if (eroe == null) throw new IllegalArgumentException("L'eroe non può essere nullo");
        if (mostri == null || mostri.isEmpty()) throw new IllegalArgumentException("La lista dei mostri non può essere vuota");
        this.eroe = eroe;
        this.mostri = mostri;
    }

    public void attaccaMostro(Mostro bersaglio) {
        if (!bersaglio.isVivo()) throw new IllegalArgumentException("Il mostro scelto è già morto");
        eroe.attacca(bersaglio);
        if (!livelloCompletato()) {
            contrattaccano();
        }
    }

    private void contrattaccano() {
        for (Mostro mostro : getMostriVivi()) {
            mostro.attacca(eroe);
        }
    }

    public List<Mostro> getMostriVivi() {
        List<Mostro> vivi = new ArrayList<>();
        for (Mostro mostro : mostri) {
            if (mostro.isVivo()) vivi.add(mostro);
        }
        return vivi;
    }

    public boolean livelloCompletato() {
        return getMostriVivi().isEmpty();
    }

    public boolean eroeVivo() {
        return eroe.isVivo();
    }

    public Eroe getEroe() { return eroe; }
    public List<Mostro> getMostri() { return mostri; }
}
