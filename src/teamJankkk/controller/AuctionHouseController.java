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
    @FXML private TextField buySmithore;
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
//        System.out.println(game.getPlayer(game.getCurrentPlayer()).getMoney());
//        moneyLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getMoney()));
//        foodLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getFood()));
//        smithoreLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getSmithore()));
//        energyLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getEnergy()));
    }


    public void passGame(Game game) {
        this.game = game;
        updateLabels();
    }

    @FXML
    public void goBackToStore(ActionEvent actionEvent) {
        try {
            Pane backToMap = (Pane) FXMLLoader.load(getClass().getResource("../views/Map1_Forest.fxml"));
            stage.setScene(new Scene(backToMap));
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goLogic(ActionEvent actionEvent) {
        if (buySmithore.getText().length() > 0) {
            int howMuchTheyHave = game.getPlayer(game.getCurrentPlayer()).getSmithore();
            int theyGotDosh = game.getPlayer(game.getCurrentPlayer()).getMoney();
            int theyWannaBuy = Integer.parseInt(buySmithore.getText());
            if (theyWannaBuy > theyGotDosh) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                game.getPlayer(game.getCurrentPlayer()).addSmithore(theyWannaBuy);
                game.getPlayer(game.getCurrentPlayer()).subtractMoney(theyWannaBuy);
            }
        }
        if (buyFood.getText().length() > 0) {
            int howMuchTheyHave = game.getPlayer(game.getCurrentPlayer()).getFood();
            int theyWannaBuy = Integer.parseInt(buyFood.getText());
            int theyGotDosh = game.getPlayer(game.getCurrentPlayer()).getMoney();
            if (theyWannaBuy > theyGotDosh) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                game.getPlayer(game.getCurrentPlayer()).addFood(theyWannaBuy);
                game.getPlayer(game.getCurrentPlayer()).subtractMoney(theyWannaBuy);
            }
        }
        if (buyEnergy.getText().length() > 0) {
            int howMuchTheyHave = game.getPlayer(game.getCurrentPlayer()).getEnergy();
            int theyWannaBuy = Integer.parseInt(buyEnergy.getText());
            int theyGotDosh = game.getPlayer(game.getCurrentPlayer()).getMoney();
            if (theyWannaBuy > theyGotDosh) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                game.getPlayer(game.getCurrentPlayer()).addEnergy(theyWannaBuy);
                game.getPlayer(game.getCurrentPlayer()).subtractMoney(theyWannaBuy);
            }
        }
        if (sellSmithore.getText().length() > 0) {
            int howMuchTheyHave = game.getPlayer(game.getCurrentPlayer()).getSmithore();
            int theyWannaSell = Integer.parseInt(sellSmithore.getText());
            if (theyWannaSell > howMuchTheyHave) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                game.getPlayer(game.getCurrentPlayer()).subtractSmithore(theyWannaSell);
                game.getPlayer(game.getCurrentPlayer()).addMoney(theyWannaSell);
            }
        }
        if (sellFood.getText().length() > 0) {
            int howMuchTheyHave = game.getPlayer(game.getCurrentPlayer()).getFood();
            int theyWannaSell = Integer.parseInt(sellFood.getText());
            if (theyWannaSell > howMuchTheyHave) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                game.getPlayer(game.getCurrentPlayer()).subtractFood(theyWannaSell);
                game.getPlayer(game.getCurrentPlayer()).addMoney(theyWannaSell);
            }
        }
        if (sellEnergy.getText().length() > 0) {
            int howMuchTheyHave = game.getPlayer(game.getCurrentPlayer()).getEnergy();
            int theyWannaSell = Integer.parseInt(sellEnergy.getText());
            if (theyWannaSell > howMuchTheyHave) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                game.getPlayer(game.getCurrentPlayer()).subtractEnergy(theyWannaSell);
                game.getPlayer(game.getCurrentPlayer()).addMoney(theyWannaSell);
            }
        }
        updateLabels();
        calculateMarket();
    }

    public void updateLabels() {
        calculateMarket();
        System.out.println(game.getPlayer(game.getCurrentPlayer()).getMoney());
        moneyLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getMoney()));
        foodLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getFood()));
        smithoreLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getSmithore()));
        energyLabelPlayer.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getEnergy()));
    }

    public void calculateMarket() {
        int smithTotal = 0;
        int energTotal = 0;
        int foodTotal = 0;
        int GDP = 0;
        for (int thisPlayer = 1; thisPlayer <= game.getNumberOfPlayers(); thisPlayer++) {
            smithTotal = smithTotal + game.getPlayer(thisPlayer).getSmithore();
            energTotal = energTotal + game.getPlayer(thisPlayer).getEnergy();
            foodTotal = foodTotal + game.getPlayer(thisPlayer).getFood();
            GDP = GDP + game.getPlayer(thisPlayer).getMoney();
        }
        smithoreLabelMarket.setText(String.valueOf(smithTotal));
        energyLabelMarket.setText(String.valueOf(energTotal));
        foodLabelMarket.setText(String.valueOf(foodTotal));
        moneyLabelMarket.setText(String.valueOf(GDP));
    }
}
