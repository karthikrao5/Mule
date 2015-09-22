package teamJankkk.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import teamJankkk.model.Player;
import teamJankkk.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerSelect extends Main implements Initializable{

    @FXML private TextField nameTextField;
    @FXML private Label configLabel;
    @FXML private Button nextButton;
    @FXML private Button saveButton;
    @FXML private ChoiceBox<String> raceChoiceBox;
    @FXML private ObservableList<String> raceCBData =
            FXCollections.observableArrayList();

    public teamJankkk.model.Player p1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configLabel.setText("This is my new Text");
        saveButton.setOnAction(this::saveName);
        nextButton.setOnAction(this::nextScreen);

    }

    @FXML
    void saveName(ActionEvent event) {
//        System.out.print("Hello");
        configLabel.setText(nameTextField.getText());
    }

    @FXML
    void raceChoiceBox(ActionEvent event) {

    }



//    @FXML
//    void setRaceM(ActionEvent event) {
//        p1.setRace("Mechatron");
//        configLabel.setText("Selected Mechatron");
//    }
//    @FXML
//    void setRaceG(ActionEvent event) {
//        p1.setRace("Gollumer");
//    }
//    @FXML
//    void setRaceP(ActionEvent event) {
//        p1.setRace("Packer");
//    }
//    @FXML
//    void setRaceJ(ActionEvent event) {
//        p1.setRace("Jankktron");
//    }
//    @FXML
//    void setRaceL(ActionEvent event) {
//        p1.setRace("Leggite");
//    }
//    @FXML
//    void setRaceS(ActionEvent event) {
//        p1.setRace("Spheroid");
//    }
//    @FXML
//    void setRaceH(ActionEvent event) {
//        p1.setRace("Humanoid");
//    }
//    @FXML
//    void setRaceB(ActionEvent event) {
//        p1.setRace("Bonzoid");
//    }
//    @FXML
//    void setRaceF(ActionEvent event) {
//        p1.setRace("Flapper");
//    }
//    @FXML
//    void setColorR(ActionEvent event) {
//        p1.setColor("Red");
//    }
//    @FXML
//    void setColorB(ActionEvent event) {
//        p1.setColor("Blue");
//    }
//    @FXML
//    void setColorG(ActionEvent event) {
//        p1.setColor("Green");
//    }
//    @FXML
//    void setColorY(ActionEvent event) {
//        p1.setColor("Yellow");
//    }

    @FXML
    public void nextScreen(ActionEvent event) {
        try {
            Pane screen1 = (Pane) FXMLLoader.load(getClass().getResource("../views/PlayerSelect2.fxml"));
            stage.setScene(new Scene(screen1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
