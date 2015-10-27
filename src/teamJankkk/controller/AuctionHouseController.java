package teamJankkk.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import teamJankkk.Main;
import teamJankkk.model.Game;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import teamJankkk.Main;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import teamJankkk.Main;
import javafx.fxml.Initializable;
/**
 * Created by KRose on 10/15/15.
 */

public class AuctionHouseController extends Main implements Initializable {
    @FXML private TextField smithoreTextField;
    @FXML private TextField buyEnergy;
    @FXML private TextField buyFood;

    @FXML private TextField sellSmithore;
    @FXML private TextField sellEnergy;
    @FXML private TextField sellFood;

    @FXML private Label moneyLabelPlayer;
    @FXML private Label foodLabelPlayer;
    @FXML private Label smithoreLabelPlayer;
    @FXML private Label energyLabelPlayer;
    @FXML private Label smithoreLabelMarket;
    @FXML private Label energyLabelMarket;
    @FXML private Label foodLabelMarket;
    @FXML private Label moneyLabelMarket;

    @FXML private Button goButton;
    @FXML private Button cancelButton;
    Game game;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        //buyButton.setOnAction(this::buy);
//        passGame(game);
//        calculateMarket();
        goButton.setOnAction(this::goLogic);
        cancelButton.setOnAction(this::goBackToStore);
//        System.out.println(game.getMoney());
//        moneyLabelPlayer.setText(String.valueOf(game.getMoney()));
//        foodLabelPlayer.setText(String.valueOf(game.getFood()));
//        smithoreLabelPlayer.setText(String.valueOf(game.getSmithore()));
//        energyLabelPlayer.setText(String.valueOf(game.getEnergy()));
    }


    public void passGame(Game game) {
        this.game = game;
        updateLabels();
    }

    @FXML
    public void goBackToStore(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
            Pane backToMap = (Pane) loader.load();
            Map1Controller controller = loader.<Map1Controller>getController();
            controller.passGame(game);
//            Pane backToMap = (Pane) FXMLLoader.load(getClass().getResource("../views/Map1_Forest.fxml"));
            stage.setScene(new Scene(backToMap));
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    int currentResourceAmount;
    int currentMoney;
    int amountToBuy;
    
    @FXML
    public void goLogic(ActionEvent actionEvent) {
        currentResourceAmount = 0;
        currentMoney = 0;
        amountToBuy = 0;
        
        if (smithoreTextField.getText().length() > 0) {
            
            currentResourceAmount = game.getSmithore();
            currentMoney = game.getMoney();
            amountToBuy = Integer.parseInt(smithoreTextField.getText());
            if (amountToBuy > currentMoney) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                game.addSmithore(amountToBuy);
                game.subtractMoney(amountToBuy);
            }
        }
        if (buyFood.getText().length() > 0) {
            currentResourceAmount = game.getFood();
            amountToBuy = Integer.parseInt(buyFood.getText());
            currentMoney = game.getMoney();
            if (amountToBuy > currentMoney) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                game.addFood(amountToBuy);
                game.subtractMoney(amountToBuy);
            }
        }
        if (buyEnergy.getText().length() > 0) {
            currentResourceAmount = game.getEnergy();
            amountToBuy = Integer.parseInt(buyEnergy.getText());
            currentMoney = game.getMoney();
            if (amountToBuy > currentMoney) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                game.addEnergy(amountToBuy);
                game.subtractMoney(amountToBuy);
            }
        }
        if (sellSmithore.getText().length() > 0) {
            currentResourceAmount = game.getSmithore();
            int theyWannaSell = Integer.parseInt(sellSmithore.getText());
            if (theyWannaSell > currentResourceAmount) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                game.subtractSmithore(theyWannaSell);
                game.addMoney(theyWannaSell);
            }
        }
        if (sellFood.getText().length() > 0) {
            currentResourceAmount = game.getFood();
            int theyWannaSell = Integer.parseInt(sellFood.getText());
            if (theyWannaSell > currentResourceAmount) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                game.subtractFood(theyWannaSell);
                game.addMoney(theyWannaSell);
            }
        }
        if (sellEnergy.getText().length() > 0) {
            currentResourceAmount = game.getEnergy();
            int theyWannaSell = Integer.parseInt(sellEnergy.getText());
            if (theyWannaSell > currentResourceAmount) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                game.subtractEnergy(theyWannaSell);
                game.addMoney(theyWannaSell);
            }
        }
        updateMarketAndLabels();
    }

    public void updateLabels() {
        System.out.println(game.getMoney());
        moneyLabelPlayer.setText(String.valueOf(game.getMoney()));
        foodLabelPlayer.setText(String.valueOf(game.getFood()));
        smithoreLabelPlayer.setText(String.valueOf(game.getSmithore()));
        energyLabelPlayer.setText(String.valueOf(game.getEnergy()));
    }

    public void updateMarketAndLabels() {
        ArrayList<Integer> market = game.calculateMarket();
        smithoreLabelMarket.setText(market.get(0).toString());
        energyLabelMarket.setText(market.get(1).toString());
        foodLabelMarket.setText(market.get(2).toString());
        moneyLabelMarket.setText(market.get(3).toString());
    }
}
