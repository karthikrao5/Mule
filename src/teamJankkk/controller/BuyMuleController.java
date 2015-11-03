package teamJankkk.controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.Mule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by KRose on 10/14/15.
 */
public class BuyMuleController extends Main implements Initializable {

    Game game;
    @FXML private Button buyButton;
    //@FXML private TextField nameTextField1;
    //name label 21 holds Mule Count for that player
    @FXML private Label nameLabel21, nameLabel1, backLabel, moneyLabel, muleLabel, nameLabel;
    @FXML private ChoiceBox<String> outfitChoiceBox;
    int onThisScreenHowManyDidYouBuy = 0;
    public static boolean hasMule;
    public static String outfitString;

    public void passGame(Game game) {
        this.game = game;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buyButton.setOnAction(this::buy);
        //outfitChoiceBox.setOnAction(this::choiceBoxClicked);
//        nameLabel21.setText(String.valueOf(game.getMuleCount()));
//        nameLabel1.setText(String.valueOf(game.getMoney()));
        hasMule = false;
        outfitString = "";
        updateLabel();
    }

    @FXML
    public void backToMap() {
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

    @FXML
    public void buy(ActionEvent event) {
        updateLabel();
        int currPlayerMoney = game.getMoney();
        if (outfitChoiceBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.initOwner(ConfigController.);
            alert.setTitle("No Outfit!");
            alert.setHeaderText("No outfit selected for Mule!");
            alert.setContentText("Please select outfit for Mule!");
            alert.showAndWait();
        } else {
            if (currPlayerMoney >= 100) {
                game.subtractMoney(100);
                onThisScreenHowManyDidYouBuy++;
                outfitString = outfitChoiceBox.getValue();
                game.buyMule(outfitString);
                //game.getCurrentPlayer().setIsBoughtMule(true);
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
                    Pane backToMap = (Pane) loader.load();
                    Map1Controller controller = loader.<Map1Controller>getController();
                    controller.passGame(game);
                    stage.setScene(new Scene(backToMap));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Not Enough Dosh");
                alert.setHeaderText("Need more Dosh");
                alert.setContentText("You need more Dosh to buy a MULE.");
                alert.showAndWait();
            }
        }
        updateLabel();
    }

    public void updateLabel() {
//        nameLabel21.setText(String.valueOf(game.getMuleCount()+onThisScreenHowManyDidYouBuy));
        if (game != null) {
            moneyLabel.setText(String.valueOf(game.getMoney()));
            muleLabel.setText(String.valueOf(game.getCurrentPlayer().howManyMules()));
            nameLabel.setText(String.valueOf(game.getCurrentPlayer().getName()));
        }
    }


}
