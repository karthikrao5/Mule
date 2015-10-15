package teamJankkk.controller;
import javafx.scene.control.Alert;
import teamJankkk.Main;
import teamJankkk.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;

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
    @FXML private Label nameLabel21;
    int onThisScreenHowManyDidYouBuy = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        buyButton.setOnAction(this::buy);
        nameLabel21.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).howManyMules()));
    }

    @FXML
    public void buy(ActionEvent event) {
        Player thisPlayer = PlayerDB.getPlayer(Game.getCurrentPlayer());
        int howMuchTheyGot = thisPlayer.getMoney();
        if (howMuchTheyGot >= 100) {
            PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractMoney(100);
            onThisScreenHowManyDidYouBuy++;
            updateLabel();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.initOwner(ConfigController.);
            alert.setTitle("Not Enough Dosh");
            alert.setHeaderText("Need more Dosh");
            alert.setContentText("You need more Dosh to buy a MULE.");
            alert.showAndWait();
        }
    }

    public void updateLabel() {
        nameLabel21.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).howManyMules()+onThisScreenHowManyDidYouBuy));
    }
}
