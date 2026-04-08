package it.unicam.cs.mpgc.rpg119138.modello.nemici;

public class Vampiro extends Mostro {

    private int morso;

    public Vampiro(String nome){

        super(nome, 200, 1,15);
        this.morso=20;
    }

    @Override
    public void attaccaNemico(){
        System.out.println(getNome() + " Usa velocità (Danno: " + getForza() + ")");
    }
}
