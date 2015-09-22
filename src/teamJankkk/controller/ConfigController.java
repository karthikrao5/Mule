package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import teamJankkk.Main;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigController extends Main implements Initializable {


    @FXML private Button onePlayer;
    @FXML private Button twoPlayer;
    @FXML private Button threePlayer;
    @FXML private Button fourPlayer;
    @FXML private Button Beg;
    @FXML private Button Int;
    @FXML private Button Hard;
    @FXML private Button Map1;
    @FXML private Button Map2;
    @FXML private Button Map3;
    @FXML private Label playerLabel;
    @FXML private Label mapLabel;
    @FXML private Label diffLabel;
    private int players = 0, howhard = 0, mapChoice = 0;

    @FXML private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startButton.setOnAction(this::goToPlayerSelection);
    }


    @FXML
    void setPlayers1(ActionEvent event) {
        Integer one = 1;
        String jaboo = one.toString();
        playerLabel.setText(jaboo + " Player");
        players = 1;
    }
    @FXML
    void setPlayers2(ActionEvent event) {
        Integer one = 2;
        String jaboo = one.toString();
        playerLabel.setText(jaboo + " Players");
        players = 2;
    }
    @FXML
    void setPlayers3(ActionEvent event) {
        Integer one = 3;
        String jaboo = one.toString();
        playerLabel.setText(jaboo + " Players");
        players = 3;
    }
    @FXML
    void setPlayers4(ActionEvent event) {
        Integer one = 4;
        String jaboo = one.toString();
        playerLabel.setText(jaboo + " Players");
        players = 4;
    }
    @FXML
    void setDiff1(ActionEvent event) {
        diffLabel.setText("Beginner");
        howhard = 1;
    }
    @FXML
    void setDiff2(ActionEvent event) {
        diffLabel.setText("Intermediate");
        howhard = 2;
    }
    @FXML
    void setDiff3(ActionEvent event) {
        diffLabel.setText("Advanced");
        howhard = 3;
    }
    @FXML
    void setMap1(ActionEvent event) {
        mapLabel.setText("Map 1");
        mapChoice = 1;
    }
    @FXML
    void setMap2(ActionEvent event) {
        mapLabel.setText("Map 2");
        mapChoice = 2;
    }
    @FXML
    void setMap3(ActionEvent event) {
        mapLabel.setText("Map 3");
        mapChoice = 3;
    }


    @FXML
    public void goToPlayerSelection(ActionEvent event) {

        try {
            Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player1Screen.fxml"));
            stage.setScene(new Scene(screen1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
