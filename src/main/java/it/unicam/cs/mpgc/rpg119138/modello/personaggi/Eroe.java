package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

import it.unicam.cs.mpgc.rpg119138.modello.Entita;

/**
 * Questa è la classe base astratta per tutti gli eroi.
 * Contiene i dati che ogni personaggio ha (nome, punti vita, livello).
 */

public abstract class Eroe implements Entita {

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

    //implementazione attacco base
    // Rendiamo l'attacco astratto: ogni eroe attacca in modo diverso!
    @Override
    public abstract void attacca(Entita bersaglio);

    @Override
    public void riceviDanno(int danno) {
        this.hp -= danno;
        if (this.hp < 0) this.hp = 0;
    }

    // Getter (necessari per il Serializzatore JSON del Prof)

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean isVivo() {
        return this.hp > 0;
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
