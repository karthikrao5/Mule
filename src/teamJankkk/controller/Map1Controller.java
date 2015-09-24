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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import teamJankkk.Main;
import teamJankkk.model.Game;
import teamJankkk.model.PlayerDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by KRose on 9/18/15.
 */
public class Map1Controller extends Main implements Initializable {


    public Game game;

     @FXML private ImageView image00, image01,
             image02, image03, image04, image10,
             image11, image12, image13, image14,
             image20, image21, image22, image23,
             image24, image30, image31, image32,
             image33, image34, image40, image41,
             image42, image43, image44, image50,
             image51, image52, image53, image54;

    @FXML private Label playerTurnLabel;

    @FXML private Button endTurnButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image00.setOnMouseClicked(this::map00Clicked);
        image01.setOnMouseClicked(this::map01Clicked);
        image02.setOnMouseClicked(this::map02Clicked);
        image03.setOnMouseClicked(this::map03Clicked);
        image04.setOnMouseClicked(this::map04Clicked);
        image10.setOnMouseClicked(this::map10Clicked);
        image11.setOnMouseClicked(this::map11Clicked);
        image12.setOnMouseClicked(this::map12Clicked);
        image13.setOnMouseClicked(this::map13Clicked);
        image14.setOnMouseClicked(this::map14Clicked);
        image20.setOnMouseClicked(this::map20Clicked);
        image21.setOnMouseClicked(this::map21Clicked);
        image22.setOnMouseClicked(this::map22Clicked);
        image23.setOnMouseClicked(this::map23Clicked);
        image24.setOnMouseClicked(this::map24Clicked);
        image30.setOnMouseClicked(this::map30Clicked);
        image31.setOnMouseClicked(this::map31Clicked);
        image32.setOnMouseClicked(this::map32Clicked);
        image33.setOnMouseClicked(this::map33Clicked);
        image34.setOnMouseClicked(this::map34Clicked);
        image40.setOnMouseClicked(this::map40Clicked);
        image41.setOnMouseClicked(this::map41Clicked);
        image42.setOnMouseClicked(this::map42Clicked);
        image43.setOnMouseClicked(this::map43Clicked);
        image44.setOnMouseClicked(this::map44Clicked);
    }

    @FXML
    public void map00Clicked(MouseEvent event) {
        //updateLabel();
        //Image image2 = new Image(Main.class.getResourceAsStream("../views/_Images/forest_floor_PURPLE.png"));
        //Image image = new Image("forest_floor_PURPLE.png");
        //Image image = new Image(getClass().getClassLoader().getResourceAsStream("views/_Images/forest_floor_PURPLE.png"));
        Image image = new Image("/teamJankkk/views/_Images/Forest/forest_floor_PURPLE.png");
        String colorCodedImageFilePathString = getColorCode();
        Image image2 = new Image(colorCodedImageFilePathString);
        //"\imgs\pic1.jpg"
        image00.setImage(image);
        System.out.println("Clicked");
        game.nextTurn();
    }

    @FXML
    public void map01Clicked(MouseEvent event) {
        Image image = new Image("/teamJankkk/views/_Images/Forest/forest_floor_BLUE.png");
        image01.setImage(image);
        System.out.println("Clicked");
        game.nextTurn();
    }

    @FXML
    public void map02Clicked(MouseEvent event) {
        System.out.println("Clicked");
        Image image = new Image("/teamJankkk/views/_Images/Forest/forest_floor_RED.png");
        image02.setImage(image);
        game.nextTurn();
    }

    @FXML
    public void map03Clicked(MouseEvent event) {
        System.out.println("Clicked");
        Image image = new Image("/teamJankkk/views/_Images/Forest/forest_floor_YELLOW.png");
        image03.setImage(image);
        game.nextTurn();
    }

    @FXML
    public void map04Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map10Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map11Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map12Clicked(MouseEvent event) {
        System.out.println("Clicked");


    }

    @FXML
    public void map13Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map14Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map20Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map21Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map22Clicked(MouseEvent event) {
        System.out.println("Enter Store");
        try {
            Pane screen3 = (Pane) FXMLLoader.load(getClass().getResource("../views/TheStore.fxml"));
            stage.setScene(new Scene(screen3));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void map23Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }
    @FXML
    public void map24Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map30Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map31Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map32Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }
    @FXML
    public void map33Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map34Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map40Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map41Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }
    @FXML
    public void map42Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map43Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    @FXML
    public void map44Clicked(MouseEvent event) {
        System.out.println("Clicked");
    }

    public void updateLabel() {
        playerTurnLabel.setText(new Integer(game.getPlayerTurn()).toString());
    }

    public void updateColor() {
        PlayerDB.getPlayer();
        game.getPlayerTurn();
    }

}
