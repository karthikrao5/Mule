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
import teamJankkk.model.Game;
import teamJankkk.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PlayerSelect3 extends Main implements Initializable {

    Game game;

    @FXML private Button save3Button;
    @FXML private Button exitButton3;
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

//    @FXML private ObservableList<String> raceCBData =
//            FXCollections.observableArrayList();

//    public static teamJankkk.model.Player p3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        nextButton.setOnAction(this::goToMap1);
    }

    public void passGame(Game game) {
        this.game = game;
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

        game.createPlayer(name, 2);
        game.setRace(race, 2);
        game.setColor(color, 2);
        configLabel3.setText(game.toString(2));
    }
    */

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            String name = nameTextField3.getText();
            String race = raceChoiceBox3.getSelectionModel().getSelectedItem();
            String color = colorChoiceBox3.getSelectionModel().getSelectedItem();
            if(name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
                Pane gameSumPane = (Pane) FXMLLoader.load(getClass().getResource("../views/GameSummary.fxml"));
                stage.setScene(new Scene(gameSumPane));
                stage.show();
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
            if(name == null || race == null || color == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else {
//                game.createPlayer(name, 1);
                game.createPlayer(name, race, color, 1);
//                game.setRace(race, 1);
//                game.setColor(color, 1);

                game.createPlayer(name2, race2, color2, 2);
//                game.setRace(race2, 2);
//                game.setColor(color2, 2);

                game.createPlayer(name3, race3, color3, 3);
//                game.setRace(race3, 3);
//                game.setColor(color3, 3);


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
}
