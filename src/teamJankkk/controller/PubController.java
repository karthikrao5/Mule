package teamJankkk.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;

import java.util.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by KRose on 10/1/15.
 */
public class PubController extends Main implements Initializable {

    Game game;

    @FXML
    private ImageView gambleView;

    @FXML
    private Label winningsLabel, goBackLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gambleView.setOnMouseClicked(this::gambleButtonClicked);
    }

    public void passGame(Game game) {
        this.game = game;
    }

    @FXML
    public void gambleButtonClicked(MouseEvent event) {
        // need to use random class for gambling
        Random rand = new Random();
        int randomNum = rand.nextInt(1000) - 500;
        int finRand = randomNum;
        winningsLabel.setText(Integer.toString(finRand));
//        System.out.println("Player # is: " + Game.getCurrentPlayer());
//        System.out.print(" and bitchfuck " + PlayerDB.getPlayer(Game.getCurrentPlayer()));
//        PlayerDB.getPlayer(Game.getCurrentPlayer()).addMoney(randomNum);
//        Game.nextTurn();
        // check global val for player turn, add to this player
    }

    @FXML
    public void goBackToStore() {
        try {
            Pane backToStore = (Pane) FXMLLoader.load(getClass().getResource("../views/TheStore.fxml"));
            stage.setScene(new Scene(backToStore));
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
