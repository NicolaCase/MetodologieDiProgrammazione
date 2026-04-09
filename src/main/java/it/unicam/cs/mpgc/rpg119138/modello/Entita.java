package it.unicam.cs.mpgc.rpg119138.modello;

//Interfaccia per il comportamento di tutte le entità del gioco
public interface Entita {
    String getNome();
    int getHp();
    void setHp(int hp);
    boolean isVivo();

    void attacca(Entita bersaglio);

    void riceviDanno(int danno);

}
