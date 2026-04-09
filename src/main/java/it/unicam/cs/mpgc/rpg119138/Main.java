package it.unicam.cs.mpgc.rpg119138;

import it.unicam.cs.mpgc.rpg119138.modello.CaricamentoFile;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Orco;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CaricamentoFile loader = new CaricamentoFile();

        // 1. Carichiamo le classi disponibili dal JSON
        List<Guerriero> classiDisponibili = loader.caricaClassiEroi();
        Guerriero mioEroe = classiDisponibili.get(0); // Prendiamo il Guerriero dal file eroi.json

        // 2. Carichiamo i mostri
        List<Orco> nemici = loader.caricaMostri();
        Orco nemico = nemici.get(0);

        System.out.println("Partita iniziata con: " + mioEroe.getNome());

        // 3. Combattimento
        mioEroe.attacca(nemico);
        System.out.println("HP " + nemico.getNome() + " scesi a: " + nemico.getHp());

        // 4. Simuliamo un cambiamento (l'eroe guadagna vita o scende)
        mioEroe.setHp(140);

        // 5. Salviamo lo stato attuale
        loader.salvaPartita(mioEroe);
    }
}