package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PlayerSelect extends teamJankkk.Main {

    @FXML private Button nameSave;
    @FXML private Button mechtron;
    @FXML private Button bonzoid;
    @FXML private Button flapper;
    @FXML private Button gollumer;
    @FXML private Button jankktron;
    @FXML private Button leggite;
    @FXML private Button packer;
    @FXML private Button spheroid;
    @FXML private Button humanoid;
    @FXML private Button red;
    @FXML private Button green;
    @FXML private Button blue;
    @FXML private Button yellow;
    @FXML private Button nameSave1;
    @FXML private Label playerLabel;
    @FXML private Label playerNameLabel;
    @FXML private Label playerNameLabel1;
    @FXML private Label playerNameLabel11;
    @FXML private TextField enterName;
    private int howManyPlayers = 0;
    private int playerCount = 4;
    private int difficulty = 0;


    @FXML
    void setRaceM(ActionEvent event) {
//        diffLabel.setText("Beginner");
//        difficulty = 1;
    }

    @FXML
    void setRaceG(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }

    @FXML
    void setRaceP(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setRaceJ(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setRaceL(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setRaceS(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setRaceH(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setRaceB(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setRaceF(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setColorR(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setColorB(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setColorG(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }
    @FXML
    void setColorY(ActionEvent event) {
        //diffLabel.setText("Beginner");
        //howhard = 1;
    }

    @FXML
    public void nextPlayer(ActionEvent event) throws IOException {
        Parent screen2 = FXMLLoader.load(getClass().getResource("../views/PlayerSelect2.fxml"));
        stage.setScene(new Scene(screen2));
        stage.show();
    }
}
