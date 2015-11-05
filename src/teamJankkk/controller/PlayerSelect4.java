package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import teamJankkk.Main;
import teamJankkk.model.Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by karthik on 9/18/15.
 */
public class PlayerSelect4 extends Main implements Initializable {


    Game game;

    @FXML private Button goToSummaryButton;
    @FXML private Button save4Button;
    @FXML private Button exitButton4;
    @FXML private ChoiceBox<String> raceChoiceBox4;
    @FXML private ChoiceBox<String> colorChoiceBox4;
    @FXML private TextField nameTextField4;
    @FXML private ChoiceBox<String> raceChoiceBox3;
    @FXML private ChoiceBox<String> colorChoiceBox3;
    @FXML private TextField nameTextField3;
    @FXML private ChoiceBox<String> raceChoiceBox2;
    @FXML private ChoiceBox<String> colorChoiceBox2;
    @FXML private TextField nameTextField2;
    @FXML private ChoiceBox<String> raceChoiceBox1;
    @FXML private ChoiceBox<String> colorChoiceBox1;
    @FXML private TextField nameTextField1;
    @FXML private Button nextButton;

    //public static teamJankkk.model.Player p4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        p4 = new Player(null, null, null);
        //save4Button.setOnAction(this::saveName);
        nextButton.setOnAction(this::goToMap1);
    }

    public void passGame(Game game) {
        this.game = game;
    }

    /*
    @FXML
    void saveName(ActionEvent event) {
        String name = nameTextField4.getText();
        String race = raceChoiceBox4.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox4.getSelectionModel().getSelectedItem();
        configLabel4.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        game.createPlayer(name, 3);
        game.setRace(race, 3);
        game.setColor(color, 3);
        configLabel4.setText(game.toString(3));

    }
    */

    @FXML
    public void goToMap1(ActionEvent event) {
        try {
            String name = nameTextField1.getText();
            String race = raceChoiceBox1.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox1.getSelectionModel().getSelectedItem();
            String name2 = nameTextField2.getText();
            String race2 = raceChoiceBox2.getSelectionModel().getSelectedItem();
            String color2 = colorChoiceBox2.getSelectionModel().getSelectedItem();
            String name3 = nameTextField3.getText();
            String race3 = raceChoiceBox3.getSelectionModel().getSelectedItem();
            String color3 = colorChoiceBox3.getSelectionModel().getSelectedItem();
            String name4 = nameTextField4.getText();
            String race4 = raceChoiceBox4.getSelectionModel().getSelectedItem();
            String color4 = colorChoiceBox4.getSelectionModel().getSelectedItem();
            if(name.length() == 0 || name.charAt(0) == (' ') || race == null || color == null
                    || name2.length() == 0 || name2.charAt(0) == (' ') || race2 == null || color2 == null
                    || name3.length() == 0 || name3.charAt(0) == (' ') || race3 == null || color3 == null
                    || name4.length() == 0 || name4.charAt(0) == (' ') || race4 == null || color4 == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else if (name.equals(name2) || name2.equals(name3) || name.equals(name3)
                    || name.equals(name4) || name2.equals(name4) || name3.equals(name4)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Matching names");
                alert.setHeaderText("Multiple players with the same name!");
                alert.setContentText("Please select different names for each player.");
                alert.showAndWait();
            } else {
                game.createPlayer(name, race, color, 1);
                game.setNumberOfPlayers(4);

//                game.setRace(race, 1);
//                game.setColor(color, 1);
                game.createPlayer(name2, race2, color2, 2);
//                game.setRace(race2, 2);
//                game.setColor(color2, 2);
                game.createPlayer(name3, race3, color3, 3);
//                game.setRace(race3, 3);
//                game.setColor(color3, 3);
                game.createPlayer(name4, race4, color4, 4);
//                game.setRace(race4, 4);
//                game.setColor(color4, 4);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
                Pane screen1 = (Pane) loader.load();
                Map1Controller controller1 = loader.<Map1Controller>getController();
                controller1.passGame(game);
//                Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player1Screen.fxml"));
                stage.setScene(new Scene(screen1));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp(ActionEvent event) {
        Stage stage = (Stage) exitButton4.getScene().getWindow();
        stage.close();
    }
}
