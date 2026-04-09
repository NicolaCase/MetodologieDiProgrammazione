package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

import it.unicam.cs.mpgc.rpg119138.modello.Entita;

public class Arciere extends Eroe {
    public Arciere(String nome, int hp, int mana, int destrezza, int forza, int livello) {
        super(nome, hp, mana, destrezza, forza, livello);
    }

    @Override
    public void attacca(Entita bersaglio) {
        bersaglio.riceviDanno(this.getDestrezza());
    }
}
