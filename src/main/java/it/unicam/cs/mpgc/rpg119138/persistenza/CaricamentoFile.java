package it.unicam.cs.mpgc.rpg119138.persistenza;

import com.google.gson.Gson;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Arciere;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Mago;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaricamentoFile {

    private static final String FILE_SALVATAGGIO = "salvataggio.json";
    private final Gson gson = new Gson();

    public void salvaPartita(Eroe eroe, int livelloRaggiunto) {
        DatiEroe dati = new DatiEroe(eroe, livelloRaggiunto);
        try (FileWriter writer = new FileWriter(FILE_SALVATAGGIO)) {
            gson.toJson(dati, writer);
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il salvataggio della partita", e);
        }
    }

    public Eroe caricaSalvataggio() {
        try (FileReader reader = new FileReader(FILE_SALVATAGGIO)) {
            DatiEroe dati = gson.fromJson(reader, DatiEroe.class);
            return ricostruisciEroe(dati);
        } catch (IOException e) {
            return null;
        }
    }

    public int caricaLivelloRaggiunto() {
        try (FileReader reader = new FileReader(FILE_SALVATAGGIO)) {
            DatiEroe dati = gson.fromJson(reader, DatiEroe.class);
            return dati.livelloRaggiunto;
        } catch (IOException e) {
            return 0;
        }
    }

    private Eroe ricostruisciEroe(DatiEroe dati) {
        if ("Guerriero".equals(dati.tipo))
            return new Guerriero(dati.nome, dati.hp, dati.livello, dati.forza, dati.mana, dati.destrezza);
        if ("Mago".equals(dati.tipo))
            return new Mago(dati.nome, dati.hp, dati.livello, dati.forza, dati.mana, dati.destrezza);
        if ("Arciere".equals(dati.tipo))
            return new Arciere(dati.nome, dati.hp, dati.livello, dati.forza, dati.mana, dati.destrezza);
        throw new IllegalArgumentException("Tipo eroe non riconosciuto: " + dati.tipo);
    }

    private static class DatiEroe {
        String tipo;
        String nome;
        int hp;
        int livello;
        int forza;
        int mana;
        int destrezza;
        int livelloRaggiunto;

        DatiEroe(Eroe eroe, int livelloRaggiunto) {
            this.tipo = eroe.getClass().getSimpleName();
            this.nome = eroe.getNome();
            this.hp = eroe.getHp();
            this.livello = eroe.getLivello();
            this.forza = eroe.getForza();
            this.mana = eroe.getMana();
            this.destrezza = eroe.getDestrezza();
            this.livelloRaggiunto = livelloRaggiunto;
        }
    }
}
