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
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PlayerSelect3 extends Main implements Initializable {

    @FXML private TextField nameTextField3;
    @FXML private Button next3Button;
    @FXML private Button save3Button;
    @FXML private Button exitButton3;
    @FXML private ChoiceBox<String> raceChoiceBox3;
    @FXML private ChoiceBox<String> colorChoiceBox3;
//    @FXML private ObservableList<String> raceCBData =
//            FXCollections.observableArrayList();

//    public static teamJankkk.model.Player p3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        next3Button.setOnAction(this::nextScreen);
    }

    /*
    @FXML
    void saveName(ActionEvent event) {
        String name = nameTextField3.getText();
        String race = raceChoiceBox3.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox3.getSelectionModel().getSelectedItem();
        configLabel3.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        PlayerDB.createPlayer(name, 2);
        PlayerDB.setRace(race, 2);
        PlayerDB.setColor(color, 2);
        configLabel3.setText(PlayerDB.toString(2));
    }
    */

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            String name = nameTextField3.getText();
            String race = raceChoiceBox3.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox3.getSelectionModel().getSelectedItem();
            if (name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
<<<<<<< HEAD
                PlayerDB.createPlayer(name, 2);
                PlayerDB.setRace(race, 2);
                PlayerDB.setColor(color, 2);
=======
                configLabel3.setText("What up boss, your name is "
                        + name
                        + " , your race is: " + race
                        + " and you'll be playing for the " + color);

                PlayerDB.createPlayer(name, 3);
                PlayerDB.setRace(race, 3);
                PlayerDB.setColor(color, 3);
                configLabel3.setText(PlayerDB.toString(3));

>>>>>>> d038c28f2c7ad19bd5b6654e8152705e2f28b11e
                if (ConfigController.getPlayerCount() > 3) {
                    Pane screen4 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player4Select.fxml"));
                    stage.setScene(new Scene(screen4));
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
        Stage stage = (Stage) exitButton3.getScene().getWindow();
        stage.close();
    }
}
