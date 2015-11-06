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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
                Pane gameSumPane = (Pane) loader.load();
                Map1Controller controller = loader.<Map1Controller>getController();
                controller.passGame(game);
                stage.setScene(new Scene(gameSumPane));
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
