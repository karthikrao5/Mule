package teamJankkk.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.util.Duration;
import teamJankkk.model.Tile;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * Created by KRose on 9/18/15.
 */
public class Map1Controller extends Main implements Initializable {

//    private Tile tile00 = new Tile();
//    private Tile tile01 = new Tile();
//    private Tile tile02 = new Tile();
//    private Tile tile03 = new Tile();
//    private Tile tile04 = new Tile();
//    private Tile tile10 = new Tile();
//    private Tile tile11 = new Tile();
//    private Tile tile12 = new Tile();
//    private Tile tile13 = new Tile();
//    private Tile tile14 = new Tile();
//    private Tile tile20 = new Tile();
//    private Tile tile21 = new Tile();
//    private Tile tile22 = new Tile();
//    private Tile tile23 = new Tile();
//    private Tile tile24 = new Tile();
//    private Tile tile30 = new Tile();
//    private Tile tile31 = new Tile();
//    private Tile tile32 = new Tile();
//    private Tile tile33 = new Tile();
//    private Tile tile34 = new Tile();
//    private Tile tile40 = new Tile();
//    private Tile tile41 = new Tile();
//    private Tile tile42 = new Tile();
//    private Tile tile43 = new Tile();
//    private Tile tile44 = new Tile();

    @FXML private ImageView image00, image01,
         image02, image03, image04, image10,
         image11, image12, image13, image14,
         image20, image21, image22, image23,
         image24, image30, image31, image32,
         image33, image34, image40, image41,
         image42, image43, image44, image50,
         image51, image52, image53, image54;
    @FXML private static Label turnCounterLabel1;
    @FXML private Label turnCounterLabel2;
    @FXML private Label timerLabel;
    @FXML private Label turnCounterLabel;
    @FXML private Button endTurnButton;
    private static final Integer STARTTIME = 60;
    private static Integer timeSeconds = STARTTIME;
    private static Integer playerTURN = 1;
    private static Integer turnCOUNT = 1;
    private static Timeline timeline;
    private Game game;


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
        endTurnButton.setOnAction(this::endTurn);
        // timerLabel.setText(timeSeconds.toString());
        timer();
        game = new Game();
    }

    @FXML
    private void endTurn(ActionEvent event) {
        playerTURN = game.nextTurn();
        timer();
        //Game.nextTurn();
        updateLabel();
    }

    public void timer() {

        if (timeline != null) {
            timeline.stop();
        }
        timeSeconds = STARTTIME;
        // update timerLabel
        timerLabel.setText(timeSeconds.toString());
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        event1 -> {
                            timeSeconds--;
                            // update timerLabel
                            timerLabel.setText(
                                    timeSeconds.toString());
                            if (timeSeconds <= 0) {
                                //timeline.stop();
                                timeSeconds = STARTTIME;
                                //game.nextTurn();
                                updateLabel();
                            }
                        }));
        timeline.playFromStart();
    }

    @FXML
    public void map00Clicked(MouseEvent event) {
//        if(!tile00.getIsClaimed()) {
//                tile00.setIsClaimed(true);
//                tile00.setOwner(Game.getCurrentPlayer());
//                System.out.println(updateColor());
//                image00.setImage(new Image(updateColor()));
//                endTurn();
//        } else {
//            if (Game.getCurrentTurnNumber() < 2) {
//                System.out.println("Player has already claimed this land");
//            } else if (tile00.getOwner().equals(Game.getCurrentPlayer())) {
//                if (tile00.getIsInstalled() == false) {
//
//                }
//            } else {
//                System.out.println("Another player has claimed this land.");
//            }
            //so in this else , it's claimed
            //now check if the player it's claimed by is the right player
            //if its the right player then proceed else outprint wrong player
            //PROCEED
            //check if its installed If so - show alert window
            // do you want to harvest ou trynna harvest??????
            //NOTINSTALLED
            //
            // else show alert window
            // would you like to install mule?
            // if press yes, check if they have any mules that don't have tiles
            // if there are mules that aren't installed, check if they have
            // oufits
            // if theyre outfitted for the wrong type of land, print
            // WRONG type of land
            // if theyre outfitted for the right type of land,
            // show alert window: mule installed
//        }

    }

    @FXML
    public void map01Clicked(MouseEvent event) {
//        if(!tile01.getIsClaimed()) {
//            tile01.setIsClaimed(true);
//            tile01.setOwner(Game.getCurrentPlayer());
//            System.out.println(tile01.getIsClaimed());
//            System.out.println(Game.getCurrentPlayer());
//            image01.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }



    }

    @FXML
    public void map02Clicked(MouseEvent event) {
//        if(!tile02.getIsClaimed()) {
//            tile02.setIsClaimed(true);
//            tile02.setOwner(Game.getCurrentPlayer());
//            System.out.println(tile02.getIsClaimed());
//            System.out.println(Game.getCurrentPlayer());
//            image02.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }

    }

    @FXML
    public void map03Clicked(MouseEvent event) {
//        if(!tile03.getIsClaimed()) {
//            tile03.setIsClaimed(true);
//            tile03.setOwner(Game.getCurrentPlayer());
//            System.out.println(tile03.getIsClaimed());
//            System.out.println(Game.getCurrentPlayer());
//            image03.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map04Clicked(MouseEvent event) {
//        if(!tile04.getIsClaimed()) {
//            tile04.setIsClaimed(true);
//            tile04.setOwner(Game.getCurrentPlayer());
//            System.out.println(tile04.getIsClaimed());
//            System.out.println(Game.getCurrentPlayer());
//            image04.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map10Clicked(MouseEvent event) {
//        if(!tile10.getIsClaimed()) {
//            tile10.setIsClaimed(true);
//            tile10.setOwner(Game.getCurrentPlayer());
//            System.out.println(tile10.getIsClaimed());
//            System.out.println(Game.getCurrentPlayer());
//            image10.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map11Clicked(MouseEvent event) {
//        if(!tile11.getIsClaimed()) {
//            tile11.setIsClaimed(true);
//            tile11.setOwner(Game.getCurrentPlayer());
//            image11.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map12Clicked(MouseEvent event) {
//        if(!tile12.getIsClaimed()) {
//            tile12.setIsClaimed(true);
//            tile12.setOwner(Game.getCurrentPlayer());
//            image12.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map13Clicked(MouseEvent event) {
//        if(!tile13.getIsClaimed()) {
//            tile13.setIsClaimed(true);
//            tile13.setOwner(Game.getCurrentPlayer());
//            image13.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map14Clicked(MouseEvent event) {
//        if(!tile14.getIsClaimed()) {
//            tile14.setIsClaimed(true);
//            tile14.setOwner(Game.getCurrentPlayer());
//            image14.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map20Clicked(MouseEvent event) {
//        if(!tile20.getIsClaimed()) {
//            tile20.setIsClaimed(true);
//            tile20.setOwner(Game.getCurrentPlayer());
//            image20.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map21Clicked(MouseEvent event) {
//        if(!tile21.getIsClaimed()) {
//            tile21.setIsClaimed(true);
//            tile21.setOwner(Game.getCurrentPlayer());
//            image21.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }


    //store tile
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
//        if(!tile23.getIsClaimed()) {
//            tile23.setIsClaimed(true);
//            tile23.setOwner(Game.getCurrentPlayer());
//            image23.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map24Clicked(MouseEvent event) {
//        if(!tile24.getIsClaimed()) {
//            tile24.setIsClaimed(true);
//            tile24.setOwner(Game.getCurrentPlayer());
//            image24.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map30Clicked(MouseEvent event) {
//        if(!tile30.getIsClaimed()) {
//            tile30.setIsClaimed(true);
//            tile30.setOwner(Game.getCurrentPlayer());
//            image30.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map31Clicked(MouseEvent event) {
//        if(!tile31.getIsClaimed()) {
//            tile31.setIsClaimed(true);
//            tile31.setOwner(Game.getCurrentPlayer());
//            image31.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map32Clicked(MouseEvent event) {
//        if(!tile32.getIsClaimed()) {
//            tile32.setIsClaimed(true);
//            tile32.setOwner(Game.getCurrentPlayer());
//            image32.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }
    @FXML
    public void map33Clicked(MouseEvent event) {
//        if(!tile33.getIsClaimed()) {
//            tile33.setIsClaimed(true);
//            tile33.setOwner(Game.getCurrentPlayer());
//            image33.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map34Clicked(MouseEvent event) {
//        if(!tile34.getIsClaimed()) {
//            tile34.setIsClaimed(true);
//            tile34.setOwner(Game.getCurrentPlayer());
//            image34.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map40Clicked(MouseEvent event) {
//        if(!tile40.getIsClaimed()) {
//            tile40.setIsClaimed(true);
//            tile40.setOwner(Game.getCurrentPlayer());
//            image40.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map41Clicked(MouseEvent event) {
//        if(!tile41.getIsClaimed()) {
//            tile41.setIsClaimed(true);
//            tile41.setOwner(Game.getCurrentPlayer());
//            image41.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }

        if(!game.tileIsOwned("tile41")) {
            game.connectTile("tile41");
        } else {
            game.dropMule("tile41");
        }
    }

    @FXML
    public void map42Clicked(MouseEvent event) {
//        if(!tile42.getIsClaimed()) {
//            tile42.setIsClaimed(true);
//            tile42.setOwner(Game.getCurrentPlayer());
//            image42.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map43Clicked(MouseEvent event) {
//        if(!tile43.getIsClaimed()) {
//            tile43.setIsClaimed(true);
//            tile43.setOwner(Game.getCurrentPlayer());
//            image43.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    @FXML
    public void map44Clicked(MouseEvent event) {
//        if(!tile44.getIsClaimed()) {
//            tile44.setIsClaimed(true);
//            tile44.setOwner(Game.getCurrentPlayer());
//            image44.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
    }

    public void updateLabel() {
//        turnCOUNT = Game.getCurrentTurnNumber();
        turnCounterLabel1.setText(playerTURN.toString());
        turnCounterLabel.setText(turnCOUNT.toString());
        //newLabel.setTet(mode);
    }



    public String updateColor() {

        try {
            String color = PlayerDB.getPlayer(playerTURN).getColor();
            if (color.equals("Blue")) {
                color = "/teamJankkk/views/_Images/Forest/forest_floor_BLUE.png";
            } else if (color.equals("Yellow")) {
                color = "/teamJankkk/views/_Images/Forest/forest_floor_YELLOW.png";
            } else if (color.equals("Purple")) {
                color = "/teamJankkk/views/_Images/Forest/forest_floor_PURPLE.png";
            } else if (color.equals("Green")) {
                color = "/teamJankkk/views/_Images/Forest/forest_floor_PURPLE.png";
            } else if (color.equals("Red")) {
                color = "/teamJankkk/views/_Images/Forest/forest_floor_RED.png";
            }
            return color;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
        return null;
    }

}
