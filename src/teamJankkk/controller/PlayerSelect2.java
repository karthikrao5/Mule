package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PlayerSelect2 extends Main implements Initializable{

    @FXML private TextField nameTextField2;
    @FXML private Label configLabel2;
    @FXML private Button next2Button;
    @FXML private Button save2Button;
    @FXML private ChoiceBox<String> raceChoiceBox2;
    @FXML private ChoiceBox<String> colorChoiceBox2;
//    @FXML private ObservableList<String> raceCBData =
//            FXCollections.observableArrayList();

    public static teamJankkk.model.Player p2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p2 = new Player(null, null, null);
        save2Button.setOnAction(this::saveName);
        next2Button.setOnAction(this::nextScreen);
    }

    @FXML
    void saveName(ActionEvent event) {
        System.out.print("Hello");
        String name = nameTextField2.getText();
        String race = raceChoiceBox2.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox2.getSelectionModel().getSelectedItem();
        configLabel2.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        p2.setName(name);
        p2.setRace(race);
        p2.setColor(color);

        configLabel2.setText(p2.getName() + p2.getRace() + p2.getColor());

    }

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            Pane screen3 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player3Screen.fxml"));
            stage.setScene(new Scene(screen3));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
