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
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * Created by KRose on 9/18/15.
 */
public class Map1Controller extends Main implements Initializable {

    @FXML private ImageView image00, image01,
         image02, image03, image04, image10,
         image11, image12, image13, image14,
         image20, image21, image22, image23,
         image24, image30, image31, image32,
         image33, image34, image40, image41,
         image42, image43, image44, image50,
         image51, image52, image53, image54;
    @FXML private Label turnCounterLabel1;
    @FXML private Label timerLabel;
    @FXML private Label turnCounterLabel;
    @FXML private Button endTurnButton;
    private final Integer STARTTIME = 60;
    private Integer timeSeconds = STARTTIME;
    private Integer playerTURN = 1;
    private Integer turnCOUNT = 1;
    private Timeline timeline;
    private Game game;

    private boolean hasSelectedLand = false;


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
        updateColors();
//        game.loadGameState();
    }

    public void passGame(Game game) {
        this.game = game;
    }

    @FXML
    private void endTurn(ActionEvent event) {
        playerTURN = game.nextTurn();
        timer();
        hasSelectedLand = false;
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

        System.out.println("Tile00 contains: " + game.getTileFromList("tile00").getResource());

        //if tile is not owned
        System.out.println("tileIsOwned 00: " + game.isTileOwned("tile00"));
        if(game.tileIsOwned("tile00") || !game.getIsSelectedLandInCurrentTurn()) {
            //set owner
            game.buyTile("tile00");
            game.setIsSelectedLandInCurrentTurn(true);
            //change the color of the tile to match the player
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image00.setImage(new Image(newName));
        } else {
            if(game.getIsSelectedLandInCurrentTurn() && game.getPlayerIsBoughtMule()) {
                game.dropMule("tile00");
            }
        }
    }

    @FXML
    public void map01Clicked(MouseEvent event) {
        System.out.println("Tile00 contains: " + game.getTileFromList("tile01").getResource());


        System.out.println("tileIsOwned 01: " + game.isTileOwned("tile01"));
        if(game.tileIsOwned("tile01") || !game.getIsSelectedLandInCurrentTurn()) {

            game.buyTile("tile01");
            game.setIsSelectedLandInCurrentTurn(true);

            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wRocks1";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image01.setImage(new Image(newName));
        } else {
            if(game.getIsSelectedLandInCurrentTurn() && game.getPlayerIsBoughtMule()) {
                game.dropMule("tile01");
            }
        }
    }

    @FXML
    public void map02Clicked(MouseEvent event) {
        System.out.println("Tile02 contains: " + game.getTileFromList("tile02").getResource());


        System.out.println("tileIsOwned 02: " + game.isTileOwned("tile02"));
        if(game.tileIsOwned("tile02") || !game.getIsSelectedLandInCurrentTurn()) {

            game.buyTile("tile02");
            game.setIsSelectedLandInCurrentTurn(true);

            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wTrees2";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image01.setImage(new Image(newName));
        } else {
            if(game.getIsSelectedLandInCurrentTurn() && game.getPlayerIsBoughtMule()) {
                game.dropMule("tile02");
            }
        }
    }

    @FXML
    public void map03Clicked(MouseEvent event) {
        System.out.println("Tile03 contains: " + game.getTileFromList("tile03").getResource());


        if(game.tileIsOwned("tile03")) {
            game.buyTile("tile03");
            game.setIsSelectedLandInCurrentTurn(true);
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image03.setImage(new Image(newName));
        } else {
            if(game.getIsSelectedLandInCurrentTurn() && game.getPlayerIsBoughtMule()) {
                game.dropMule("tile03");
            }
        }
    }

    @FXML
    public void map04Clicked(MouseEvent event) {
//        if(!tile04.getIsClaimed()) {
//            tile04.setIsClaimed(true);
//            tile04.setOwner();
//            System.out.println(tile04.getIsClaimed());
//            System.out.println();
//            image04.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile04") && !hasSelectedLand) {
            game.buyTile("tile04");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image04.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile04");
        }
    }

    @FXML
    public void map10Clicked(MouseEvent event) {
//        if(!tile10.getIsClaimed()) {
//            tile10.setIsClaimed(true);
//            tile10.setOwner();
//            System.out.println(tile10.getIsClaimed());
//            System.out.println();
//            image10.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile10") && !hasSelectedLand) {
            game.buyTile("tile10");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image10.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile10");
        }
    }

    @FXML
    public void map11Clicked(MouseEvent event) {
//        if(!tile11.getIsClaimed()) {
//            tile11.setIsClaimed(true);
//            tile11.setOwner();
//            image11.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile11") && !hasSelectedLand) {
            game.buyTile("tile11");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wTrees1";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image11.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile11");
        }
    }

    @FXML
    public void map12Clicked(MouseEvent event) {
//        if(!tile12.getIsClaimed()) {
//            tile12.setIsClaimed(true);
//            tile12.setOwner();
//            image12.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile12") && !hasSelectedLand) {
            game.buyTile("tile12");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wRocks4";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image12.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile12");
        }
    }

    @FXML
    public void map13Clicked(MouseEvent event) {
//        if(!tile13.getIsClaimed()) {
//            tile13.setIsClaimed(true);
//            tile13.setOwner();
//            image13.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile13") && !hasSelectedLand) {
            game.buyTile("tile13");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image13.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile13");
        }
    }

    @FXML
    public void map14Clicked(MouseEvent event) {
//        if(!tile14.getIsClaimed()) {
//            tile14.setIsClaimed(true);
//            tile14.setOwner();
//            image14.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile14") && !hasSelectedLand) {
            game.buyTile("tile14");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wRocks2";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image14.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile14");
        }
    }

    @FXML
    public void map20Clicked(MouseEvent event) {
//        if(!tile20.getIsClaimed()) {
//            tile20.setIsClaimed(true);
//            tile20.setOwner();
//            image20.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile20") && !hasSelectedLand) {
            game.buyTile("tile20");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wWater1";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image20.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile20");
        }
    }

    @FXML
    public void map21Clicked(MouseEvent event) {
//        if(!tile21.getIsClaimed()) {
//            tile21.setIsClaimed(true);
//            tile21.setOwner();
//            image21.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile21") && !hasSelectedLand) {
            game.buyTile("tile21");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wWater2";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image21.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile21");
        }
    }


    //store tile
    @FXML
    public void map22Clicked(MouseEvent event) {
        System.out.println("Enter Store");
        game.saveGameState();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/TheStore.fxml"));
            Pane screen3 = (Pane) loader.load();
            StoreController controller = loader.<StoreController>getController();
            controller.setGame(game);
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
//            tile23.setOwner();
//            image23.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile23") && !hasSelectedLand) {
            game.buyTile("tile23");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wWater2";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image23.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile23");
        }
    }

    @FXML
    public void map24Clicked(MouseEvent event) {
//        if(!tile24.getIsClaimed()) {
//            tile24.setIsClaimed(true);
//            tile24.setOwner();
//            image24.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile24") && !hasSelectedLand) {
            game.buyTile("tile24");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wWater1";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image24.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile24");
        }
    }

    @FXML
    public void map30Clicked(MouseEvent event) {
//        if(!tile30.getIsClaimed()) {
//            tile30.setIsClaimed(true);
//            tile30.setOwner();
//            image30.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile30") && !hasSelectedLand) {
            game.buyTile("tile30");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wRocks3";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image30.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile30");
        }
    }

    @FXML
    public void map31Clicked(MouseEvent event) {
//        if(!tile31.getIsClaimed()) {
//            tile31.setIsClaimed(true);
//            tile31.setOwner();
//            image31.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile31") && !hasSelectedLand) {
            game.buyTile("tile31");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wTrees3";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image31.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile31");
        }
    }

    @FXML
    public void map32Clicked(MouseEvent event) {
//        if(!tile32.getIsClaimed()) {
//            tile32.setIsClaimed(true);
//            tile32.setOwner();
//            image32.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile32") && !hasSelectedLand) {
            game.buyTile("tile32");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image32.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile32");
        }
    }
    @FXML
    public void map33Clicked(MouseEvent event) {
//        if(!tile33.getIsClaimed()) {
//            tile33.setIsClaimed(true);
//            tile33.setOwner();
//            image33.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile33") && !hasSelectedLand) {
            game.buyTile("tile33");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image33.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile33");
        }
    }

    @FXML
    public void map34Clicked(MouseEvent event) {
//        if(!tile34.getIsClaimed()) {
//            tile34.setIsClaimed(true);
//            tile34.setOwner();
//            image34.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile34") && !hasSelectedLand) {
            game.buyTile("tile34");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wTrees2";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image34.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile34");
        }
    }

    @FXML
    public void map40Clicked(MouseEvent event) {
//        if(!tile40.getIsClaimed()) {
//            tile40.setIsClaimed(true);
//            tile40.setOwner();
//            image40.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile40") && !hasSelectedLand) {
            game.buyTile("tile40");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image40.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile40");
        }
    }

    @FXML
    public void map41Clicked(MouseEvent event) {
//        if(!tile41.getIsClaimed()) {
//            tile41.setIsClaimed(true);
//            tile41.setOwner();
//            image41.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }

        if(!game.tileIsOwned("tile41") && !hasSelectedLand) {
            game.buyTile("tile41");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            System.out.println("IMAGE NAME IS " + newName);
            image41.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile41");
        }
    }

    @FXML
    public void map42Clicked(MouseEvent event) {
//        if(!tile42.getIsClaimed()) {
//            tile42.setIsClaimed(true);
//            tile42.setOwner();
//            image42.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile42") && !hasSelectedLand) {
            game.buyTile("tile42");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image42.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile42");
        }
    }

    @FXML
    public void map43Clicked(MouseEvent event) {
//        if(!tile43.getIsClaimed()) {
//            tile43.setIsClaimed(true);
//            tile43.setOwner();
//            image43.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile43") && !hasSelectedLand) {
            game.buyTile("tile43");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor_wTrees1";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image43.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile43");
        }
    }

    @FXML
    public void map44Clicked(MouseEvent event) {
//        if(!tile44.getIsClaimed()) {
//            tile44.setIsClaimed(true);
//            tile44.setOwner();
//            image44.setImage(new Image(updateColor()));
//            endTurn();
//        } else {
//            System.out.println("Player has already claimed this land");
//        }
        if(!game.tileIsOwned("tile44") && !hasSelectedLand) {
            game.buyTile("tile44");
            hasSelectedLand = true;
            String color = game.getColor();
            String imageName = "/teamJankkk/views/_Images/Forest/forest_floor";
            String newName = imageName + "_" + color.toUpperCase() + ".png";
            image44.setImage(new Image(newName));
        } else if (hasSelectedLand) {
            System.out.println("You have already selected land this turn, ya dingus!");
        } else {
            game.dropMule("tile44");
        }
    }

    public void updateLabel() {
        turnCounterLabel1.setText(playerTURN.toString());
        turnCOUNT = game.getCurrentTurnNumber();
        turnCounterLabel.setText(turnCOUNT.toString());
        //newLabel.setTet(mode);
    }

    public void updateColors() {
        /*List<Tile> tileList = Game.getTileList();
        for(Tile t : tileList) {
            if (t.getIsClaimed()) {
                int playerNumber = t.getOwnerNumber();
                String color = PlayerDB.getPlayer(playerNumber).getColor();
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

            }
        }
        */
    }

//    public String updateColor(String imageName, String color) {
//
//        try {
////            String color = game.getColor(playerTURN);
////            if (color.equals("Blue")) {
////                color = "/teamJankkk/views/_Images/Forest/forest_floor_BLUE.png";
////            } else if (color.equals("Yellow")) {
////                color = "/teamJankkk/views/_Images/Forest/forest_floor_YELLOW.png";
////            } else if (color.equals("Purple")) {
////                color = "/teamJankkk/views/_Images/Forest/forest_floor_PURPLE.png";
////            } else if (color.equals("Green")) {
////                color = "/teamJankkk/views/_Images/Forest/forest_floor_PURPLE.png";
////            } else if (color.equals("Red")) {
////                color = "/teamJankkk/views/_Images/Forest/forest_floor_RED.png";
////            }
////            return color;
//            color = color.toUpperCase();
//            imageName = imageName + "_" + color + ".png";
//            return imageName
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage() + " " + e.getCause());
//        }
//        return null;
//    }

}
