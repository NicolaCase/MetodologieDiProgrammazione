package it.unicam.cs.mpgc.rpg119138.view;

import it.unicam.cs.mpgc.rpg119138.logica.SessioneGioco;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Arciere;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Guerriero;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Mago;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SelezioneEroeController {

    @FXML private HBox contenuto;

    private SessioneGioco sessione;

    public void setSessione(SessioneGioco sessione) {
        this.sessione = sessione;
    }

    @FXML
    private void onScegliGuerriero() {
        scegli(new Guerriero("Guerriero", 150, 1, 20, 0, 0));
    }

    @FXML
    private void onScegliMago() {
        scegli(new Mago("Mago", 80, 1, 0, 40, 0));
    }

    @FXML
    private void onScegliArciere() {
        scegli(new Arciere("Arciere", 115, 1, 0, 0, 25));
    }

    private void scegli(Eroe eroe) {
        sessione.iniziaNuovaPartita(eroe);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mappa.fxml"));
            Parent root = loader.load();
            MappaController controller = loader.getController();
            controller.setSessione(sessione);
            getStage().setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento della schermata", e);
        }
    }

    private Stage getStage() {
        return (Stage) contenuto.getScene().getWindow();
    }
}
