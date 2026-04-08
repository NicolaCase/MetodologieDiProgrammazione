package it.unicam.cs.mpgc.rpg119138.modello.personaggi;

public class Guerriero extends Eroe{

    private int doppioColpo; //Attributo specifico Guerriero

    public Guerriero(String nome){
        // 'super' chiama il costruttore della classe astratta Eroe
        // (Nome, 150 Punti Vita, Livello 1)
        super(nome, 150, 1, 10, 0, 0);
        this.doppioColpo=20;
    }

    /**
     * Implementazione specifica dell'attacco del Guerriero.
     * Usiamo @Override come buona pratica.
     */

    @Override
    public void attacca(){
        System.out.println(getNome() + " Sferra un colpo (Danno: " + getForza() + ")");
    }
}
