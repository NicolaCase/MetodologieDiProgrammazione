package it.unicam.cs.mpgc.rpg119138.interfaccia;

/**
 * Contratto combinato per le entità del gioco che sono sia vive che combattenti.
 * Estende Vitale e Combattente senza aggiungere metodi: segue il Dependency Inversion Principle,
 * permettendo di dipendere da un'unica astrazione senza accoppiare le due responsabilità.
 */
public interface Entita extends Vitale, Combattente {
}
