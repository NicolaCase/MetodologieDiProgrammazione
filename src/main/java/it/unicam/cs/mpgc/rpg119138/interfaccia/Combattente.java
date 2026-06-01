package it.unicam.cs.mpgc.rpg119138.interfaccia;

/**
 * Contratto per qualsiasi entità capace di attaccare un bersaglio.
 * Il bersaglio è un Vitale: basta che abbia HP, non è obbligatorio che attacchi a sua volta.
 */
public interface Combattente {
    void attacca(Vitale bersaglio);
}
