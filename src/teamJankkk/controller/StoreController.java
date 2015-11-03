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
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by KRose on 9/23/15.
 */
public class StoreController extends Main implements Initializable {


    Game game;
    private int temp;
    @FXML private ImageView thePub, auctionHouse, muleStore;
            //, smithoreTile, energyTile, foodTile;

    @FXML private Label moneyLabel, goBackLabel, playerLabel;
    @FXML private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        thePub.setOnMouseClicked(this::thePubClicked);
        auctionHouse.setOnMouseClicked(this::theAuctionHouseClicked);
        muleStore.setOnMouseClicked(this::muleStoreClicked);
        //smithoreTile.setOnMouseClicked((this::smithOreClicked));
        //energyTile.setOnMouseClicked((this::energyTileClicked));
        //foodTile.setOnMouseClicked(this::foodTileClicked);
//        moneyLabel.setText(String.valueOf(PlayerDB.getPlayer(Game.getCurrentPlayer()).getMoney()));
    }

    public void setGame(Game game) {
        this.game = game;
        moneyLabel.setText(String.valueOf(game.getMoney()));
    }

    @FXML
     public void goBackToMap() {
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
    public void thePubClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/ThePub.fxml"));
            Pane pubScreen = (Pane) loader.load();
            PubController controller = loader.<PubController>getController();
            controller.passGame(game);
//            Pane pubScreen = (Pane) FXMLLoader.load(getClass().getResource("../views/ThePub.fxml"));
            stage.setScene(new Scene(pubScreen));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void theAuctionHouseClicked(MouseEvent event) {
        System.out.println("The AuctionHouse was clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/AuctionHouse.fxml"));
            Pane auctionHousePane = (Pane) loader.load();
            AuctionHouseController controller = loader.<AuctionHouseController>getController();
            controller.passGame(game);
//            Pane pubScreen = (Pane) FXMLLoader.load(getClass().getResource("../views/AuctionHouse.fxml"));
            stage.setScene(new Scene(auctionHousePane));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void muleStoreClicked(MouseEvent event) {
        System.out.println("The muleStore was clicked");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/BuyMule.fxml"));
            Pane buyMule = (Pane) loader.load();
            BuyMuleController controller1 = loader.<BuyMuleController>getController();
            controller1.passGame(game);
            stage.setScene(new Scene(buyMule));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void smithOreClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

    public void energyTileClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

    public void foodTileClicked(MouseEvent event) {
        System.out.println("The Pub was clicked");
    }

    @FXML
    public void saveGame(ActionEvent event) {
        // SMOKE KUSH
    }

}
