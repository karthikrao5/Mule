package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by KRose on 9/23/15.
 */
public class StoreController extends Main implements Initializable {

    @FXML
    private ImageView thePub, muleStore, smithoreTile, energyTile, foodTile;

    @FXML
    private Label moneyLabel, goBackLabel, playerLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thePub.setOnMouseClicked(this::thePubClicked);
        muleStore.setOnMouseClicked(this::muleStoreClicked);
        smithoreTile.setOnMouseClicked((this::smithOreClicked));
        energyTile.setOnMouseClicked((this::energyTileClicked));
        foodTile.setOnMouseClicked(this::foodTileClicked);
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

    @FXML
    public void thePubClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
        try {
            Pane screen3 = (Pane) FXMLLoader.load(getClass().getResource("../views/ThePub.fxml"));
            stage.setScene(new Scene(screen3));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void muleStoreClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

    @FXML
    public void smithOreClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

    @FXML
    public void energyTileClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

    @FXML
    public void foodTileClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

}
