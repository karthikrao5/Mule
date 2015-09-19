package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;

public class ConfigController extends teamJankkk.Main{

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
    int mapChoice = 1;
    int players = 1;
    int howhard = 1;

    /*
    <Button fx:id="onePlayer" mnemonicParsing="false" onAction="#setPlayers1" prefHeight="30.0" prefWidth="200.0" text="1" />
    <Button fx:id="twoPlayer" layoutX="10.0" layoutY="44.0" mnemonicParsing="false" onAction="#setPlayers2" prefWidth="200.0" text="2" />
    <Button fx:id="threePlayer" layoutX="10.0" layoutY="70.0" mnemonicParsing="false" onAction="#setPlayers3" prefWidth="200.0" text="3" />
    <Button fx:id="fourPlayer" layoutX="10.0" layoutY="96.0" mnemonicParsing="false" onAction="#setPlayers4" prefHeight="30.0" prefWidth="200.0" text="4" />*/
    //<Label fx:id="playerLabel" alignment="CENTER" layoutX="210.0" layoutY="10.0" prefHeight="40.0" prefWidth="200.0" text="1 Player" textAlignment="CENTER">


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
    public void startButton(ActionEvent event) throws IOException {
        Parent screen1 = FXMLLoader.load(getClass().getResource("../views/PlayerSelect.fxml"));
        stage.setScene(new Scene(screen1));
        stage.show();
    }
}
