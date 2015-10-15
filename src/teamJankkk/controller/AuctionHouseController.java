package teamJankkk.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;

/**
 * Created by KRose on 10/15/15.
 */
public class AuctionHouseController extends Main implements Initializable{

    @FXML
    private TextField buySmithore, sellSmithore, buyEnergy, sellEnergy,
        buyFood, sellFood;

    @FXML
    private Button goButton, cancelButton;

    @FXML Label smithoreLabelPlayer, smithoreLabelMarket, energyLabelPlayer,
        energyLabelMarket, foodLabelPlayer, foodLabelMarket, moneyLabelPlayer,
        moneyLabelMarket;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
