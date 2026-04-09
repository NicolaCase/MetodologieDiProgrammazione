package it.unicam.cs.mpgc.rpg119138.modello;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Orco;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Mago;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Arciere;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CaricamentoFile {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Carica i mostri dalle risorse.
     * Usa lo stile Files.newBufferedReader (moderno).
     */
    public List<Orco> caricaMostri() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/mostri.json"))) {
            return gson.fromJson(reader, new TypeToken<List<Orco>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Errore caricamento mostri: " + e.getMessage());
            return new ArrayList<>(); // Meglio tornare una lista vuota che null
        }
    }

    /**
     * Carica le classi base degli eroi.
     * Usa lo stile FileReader (come negli esempi Gson di Rossi).
     */
    public List<Eroe> caricaClassiEroi() {
        try (FileReader reader = new FileReader("src/main/resources/eroi.json")) {

            // Usiamo la classe di supporto DatiEroe definita in fondo
            List<DatiEroe> datiGrezi = gson.fromJson(reader, new TypeToken<List<DatiEroe>>(){}.getType());

            List<Eroe> listaFinalizzata = new ArrayList<>();
            if (datiGrezi != null) {
                for (DatiEroe d : datiGrezi) {
                    if (d.nome.equalsIgnoreCase("Guerriero")) {
                        listaFinalizzata.add(new Guerriero(d.nome, d.hp, d.mana, d.destrezza, d.forza, d.livello));
                    } else if (d.nome.equalsIgnoreCase("Mago")) {
                        listaFinalizzata.add(new Mago(d.nome, d.hp, d.mana, d.destrezza, d.forza, d.livello));
                    } else if (d.nome.equalsIgnoreCase("Arciere")) {
                        listaFinalizzata.add(new Arciere(d.nome, d.hp, d.mana, d.destrezza, d.forza, d.livello));
                    }
                }
            }
            return listaFinalizzata;

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file eroi: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Salva lo stato attuale dell'eroe.
     */
    public void salvaPartita(Eroe eroe) {
        try (Writer writer = Files.newBufferedWriter(Paths.get("salvataggio.json"))) {
            gson.toJson(eroe, writer);
            System.out.println("Salvataggio effettuato con successo!");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    /**
     * Classe di supporto interna (DTO) per mappare i campi del JSON.
     * Deve avere i nomi identici alle chiavi del file eroi.json.
     * "Poiché Eroe è una classe astratta e il sistema deve supportare il polimorfismo,
     * ho utilizzato una classe di supporto (DTO) per la deserializzazione.
     * Questo mi permette di leggere i dati grezzi dal JSON e utilizzare una logica di 'Factory'
     * (il ciclo if/else) per istanziare la sottoclasse corretta (Guerriero, Mago o Arciere)
     * in base al campo 'nome'."
     */
    private static class DatiEroe {
        String nome;
        int hp;
        int mana;
        int destrezza;
        int forza;
        int livello;
    }
}