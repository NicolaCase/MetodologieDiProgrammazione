package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Vitale;

public class Arciere extends Eroe {

    public Arciere(String nome, int hp, int livello, int forza, int mana, int destrezza) {
        super(nome, hp, livello, forza, mana, destrezza);
    }

    @Override
    public void attacca(Vitale bersaglio) {
        bersaglio.riceviDanno(getDestrezza());
    }

    @Override
    public void aumentaStatisticheLivello() {
        setDestrezza(getDestrezza() + 6);
        aumentaHpMax(15);
    }
}
