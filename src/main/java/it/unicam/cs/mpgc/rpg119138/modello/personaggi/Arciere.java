package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

public class Arciere extends Eroe {

    private int centro;

    public Arciere(String nome) {
        super(nome, 125,1,0,0,15);
        this.centro=25;
    }

    @Override
    public void attacca(){
        System.out.println(getNome() + " Scaglia una freccia (Danno: " + getDestrezza() + ")");
    }
}
