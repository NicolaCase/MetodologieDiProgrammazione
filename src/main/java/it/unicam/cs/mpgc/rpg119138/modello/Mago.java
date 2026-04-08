package it.unicam.cs.mpgc.rpg119138.modello;

public class Mago extends Eroe {

    private int mana;

    public Mago(String nome) {
        super(nome, 100,1);
        this.mana=25;
    }

    @Override
    public void attacca(){
        System.out.println(getNome() + " Lancia un incantesimo (Danno: " + mana + ")");
    }
}
