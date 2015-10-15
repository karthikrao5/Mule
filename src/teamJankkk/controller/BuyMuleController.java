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
    @FXML
    private Button buyButton;
    //@FXML private TextField nameTextField1;
    //name label 21 holds Mule Count for that player
    @FXML private Label nameLabel21, nameLabel1;
    @FXML private ChoiceBox<String> outfitChoiceBox;
    int onThisScreenHowManyDidYouBuy = 0;
    public static boolean hasMule;
    public static String outfitString;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        buyButton.setOnAction(this::buy);
        nameLabel21.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).howManyMules()));
        nameLabel1.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney()));
        hasMule = false;
        outfitString = "";
    }

    @FXML
    public void buy(ActionEvent event) {
        Player thisPlayer = PlayerDB.getPlayer(Game.getCurrentPlayer());
        int howMuchTheyGot = thisPlayer.getMoney();
        if (outfitChoiceBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.initOwner(ConfigController.);
            alert.setTitle("No Outfit!");
            alert.setHeaderText("No outfit selected for Mule!");
            alert.setContentText("Please select outfit for Mule!");
            alert.showAndWait();
        } else {
            if (howMuchTheyGot >= 100) {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractMoney(100);
                onThisScreenHowManyDidYouBuy++;
                updateLabel();
                hasMule = true;
                outfitString = outfitChoiceBox.getValue();
                //Mule newMule = new Mule(outfitChoiceBox.getValue());
                Pane gameSumPane = null;
                try {
                    gameSumPane = (Pane) FXMLLoader.load(getClass().getResource("../views/Map1_Forest.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(new Scene(gameSumPane));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(ConfigController.);
                alert.setTitle("Not Enough Dosh");
                alert.setHeaderText("Need more Dosh");
                alert.setContentText("You need more Dosh to buy a MULE.");
                alert.showAndWait();
            }
        }
    }

    public void updateLabel() {
        nameLabel21.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).howManyMules()+onThisScreenHowManyDidYouBuy));
        nameLabel1.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney()));
    }
}
