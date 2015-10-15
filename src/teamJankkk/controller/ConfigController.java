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
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;


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
    private static int players = 0;
    private int howhard = 0;
    private int mapChoice = 0;

    @FXML private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startButton.setOnAction(this::goToPlayerSelection);
        PlayerDB.createDB();
    }


    @FXML
    void setPlayers1(ActionEvent event) {
        playerLabel.setText("1 players");
        Game.setNumberOfPlayers(1);
        players = 1;

    }
    @FXML
    void setPlayers2(ActionEvent event) {
        playerLabel.setText("2 players");
        Game.setNumberOfPlayers(2);
        System.out.println("config screen: " + Game.getNumberOfPlayers());
        players = 2;

    }
    @FXML
    void setPlayers3(ActionEvent event) {
        playerLabel.setText("3 players");
        Game.setNumberOfPlayers(3);
        players = 3;

    }
    @FXML
    void setPlayers4(ActionEvent event) {
        playerLabel.setText("4 players");
        Game.setNumberOfPlayers(4);
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
            // at button, check if playerdb.player # = 3 for example, then skip to game Summary window
            // also, take out save button func and put it in next - also throw error when player does not fill out all fields
            if (players == 1) {
                Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player1Screen.fxml"));
                stage.setScene(new Scene(screen1));
                stage.show();
            } else if (players == 2) {
                Pane screen2 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player2Select.fxml"));
                stage.setScene(new Scene(screen2));
                stage.show();
            } else if (players == 3) {
                Pane screen3 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player3Screen.fxml"));
                stage.setScene(new Scene(screen3));
                stage.show();
            } else {
                Pane screen4 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player4Select.fxml"));
                stage.setScene(new Scene(screen4));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getPlayerCount() {
        return players;
    }

}
