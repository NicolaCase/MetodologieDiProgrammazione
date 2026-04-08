package it.unicam.cs.mpgc.rpg119138.modello;

public class Arciere extends Eroe {

    private int destrezza;

    public Arciere(String nome) {
        super(nome, 125,1);
        this.destrezza=15;
    }

    @Override
    public void attacca(){
        System.out.println(getNome() + " Scaglia una freccia (Danno: " + destrezza + ")");
    }
}
