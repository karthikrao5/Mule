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
    @FXML private Label nameLabel21, nameLabel1;
    @FXML private ChoiceBox<String> outfitChoiceBox;
    int onThisScreenHowManyDidYouBuy = 0;
    public static boolean hasMule;
    public static String outfitString;

    public void passGame(Game game) {
        this.game = game;
        updateLabel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //save3Button.setOnAction(this::saveName);
        buyButton.setOnAction(this::buy);
        hasMule = false;
        outfitString = "";
    }

    @FXML
    public void buy(ActionEvent event) {
        Player thisPlayer = game.getPlayer(game.getCurrentPlayer());
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
                game.getPlayer(game.getCurrentPlayer()).subtractMoney(100);
//                PlayerDB.getPlayer(Game.getCurrentPlayer()).subtractMoney(100);
                onThisScreenHowManyDidYouBuy++;
                updateLabel();
                hasMule = true;
                outfitString = outfitChoiceBox.getValue();
                Mule newMule = new Mule(outfitChoiceBox.getValue());
                game.justBoughtAMule(newMule);

                Pane gameSumPane = null;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Map1_Forest.fxml"));
                    Pane pubScreen = (Pane) loader.load();
                    Map1Controller controller86 = loader.<Map1Controller>getController();
                    controller86.passGame(game);
                    stage.setScene(new Scene(pubScreen));
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
        nameLabel21.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).howManyMules()+onThisScreenHowManyDidYouBuy));
        nameLabel1.setText(String.valueOf(game.getPlayer(game.getCurrentPlayer()).getMoney()));
        /*nameLabel21.setText(String.valueOf(game.getMuleCount(game.getCurrentPlayer())));
        nameLabel1.setText(String.valueOf(game.getMoney(game.getCurrentPlayer())));*/

    }
}
