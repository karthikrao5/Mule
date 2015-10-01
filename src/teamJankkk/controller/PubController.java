package teamJankkk.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import teamJankkk.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by KRose on 10/1/15.
 */
public class PubController extends Main implements Initializable {

    @FXML


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void pubClicked(MouseEvent event) {
        System.out.println("Enter Pub");

    }

    @FXML
    public void goBackToMap() {
        try {
            Pane backToMap = (Pane) FXMLLoader.load(getClass().getResource("../views/Map1_Forest.fxml"));
            stage.setScene(new Scene(backToMap));
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
