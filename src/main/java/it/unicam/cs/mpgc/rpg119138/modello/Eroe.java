package it.unicam.cs.mpgc.rpg119138.modello;

/**
 * Questa è la classe base astratta per tutti gli eroi.
 * Contiene i dati che ogni personaggio ha (nome, punti vita, livello).
 */

public abstract class Eroe {

    // Attributi base privati (incapsulamento)
    private String nome;
    private int hp;
    private int livello;

    // Costruttore per inizializzare un eroe
    public Eroe(String nome, int hp, int livello){
        this.nome=nome;
        this.hp=hp;
        this.livello=livello;
    }
    /**
     * Metodo astratto: ogni classe figlia (Guerriero, Mago, ecc.)
     * dovrà decidere COME attaccare.
     */
    public abstract void attacca();

    // Getter (necessari per il Serializzatore JSON del Prof)

    public String getNome() {
        return nome;
    }
    public int getPuntiVita() {
        return hp;
    }
    public int getLivello() {
        return livello;
    }

}
