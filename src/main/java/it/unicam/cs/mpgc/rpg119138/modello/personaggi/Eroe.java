package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

/**
 * Questa è la classe base astratta per tutti gli eroi.
 * Contiene i dati che ogni personaggio ha (nome, punti vita, livello).
 */

public abstract class Eroe {

    // Attributi base privati (incapsulamento)
    private String nome;
    private int hp;
    private int livello;
    private int forza;
    private int mana;
    private int destrezza;

    // Costruttore per inizializzare un eroe
    public Eroe(String nome, int hp, int livello, int forza, int mana , int destrezza){
        this.nome=nome;
        this.hp=hp;
        this.livello=livello;
        this.forza=forza;
        this.mana=mana;
        this.destrezza=destrezza;

    }
    /**
     * Metodo astratto: ogni classe figlia (Guerriero, Mago, ecc.)
     * dovrà decidere COME attaccare.
     */
    public abstract void attacca();

    public void riceviDanno(int danno) {
        this.hp -= danno;
        if (this.hp < 0) this.hp = 0;
        System.out.println(this.nome + " ha ricevuto " + danno + " danni! HP rimanenti: " + this.hp);
    }

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

    public int getForza() {
        return forza;
    }

    public int getMana() {
        return mana;
    }

    public int getDestrezza() {
        return destrezza;
    }
}
