package it.unicam.cs.mpgc.rpg119138.view;

import it.unicam.cs.mpgc.rpg119138.controller.GestoreCombattimento;
import it.unicam.cs.mpgc.rpg119138.logica.SessioneGioco;
import it.unicam.cs.mpgc.rpg119138.modello.Livello;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombattimentoController {

    @FXML private Label lblEroe;
    @FXML private Label lblLivello;
    @FXML private TextArea logCombattimento;
    @FXML private VBox contenitoreNemici;

    private SessioneGioco sessione;
    private Livello livello;
    private GestoreCombattimento gestoreCombattimento;
    private List<Button> bottoniNemici;

    public void setSessione(SessioneGioco sessione) {
        this.sessione = sessione;
    }

    public void setLivello(Livello livello) {
        this.livello = livello;
        inizializza();
    }

    private void inizializza() {
        gestoreCombattimento = new GestoreCombattimento(sessione.getEroeAttivo(), livello.getNemici());
        bottoniNemici = new ArrayList<>();
        lblLivello.setText(livello.toString());
        aggiornaEroe();
        creaBottoniNemici();
    }

    private void creaBottoniNemici() {
        contenitoreNemici.getChildren().clear();
        bottoniNemici.clear();
        List<Mostro> nemici = livello.getNemici();
        for (int i = 0; i < nemici.size(); i++) {
            Mostro mostro = nemici.get(i);
            Button btn = new Button(mostro.getNome() + " " + (i + 1) + "\nHP: " + mostro.getHp());
            btn.setPrefWidth(160);
            btn.setPrefHeight(60);
            btn.setOnAction(e -> attacca(mostro));
            bottoniNemici.add(btn);
            contenitoreNemici.getChildren().add(btn);
        }
    }

    private void attacca(Mostro bersaglio) {
        if (!bersaglio.isVivo()) return;

        int hpEroePrima = sessione.getEroeAttivo().getHp();
        int hpNemicoPrima = bersaglio.getHp();

        gestoreCombattimento.attaccaMostro(bersaglio);

        int dannoANemico = hpNemicoPrima - bersaglio.getHp();
        int dannoAllEroe = hpEroePrima - sessione.getEroeAttivo().getHp();

        aggiungiLog(sessione.getEroeAttivo().getNome() + " colpisce " + bersaglio.getNome() + " (-" + dannoANemico + " HP)");
        if (dannoAllEroe > 0) {
            aggiungiLog("I nemici contrattaccano: -" + dannoAllEroe + " HP");
        }

        aggiornaEroe();
        aggiornaBottoniNemici();
        controllaFine();
    }

    private void aggiornaEroe() {
        lblEroe.setText(sessione.getEroeAttivo().toString());
    }

    private void aggiornaBottoniNemici() {
        List<Mostro> nemici = livello.getNemici();
        for (int i = 0; i < nemici.size(); i++) {
            Mostro mostro = nemici.get(i);
            Button btn = bottoniNemici.get(i);
            if (mostro.isVivo()) {
                btn.setText(mostro.getNome() + " " + (i + 1) + "\nHP: " + mostro.getHp());
            } else {
                btn.setText(mostro.getNome() + " " + (i + 1) + "\n[Sconfitto]");
                btn.setDisable(true);
            }
        }
    }

    private void aggiungiLog(String messaggio) {
        logCombattimento.appendText(messaggio + "\n");
    }

    private void controllaFine() {
        if (!gestoreCombattimento.eroeVivo()) {
            aggiungiLog("\n--- GAME OVER ---");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText(sessione.getEroeAttivo().getNome() + " è caduto in battaglia.");
            alert.showAndWait();
            tornaAlMenu();
        } else if (gestoreCombattimento.livelloCompletato()) {
            aggiungiLog("\n--- LIVELLO COMPLETATO! ---");
            sessione.vittoriaLivello(String.valueOf(livello.getId()));
            if (sessione.getMappa().isUltimoLivello(livello.getId())) {
                aggiungiLog("--- HAI COMPLETATO IL GIOCO! ---");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Vittoria Finale!");
                alert.setHeaderText("Hai completato il gioco!");
                alert.setContentText("Complimenti! Hai sconfitto tutti i nemici.");
                alert.showAndWait();
                tornaAlMenu();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Livello Completato!");
                alert.setHeaderText(null);
                alert.setContentText("Livello completato! Il tuo eroe è cresciuto.");
                alert.showAndWait();
                tornaAllaMappa();
            }
        }
    }

    private void tornaAllaMappa() {
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

    private void tornaAlMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            getStage().setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento della schermata", e);
        }
    }

    private Stage getStage() {
        return (Stage) logCombattimento.getScene().getWindow();
    }
}
