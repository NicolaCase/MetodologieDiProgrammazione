package it.unicam.cs.mpgc.rpg119138.modello.nemici;

import it.unicam.cs.mpgc.rpg119138.modello.Entita;

public abstract class Mostro implements Entita {

    private String nome;
    private int hp;
    private int forza;

    public Mostro( String nome, int hp, int forza){

        this.nome=nome;
        this.hp=hp;
        this.forza=forza;
    }

    public void riceviDanno(int danno) {
        this.hp -= danno;
        if (this.hp < 0) this.hp = 0;
    }

    @Override
    public void attacca(Entita bersaglio) {
        bersaglio.riceviDanno(this.forza);
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean isVivo() {
        return this.hp > 0;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getHp() {
        return hp;
    }

    public int getForza() {
        return forza;
    }
}
