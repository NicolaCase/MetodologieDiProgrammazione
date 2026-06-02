package it.unicam.cs.mpgc.rpg119138.modello;

import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;

/**
 * Rappresenta un livello del gioco con il suo nemico associato.
 * I dati vengono caricati da livelli.xml tramite GestoreLivelli.
 * Separato dal controller per rispettare il Single Responsibility Principle:
 * questa classe modella il concetto di livello, non la logica di caricamento.
 */
public class Livello {

    private final int id;
    private final String nome;
    private boolean sbloccato;
    private final Mostro nemico;

    public Livello(int id, String nome, boolean sbloccato, Mostro nemico) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Il nome del livello non può essere vuoto");
        if (nemico == null) throw new IllegalArgumentException("Il livello deve avere un nemico");
        this.id = id;
        this.nome = nome;
        this.sbloccato = sbloccato;
        this.nemico = nemico;
    }

    public void sblocca() {
        this.sbloccato = true;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isSbloccato() { return sbloccato; }
    public Mostro getNemico() { return nemico; }

    @Override
    public String toString() {
        return "Livello " + id + ": " + nome + " [" + (sbloccato ? "sbloccato" : "bloccato") + "]";
    }
}
