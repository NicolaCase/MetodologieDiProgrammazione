package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Vitale;

public class Mago extends Eroe {

    public Mago(String nome, int hp, int livello, int forza, int mana, int destrezza) {
        super(nome, hp, livello, forza, mana, destrezza);
    }

    @Override
    public void attacca(Vitale bersaglio) {
        bersaglio.riceviDanno(getMana());
    }

    @Override
    public void aumentaStatisticheLivello() {
        setMana(getMana() + 8);
        aumentaHpMax(10);
    }
}
