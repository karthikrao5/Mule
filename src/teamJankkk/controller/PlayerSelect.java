package teamJankkk.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerSelect extends Main implements Initializable{

    @FXML private TextField nameTextField;
    @FXML private Label configLabel;
    @FXML private Button nextButton1;
    @FXML private Button saveButton1;
    @FXML private ChoiceBox<String> raceChoiceBox;
    @FXML private ChoiceBox<String> colorChoiceBox;
//    @FXML private ObservableList<String> raceCBData =
//            FXCollections.observableArrayList();

    public static teamJankkk.model.Player p1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1 = new Player(null, null, null);
        saveButton1.setOnAction(this::saveName);
        nextButton1.setOnAction(this::nextScreen);
    }

    @FXML
    void saveName(ActionEvent event) {
        System.out.print("Hello");
        String name = nameTextField.getText();
        String race = raceChoiceBox.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox.getSelectionModel().getSelectedItem();
        configLabel.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        p1.setName(name);
        p1.setRace(race);
        p1.setColor(color);

        configLabel.setText(p1.getName() + p1.getColor() + p1.getRace());

    }

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            Pane screen2 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player2Select.fxml"));
            stage.setScene(new Scene(screen2));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
