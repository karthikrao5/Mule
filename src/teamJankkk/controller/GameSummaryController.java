package teamJankkk.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import teamJankkk.Main;
import teamJankkk.model.Player;
import teamJankkk.model.PlayerDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by karthik on 9/22/15.
 */
public class GameSummaryController extends Main implements Initializable {


    @FXML private Button startGameButton;
    @FXML private ListView<String> summaryListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList(PlayerDB.getStringPlayerList());

        summaryListView.setItems(list);
        System.out.println(PlayerDB.getStringPlayerList());
        startGameButton.setOnAction(this::startGame);
    }

    @FXML
    public void startGame(ActionEvent event) {
        try {
            Pane mapPane = (Pane) FXMLLoader.load(getClass().getResource("../views/Map1_Forest.fxml"));
            stage.setScene(new Scene(mapPane));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
