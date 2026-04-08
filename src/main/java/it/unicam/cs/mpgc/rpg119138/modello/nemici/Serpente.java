package it.unicam.cs.mpgc.rpg119138.modello.nemici;

public class Serpente extends Mostro {

    private int strisciata;

    public Serpente(String nome){

        super(nome, 200, 1,15);
        this.strisciata=20;
    }

    @Override
    public void attaccaNemico(){
        System.out.println(getNome() + " Usa veleno (Danno: " + getForza() + ")");
    }
}