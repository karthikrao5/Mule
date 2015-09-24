package teamJankkk.controller;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import teamJankkk.model.Player;
import teamJankkk.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import teamJankkk.model.PlayerDB;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PlayerSelect extends Main implements Initializable{

    @FXML private TextField nameTextField;
    @FXML private Label configLabel;
    @FXML private Button nextButton1;
    @FXML private Button saveButton1;
    @FXML private Button exitButton1;
    @FXML private ChoiceBox<String> raceChoiceBox;
    @FXML private ChoiceBox<String> colorChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //saveButton1.setOnAction(this::saveName);
        nextButton1.setOnAction(this::nextScreen);
        exitButton1.setOnAction(this::exitApp);
    }

    /*
    @FXML
    void saveName(ActionEvent event) {
        // want to remove this button - put in nextScreen, if statment for empty to give alert
        String name = nameTextField.getText();
        String race = raceChoiceBox.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox.getSelectionModel().getSelectedItem();
        if (name == null || race == null || color == null) {
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(ConfigController.);
            alert.setTitle("Empty Field");
            alert.setHeaderText("One of the Fields has not been filled in.");
            alert.setContentText("Please fill in all text fields.");
            alert.showAndWait();
        } else {
            configLabel.setText("What up boss, your name is "
                    + name
                    + ", your race is " + race
                    + " and you'll be playing for the " + color + " team!");
            PlayerDB.createPlayer(name, 0);
            PlayerDB.setRace(race, 0);
            PlayerDB.setColor(color, 0);
            configLabel.setText(PlayerDB.toString(0));
        }
    }
    */

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            // at button, check num players, then skip to game Summary window if at that number
            String name = nameTextField.getText();
            String race = raceChoiceBox.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox.getSelectionModel().getSelectedItem();
            if (name == null || race == null || color == null) {
                Alert alert = new Alert(AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
                configLabel.setText("What up boss, your name is "
                        + name
                        + ", your race is " + race
                        + " and you'll be playing for the " + color + " team!");
                PlayerDB.createPlayer(name, 0);
                PlayerDB.setRace(race, 0);
                PlayerDB.setColor(color, 0);
                configLabel.setText(PlayerDB.toString(0));

                if (ConfigController.getPlayerCount() > 1) {
                    Pane screen2 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player2Select.fxml"));
                    stage.setScene(new Scene(screen2));
                    stage.show();
                } else {
                    Pane gameSumPane = (Pane) FXMLLoader.load(getClass().getResource("../views/GameSummary.fxml"));
                    stage.setScene(new Scene(gameSumPane));
                    stage.show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp(ActionEvent event) {
        Stage stage = (Stage) exitButton1.getScene().getWindow();
        stage.close();
    }
}
