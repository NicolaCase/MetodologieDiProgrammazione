package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Vitale;

public class Guerriero extends Eroe {

    public Guerriero(String nome, int hp, int livello, int forza, int mana, int destrezza) {
        super(nome, hp, livello, forza, mana, destrezza);
    }

    @Override
    public void attacca(Vitale bersaglio) {
        bersaglio.riceviDanno(getForza());
    }

    @Override
    public void aumentaStatisticheLivello() {
        setForza(getForza() + 5);
        aumentaHpMax(20);
    }
}
