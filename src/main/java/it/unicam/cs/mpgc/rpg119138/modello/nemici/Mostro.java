package it.unicam.cs.mpgc.rpg119138.modello.nemici;

public abstract class Mostro {

    private String nome;
    private int hp;
    private int livello;
    private int forza;

    public Mostro( String nome, int hp, int livello, int forza){

        this.nome=nome;
        this.hp=hp;
        this.livello=livello;
        this.forza=forza;
    }

    public void riceviDanno(int danno) {
        this.hp -= danno;
        if (this.hp < 0) this.hp = 0;
        System.out.println(this.nome + " ha ricevuto " + danno + " danni! HP rimanenti: " + this.hp);
    }

    public abstract void attaccaNemico();

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getLivello() {
        return livello;
    }

    public int getForza() {
        return forza;
    }
}
