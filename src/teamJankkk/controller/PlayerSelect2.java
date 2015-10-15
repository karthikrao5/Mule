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
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PlayerSelect2 extends Main implements Initializable{

    @FXML private Button save2Button;
    @FXML private Button exitButton2;
    @FXML private ChoiceBox<String> raceChoiceBox2;
    @FXML private ChoiceBox<String> colorChoiceBox2;
    @FXML private TextField nameTextField2;
    @FXML private ChoiceBox<String> raceChoiceBox1;
    @FXML private ChoiceBox<String> colorChoiceBox1;
    @FXML private TextField nameTextField1;
    @FXML private Button nextButton;

//    public static teamJankkk.model.Player p2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        p2 = new Player(null, null, null);
        //save2Button.setOnAction(this::saveName);
        nextButton.setOnAction(this::goToSummary);
    }

    /*
    @FXML
    void saveName(ActionEvent event) {
        String name = nameTextField2.getText();
        String race = raceChoiceBox2.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox2.getSelectionModel().getSelectedItem();
        configLabel2.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        PlayerDB.createPlayer(name, 1);
        PlayerDB.setRace(race, 1);
        PlayerDB.setColor(color, 1);
        configLabel2.setText(PlayerDB.toString(1));
    }
    */

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            String name = nameTextField2.getText();
            String race = raceChoiceBox2.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox2.getSelectionModel().getSelectedItem();
            if(name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
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
    public void goToSummary(ActionEvent event) {
        try {
            String name = nameTextField1.getText();
            String race = raceChoiceBox1.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox1.getSelectionModel().getSelectedItem();
            String name2 = nameTextField2.getText();
            String race2 = raceChoiceBox2.getSelectionModel().getSelectedItem();
            String color2 = colorChoiceBox2.getSelectionModel().getSelectedItem();
            if(name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
                PlayerDB.createPlayer(name, 1);
                PlayerDB.setRace(race, 1);
                PlayerDB.setColor(color, 1);
                PlayerDB.createPlayer(name2, 2);
                PlayerDB.setRace(race2, 2);
                PlayerDB.setColor(color2, 2);
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
        Stage stage = (Stage) exitButton2.getScene().getWindow();
        stage.close();
    }
}
