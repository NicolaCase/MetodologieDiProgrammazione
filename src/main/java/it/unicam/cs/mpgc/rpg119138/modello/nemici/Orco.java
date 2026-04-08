package it.unicam.cs.mpgc.rpg119138.modello.nemici;

public class Orco extends Mostro{

    private int fendente;

    public Orco(String nome){

        super(nome, 200, 1,20);
        this.fendente=25;
    }

    @Override
    public void attaccaNemico(){
        System.out.println(getNome() + " Attacca con bastone (Danno: " + getForza() + ")");
    }
}

