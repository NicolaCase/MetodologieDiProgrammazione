package it.unicam.cs.mpgc.rpg119138.modello;

import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;
import java.util.List;

public class Livello {

    private final int id;
    private final String nome;
    private boolean sbloccato;
    private final List<Mostro> nemici;

    public Livello(int id, String nome, boolean sbloccato, List<Mostro> nemici) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Il nome del livello non può essere vuoto");
        if (nemici == null || nemici.isEmpty()) throw new IllegalArgumentException("Il livello deve avere almeno un nemico");
        this.id = id;
        this.nome = nome;
        this.sbloccato = sbloccato;
        this.nemici = nemici;
    }

    public void sblocca() {
        this.sbloccato = true;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isSbloccato() { return sbloccato; }
    public List<Mostro> getNemici() { return nemici; }

    @Override
    public String toString() {
        return "Livello " + id + ": " + nome + " [" + (sbloccato ? "sbloccato" : "bloccato") + "]";
    }
}