package it.unicam.cs.mpgc.rpg119138;

import it.unicam.cs.mpgc.rpg119138.controller.GestoreCombattimento;
import it.unicam.cs.mpgc.rpg119138.controller.GestoreLivelli;
import it.unicam.cs.mpgc.rpg119138.modello.Livello;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Eroe eroe = new Guerriero("Thorin", 150, 1, 20, 0, 0);
        List<Livello> livelli = new GestoreLivelli().caricaLivelli();
        Scanner scanner = new Scanner(System.in);

        for (Livello livello : livelli) {
            if (!livello.isSbloccato()) break;

            System.out.println("\n=== " + livello + " ===");
            GestoreCombattimento combattimento = new GestoreCombattimento(eroe, livello.getNemici());

            while (!combattimento.livelloCompletato() && combattimento.eroeVivo()) {
                System.out.println("\n" + eroe);
                List<Mostro> vivi = combattimento.getMostriVivi();
                for (int i = 0; i < vivi.size(); i++) {
                    System.out.println(i + ") " + vivi.get(i));
                }
                System.out.print("Scegli chi attaccare (numero): ");
                int scelta = scanner.nextInt();
                combattimento.attaccaMostro(vivi.get(scelta));
            }

            if (!combattimento.eroeVivo()) {
                System.out.println("\nGame Over - " + eroe.getNome() + " è morto!");
                break;
            }

            System.out.println("\nLivello completato! Passi al prossimo.");
            livello.sblocca();
        }

        scanner.close();
    }
}
