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
import javafx.stage.Stage;
import sun.font.BidiUtils;
import teamJankkk.Main;
import teamJankkk.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by karthik on 9/18/15.
 */
public class PlayerSelect4 extends Main implements Initializable {

    @FXML private TextField nameTextField4;
    @FXML private Label configLabel4;
//    @FXML private Button next4Button;
    @FXML private Button save4Button;
    @FXML private Button exitButton4;
    @FXML private ChoiceBox<String> raceChoiceBox4;
    @FXML private ChoiceBox<String> colorChoiceBox4;
//    @FXML private ObservableList<String> raceCBData =
//      FXCollections.observableArrayList();
    public static teamJankkk.model.Player p4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p4 = new Player(null, null, null);
        save4Button.setOnAction(this::saveName);
//        next4Button.setOnAction(this::nextScreen);
    }

    @FXML
    void saveName(ActionEvent event) {
        String name = nameTextField4.getText();
        String race = raceChoiceBox4.getSelectionModel().getSelectedItem();
        String color = colorChoiceBox4.getSelectionModel().getSelectedItem();
        configLabel4.setText("What up boss, your name is "
                + name
                + " , your race is: " + race
                + " and you'll be playing for the " + color);

        p4.setName(name);
        p4.setRace(race);
        p4.setColor(color);

        configLabel4.setText(p4.getName() + p4.getRace() + p4.getColor());

    }

//    @FXML
//    public void nextScreen(ActionEvent event) {
//        try {
//            Pane screen5 = (Pane) FXMLLoader.load(getClass().getResource("../views/Player4Screen.fxml"));
//            stage.setScene(new Scene(screen5));
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
@FXML
public void exitApp(ActionEvent event) {
    Stage stage = (Stage) exitButton4.getScene().getWindow();
    stage.close();
}
}
