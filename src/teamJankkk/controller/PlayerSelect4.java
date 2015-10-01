package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.font.BidiUtils;
import teamJankkk.Main;
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by karthik on 9/18/15.
 */
public class PlayerSelect4 extends Main implements Initializable {

    @FXML private TextField nameTextField4;
    @FXML private Button goToSummaryButton;
    @FXML private Button save4Button;
    @FXML private Button exitButton4;
    @FXML private ChoiceBox<String> raceChoiceBox4;
    @FXML private ChoiceBox<String> colorChoiceBox4;

    //public static teamJankkk.model.Player p4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        p4 = new Player(null, null, null);
        //save4Button.setOnAction(this::saveName);
        goToSummaryButton.setOnAction(this::goToSummary);
    }

    /*
    @FXML
    void saveName(ActionEvent event) {
        String name = nameTextField4.getText();
        String race = raceChoiceBox4.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox4.getSelectionModel().getSelectedItem();
        configLabel4.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        PlayerDB.createPlayer(name, 3);
        PlayerDB.setRace(race, 3);
        PlayerDB.setColor(color, 3);
        configLabel4.setText(PlayerDB.toString(3));

    }
    */

    @FXML
    public void goToSummary(ActionEvent event) {
        try {
            String name = nameTextField4.getText();
            String race = raceChoiceBox4.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox4.getSelectionModel().getSelectedItem();
            if(name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
                PlayerDB.createPlayer(name, 3);
                PlayerDB.setRace(race, 3);
                PlayerDB.setColor(color, 3);
                PlayerDB.createPlayer(name, 4);
                PlayerDB.setRace(race, 4);
                PlayerDB.setColor(color, 4);
                Pane gameSumPane = (Pane) FXMLLoader.load(getClass().getResource("../views/GameSummary.fxml"));
                stage.setScene(new Scene(gameSumPane));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp(ActionEvent event) {
        Stage stage = (Stage) exitButton4.getScene().getWindow();
        stage.close();
    }
}
