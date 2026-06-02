package it.unicam.cs.mpgc.rpg119138.modello.nemici;

import it.unicam.cs.mpgc.rpg119138.interfaccia.Entita;
import it.unicam.cs.mpgc.rpg119138.interfaccia.Vitale;
import java.util.Objects;

public abstract class Mostro implements Entita {

    private final String nome;
    private int hp;
    private final int forza;

    public Mostro(String nome, int hp, int forza) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Il nome non può essere vuoto");
        if (hp <= 0) throw new IllegalArgumentException("Gli HP devono essere positivi");
        this.nome = nome;
        this.hp = hp;
        this.forza = forza;
    }

    @Override
    public void riceviDanno(int danno) {
        if (danno < 0) return;
        this.hp = Math.max(0, this.hp - danno);
    }

    @Override
    public void attacca(Vitale bersaglio) {
        if (this.isVivo()) bersaglio.riceviDanno(this.forza);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mostro mostro = (Mostro) o;
        return Objects.equals(nome, mostro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome + " [HP: " + hp + "]";
    }

    @Override
    public void setHp(int hp) { this.hp = hp; }

    @Override
    public boolean isVivo() { return this.hp > 0; }

    @Override
    public String getNome() { return nome; }

    @Override
    public int getHp() { return hp; }

    public int getForza() { return forza; }
}
