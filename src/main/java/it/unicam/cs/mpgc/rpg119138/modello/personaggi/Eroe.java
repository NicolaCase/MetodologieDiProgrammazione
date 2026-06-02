package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Entita;
import it.unicam.cs.mpgc.rpg119138.interfaccia.Vitale;
import java.util.Objects;

public abstract class Eroe implements Entita {

    private final String nome;
    private int hp;
    private final int livello;
    private final int forza;
    private final int mana;
    private final int destrezza;

    public Eroe(String nome, int hp, int livello, int forza, int mana, int destrezza) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Il nome non può essere vuoto");
        if (hp <= 0) throw new IllegalArgumentException("Gli HP devono essere positivi");
        this.nome = nome;
        this.hp = hp;
        this.livello = livello;
        this.forza = forza;
        this.mana = mana;
        this.destrezza = destrezza;
    }

    @Override
    public abstract void attacca(Vitale bersaglio);

    public boolean haAbbastanzaMana(int costo) {
        return this.mana >= costo;
    }

    @Override
    public void riceviDanno(int danno) {
        if (danno < 0) return;
        this.hp = Math.max(0, this.hp - danno);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eroe eroe = (Eroe) o;
        return Objects.equals(nome, eroe.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome + " [HP: " + hp + ", LV: " + livello + "]";
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public int getHp() { return hp; }

    @Override
    public void setHp(int hp) { this.hp = hp; }

    @Override
    public boolean isVivo() { return this.hp > 0; }

    public int getLivello() { return livello; }
    public int getForza() { return forza; }
    public int getMana() { return mana; }
    public int getDestrezza() { return destrezza; }
}
