package teamJankkk.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import teamJankkk.model.Game;
import teamJankkk.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

public class PlayerSelect extends Main implements Initializable{

    Game game;
    @FXML private TextField nameTextField1;
    @FXML private Button nextButton;
    @FXML private Button saveButton1;
    @FXML private Button exitButton2;
    @FXML private ChoiceBox<String> raceChoiceBox1;
    @FXML private ChoiceBox<String> colorChoiceBox1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //saveButton1.setOnAction(this::saveName);
        nextButton.setOnAction(this::goToMap1);
        exitButton2.setOnAction(this::exitApp);
    }

    public void passGame(Game game) {
        this.game = game;
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
    public void goToMap1(ActionEvent event) {
        try {
            String name = nameTextField1.getText();
            String race = raceChoiceBox1.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox1.getSelectionModel().getSelectedItem();
            if(name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
                game.createPlayer(name, race, color, 1);
                game.setNumberOfPlayers(1);
//                game.setRace(race, 1);
//                game.setColor(color, 1);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
                Pane gameSumPane = (Pane) loader.load();
                Map1Controller controller = loader.<Map1Controller>getController();
                controller.passGame(game);
//                Pane gameSumPane = (Pane) FXMLLoader.load(getClass().getResource("../views/GameSummary.fxml"));
                stage.setScene(new Scene(gameSumPane));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    public void goToMap1(ActionEvent event) {
//
//
//        try {
//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Player1Screen.fxml"));
//            Pane screen1 = (Pane) loader.load();
//            Map1Controller controller1 = loader.<Map1Controller>getController();
//            controller1.passGame(game);
////                Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player1Screen.fxml"));
//            stage.setScene(new Scene(screen1));
//            stage.show();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    @FXML
    public void exitApp(ActionEvent event) {
        Stage stage = (Stage) exitButton2.getScene().getWindow();
        stage.close();
    }
}
