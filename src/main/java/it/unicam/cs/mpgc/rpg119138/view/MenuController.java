package it.unicam.cs.mpgc.rpg119138.view;

import it.unicam.cs.mpgc.rpg119138.logica.SessioneGioco;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML private Button btnNuova;

    private SessioneGioco sessione;

    @FXML
    private void initialize() {
        sessione = new SessioneGioco();
    }

    @FXML
    private void onNuovaPartita() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("selezioneEroe.fxml"));
            Parent root = loader.load();
            SelezioneEroeController controller = loader.getController();
            controller.setSessione(sessione);
            getStage().setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento della schermata", e);
        }
    }

    @FXML
    private void onCaricaPartita() {
        sessione.caricaPartitaEsistente();
        if (sessione.getEroeAttivo() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nessun salvataggio");
            alert.setHeaderText(null);
            alert.setContentText("Non è stato trovato nessun salvataggio. Inizia una nuova partita.");
            alert.showAndWait();
            return;
        }
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
        return (Stage) btnNuova.getScene().getWindow();
    }
}
