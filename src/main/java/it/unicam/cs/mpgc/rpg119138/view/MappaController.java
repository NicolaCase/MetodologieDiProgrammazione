package it.unicam.cs.mpgc.rpg119138.view;

import it.unicam.cs.mpgc.rpg119138.logica.SessioneGioco;
import it.unicam.cs.mpgc.rpg119138.modello.Livello;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MappaController {

    @FXML private HBox contenitoreLivelli;
    @FXML private Label lblEroe;

    private SessioneGioco sessione;

    public void setSessione(SessioneGioco sessione) {
        this.sessione = sessione;
        aggiornaMappa();
    }

    private void aggiornaMappa() {
        lblEroe.setText(sessione.getEroeAttivo().toString());
        contenitoreLivelli.getChildren().clear();

        for (Livello livello : sessione.getMappa().getLivelli()) {
            contenitoreLivelli.getChildren().add(creaCartaLivello(livello));
        }
    }

    private VBox creaCartaLivello(Livello livello) {
        Label nome = new Label(livello.getNome());
        Label stato = new Label(livello.isSbloccato() ? "Aperto" : "Bloccato");

        Button btn = new Button("Entra");
        btn.setDisable(!livello.isSbloccato());
        btn.setOnAction(e -> avviaLivello(livello));
        btn.setPrefWidth(120);

        VBox carta = new VBox(8, nome, stato, btn);
        carta.setAlignment(Pos.CENTER);
        return carta;
    }

    private void avviaLivello(Livello livello) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("combattimento.fxml"));
            Parent root = loader.load();
            CombattimentoController controller = loader.getController();
            controller.setSessione(sessione);
            controller.setLivello(sessione.getMappa().getLivelloFresco(livello.getId()));
            getStage().setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento della schermata", e);
        }
    }

    private Stage getStage() {
        return (Stage) contenitoreLivelli.getScene().getWindow();
    }
}
