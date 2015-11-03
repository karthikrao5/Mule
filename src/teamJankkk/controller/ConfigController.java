package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigController extends Main implements Initializable {


    Game game;
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
    @FXML private Button testButton;
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
        testButton.setOnAction(this::testSelection);
        game = new Game();
    }


    @FXML
    void setPlayers1(ActionEvent event) {
        playerLabel.setText("1 players");
        game.setNumberOfPlayers(1);
        players = 1;

    }
    @FXML
    void setPlayers2(ActionEvent event) {
        playerLabel.setText("2 players");
        game.setNumberOfPlayers(2);
        System.out.println("config screen: " + game.getNumberOfPlayers());
        players = 2;

    }
    @FXML
    void setPlayers3(ActionEvent event) {
        playerLabel.setText("3 players");
        game.setNumberOfPlayers(3);
        players = 3;

    }
    @FXML
    void setPlayers4(ActionEvent event) {
        playerLabel.setText("4 players");
        game.setNumberOfPlayers(4);
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
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../views/Player1Screen.fxml"));
                Pane screen1 = (Pane) loader1.load();
                PlayerSelect controller1 = loader1.<PlayerSelect>getController();
                controller1.passGame(game);
//                Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player1Screen.fxml"));
                stage.setScene(new Scene(screen1));
                stage.show();
            } else if (players == 2) {
                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../views/Player2Select.fxml"));
                Pane screen2 = (Pane) loader2.load();
                PlayerSelect2 controller2 = loader2.<PlayerSelect2>getController();
                controller2.passGame(game);
//                Pane screen2 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player2Select.fxml"));
                stage.setScene(new Scene(screen2));
                stage.show();
            } else if (players == 3) {
                FXMLLoader loader3 = new FXMLLoader(getClass().getResource("../views/Player3Screen.fxml"));
                Pane screen3 = (Pane) loader3.load();
                PlayerSelect3 controller3 = loader3.<PlayerSelect3>getController();
                controller3.passGame(game);
//                Pane screen3 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player3Screen.fxml"));
                stage.setScene(new Scene(screen3));
                stage.show();
            } else {
                FXMLLoader loader4 = new FXMLLoader(getClass().getResource("../views/Player4Select.fxml"));
                Pane screen4 = (Pane) loader4.load();
                PlayerSelect4 controller4 = loader4.<PlayerSelect4>getController();
                controller4.passGame(game);
//                Pane screen4 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player4Select.fxml"));
                stage.setScene(new Scene(screen4));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void testSelection(ActionEvent event) {

        try {
//            String name = nameTextField1.getText();
            String name = "player1";
            String color = "Blue";
            String race = "Jankktron";

            String name2 = "player2";
            String color2 = "Red";
            String race2 = "Packer";

            game.createPlayer(name, race, color, 1);
//                game.setRace(race, 1);
//                game.setColor(color, 1);
            game.createPlayer(name2, race2, color2, 2);
//                game.setRace(race2, 2);
//                game.setColor(color2, 2);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
            Pane screen1 = (Pane) loader.load();
            Map1Controller controller1 = loader.<Map1Controller>getController();
            controller1.passGame(game);
//                Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player1Screen.fxml"));
            stage.setScene(new Scene(screen1));
            stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static int getPlayerCount() {
        return players;
    }

}
