package it.unicam.cs.mpgc.rpg119138.logica;

import it.unicam.cs.mpgc.rpg119138.controller.GestoreLivelli;
import it.unicam.cs.mpgc.rpg119138.modello.Livello;

import java.util.List;

public class MappaMondo {

    private final List<Livello> livelli;

    public MappaMondo() {
        this.livelli = new GestoreLivelli().caricaLivelli();
    }

    public void sbloccaProssimoLivello(String idLivello) {
        int id = Integer.parseInt(idLivello);
        for (int i = 0; i < livelli.size() - 1; i++) {
            if (livelli.get(i).getId() == id) {
                livelli.get(i + 1).sblocca();
                return;
            }
        }
    }

    public void ripristina(int livelloCompletato) {
        for (Livello livello : livelli) {
            if (livello.getId() <= livelloCompletato + 1) {
                livello.sblocca();
            }
        }
    }

    public boolean isUltimoLivello(int id) {
        return !livelli.isEmpty() && livelli.get(livelli.size() - 1).getId() == id;
    }

    public Livello getLivelloFresco(int id) {
        List<Livello> livelliFresch = new GestoreLivelli().caricaLivelli();
        for (Livello l : livelliFresch) {
            if (l.getId() == id) return l;
        }
        throw new IllegalArgumentException("Livello non trovato: " + id);
    }

    public List<Livello> getLivelli() { return livelli; }
}
