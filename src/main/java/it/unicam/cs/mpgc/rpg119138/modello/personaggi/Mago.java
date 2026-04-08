package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

public class Mago extends Eroe {

    private int pallaDiFuoco;

    public Mago(String nome) {
        super(nome, 100,1,0,20,0);
        this.pallaDiFuoco=30;
    }

    @Override
    public void attacca(){
        System.out.println(getNome() + " Lancia un incantesimo (Danno: " + getMana() + ")");
    }
}
