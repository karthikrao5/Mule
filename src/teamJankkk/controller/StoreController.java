package teamJankkk.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import teamJankkk.Main;

import java.awt.*;
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

    }

    public void goBackToMap() {

    }
}
