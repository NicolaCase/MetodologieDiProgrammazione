package it.unicam.cs.mpgc.rpg119138.modello;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Orco;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CaricamentoFile {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Carica i mostri dalle risorse (Fissi)
    public List<Orco> caricaMostri() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/mostri.json"))) {
            return gson.fromJson(reader, new TypeToken<List<Orco>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Carica le statistiche base dell'eroe dalle risorse
    public List<Guerriero> caricaClassiEroi() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/eroi.json"))) {
            return gson.fromJson(reader, new TypeToken<List<Guerriero>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // SALVATAGGIO: Scrive il file nella cartella principale del progetto
    public void salvaPartita(Eroe eroe) {
        try (Writer writer = Files.newBufferedWriter(Paths.get("salvataggio.json"))) {
            gson.toJson(eroe, writer);
            System.out.println("Salvataggio effettuato in salvataggio.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}