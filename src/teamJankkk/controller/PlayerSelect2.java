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
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PlayerSelect2 extends Main implements Initializable{

    Game game;

    @FXML private Button save2Button;
    @FXML private Button exitButton2;
    @FXML private ChoiceBox<String> raceChoiceBox2;
    @FXML private ChoiceBox<String> colorChoiceBox2;
    @FXML private TextField nameTextField2;
    @FXML private ChoiceBox<String> raceChoiceBox1;
    @FXML private ChoiceBox<String> colorChoiceBox1;
    @FXML private TextField nameTextField1;
    @FXML private Button nextButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        p2 = new Player(null, null, null);
        //save2Button.setOnAction(this::saveName);
        nextButton.setOnAction(this::goToMap1);
    }

    public void passGame(Game game) {
        this.game = game;
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


            if (name.equals(null)) {
                System.out.println("Player1 name is:" + name);
            }
            System.out.println("Player1 str length is" + name.length());
            System.out.println("Player2 name is:" + name2);

            if(name.length() == 0 || name.charAt(0) == (' ') || race == null || color == null
                    || name2.length() == 0 || name2.charAt(0) == (' ') || race2 == null || color2 == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Empty Field");
                alert.setHeaderText("One of the Fields has not been filled in.");
                alert.setContentText("Please fill in all text fields.");
                alert.showAndWait();
            } else if (name.equals(name2)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Matching names");
                alert.setHeaderText("Multiple players with the same name!");
                alert.setContentText("Please select different names for each player.");
                alert.showAndWait();
            } else {
                System.out.println("FIRST P COLOR: " + color);
                game.createPlayer(name, race, color, 1);
                game.createPlayer(name2, race2, color2, 2);
                System.out.println("SECOND P COLOR: " + color2);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
                Pane screen1 = (Pane) loader.load();
                Map1Controller controller1 = loader.<Map1Controller>getController();
                controller1.passGame(game);
                stage.setScene(new Scene(screen1));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp(ActionEvent event) {
        Stage stage = (Stage) exitButton2.getScene().getWindow();
        stage.close();
    }
}
