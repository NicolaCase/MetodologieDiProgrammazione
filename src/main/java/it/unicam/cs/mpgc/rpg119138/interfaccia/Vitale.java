package it.unicam.cs.mpgc.rpg119138.interfaccia;

/**
 * Contratto per qualsiasi entità che possiede punti vita e può subire danni.
 * Separata da Combattente per rispettare l'Interface Segregation Principle:
 * non tutto ciò che ha HP deve necessariamente attaccare (es. oggetti, trappole).
 */
public interface Vitale {
    String getNome();
    int getHp();
    void setHp(int hp);
    boolean isVivo();
    void riceviDanno(int danno);
}
