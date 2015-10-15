package teamJankkk.controller;

<<<<<<< HEAD
=======
import javafx.event.ActionEvent;
>>>>>>> d746897666fd58da092d2ae549d5b548100047bb
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;
=======
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import teamJankkk.Main;
import javafx.fxml.Initializable;
>>>>>>> d746897666fd58da092d2ae549d5b548100047bb

/**
 * Created by KRose on 10/15/15.
 */
<<<<<<< HEAD
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
=======
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

    @FXML private Button goButton;
    @FXML private Button cancelButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        //buyButton.setOnAction(this::buy);
        goButton.setOnAction(this::goLogic);
        cancelButton.setOnAction(this::goBackToStore);
        System.out.println(PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney());
        moneyLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney()));
        foodLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getFood()));
        smithoreLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getSmithore()));
        energyLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getEnergy()));
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
            int howMuchTheyHave = PlayerDB.getPlayer(Game.getCurrentPlayer()).getSmithore();
            int theyGotDosh = PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney();
            int theyWannaBuy = Integer.parseInt(buySmithore.getText());
            if (theyWannaBuy > theyGotDosh) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractSmithore(theyWannaBuy);
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractMoney(theyWannaBuy);
            }
        }
        if (buyFood.getText().length() > 0) {
            int howMuchTheyHave = PlayerDB.getPlayer(Game.getCurrentPlayer()).getFood();
            int theyWannaBuy = Integer.parseInt(buyFood.getText());
            int theyGotDosh = PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney();
            if (theyWannaBuy > theyGotDosh) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractFood(theyWannaBuy);
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractMoney(theyWannaBuy);
            }
        }
        if (buyEnergy.getText().length() > 0) {
            int howMuchTheyHave = PlayerDB.getPlayer(Game.getCurrentPlayer()).getEnergy();
            int theyWannaBuy = Integer.parseInt(buyEnergy.getText());
            int theyGotDosh = PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney();
            if (theyWannaBuy > theyGotDosh) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("Negative Money not allowed!");
                alert.setContentText("You cannot buy more than you can afford");
                alert.showAndWait();
            } else {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractEnergy(theyWannaBuy);
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractMoney(theyWannaBuy);
            }
        }
        if (sellSmithore.getText().length() > 0) {
            int howMuchTheyHave = PlayerDB.getPlayer(Game.getCurrentPlayer()).getSmithore();
            int theyWannaSell = Integer.parseInt(sellSmithore.getText());
            if (theyWannaSell > howMuchTheyHave) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractSmithore(theyWannaSell);
                PlayerDB.getPlayer(Game.getCurrentPlayer()).addMoney(theyWannaSell);
            }
        }
        if (sellFood.getText().length() > 0) {
            int howMuchTheyHave = PlayerDB.getPlayer(Game.getCurrentPlayer()).getFood();
            int theyWannaSell = Integer.parseInt(sellFood.getText());
            if (theyWannaSell > howMuchTheyHave) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractFood(theyWannaSell);
                PlayerDB.getPlayer(Game.getCurrentPlayer()).addMoney(theyWannaSell);
            }
        }
        if (sellEnergy.getText().length() > 0) {
            int howMuchTheyHave = PlayerDB.getPlayer(Game.getCurrentPlayer()).getEnergy();
            int theyWannaSell = Integer.parseInt(sellEnergy.getText());
            if (theyWannaSell > howMuchTheyHave) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Action Not Possible");
                alert.setHeaderText("No Negative Resources allowed!");
                alert.setContentText("You cannot sell more of this resouce than you have!");
                alert.showAndWait();
            } else {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractEnergy(theyWannaSell);
                PlayerDB.getPlayer(Game.getCurrentPlayer()).addMoney(theyWannaSell);
            }
        }
        updateLabels();
    }

    public void updateLabels() {
        moneyLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney()));
        foodLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getFood()));
        smithoreLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getSmithore()));
        energyLabelPlayer.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getEnergy()));
    }

>>>>>>> d746897666fd58da092d2ae549d5b548100047bb
}
