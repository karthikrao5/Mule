package teamJankkk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static Stage stage;

    public static String configView = "views/ConfigScreen.fxml";

    public static String configController = "controller/ConfigController";


    @Override
    public final void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("JANKKK MULLLLLL");
            Parent root = FXMLLoader.load(teamJankkk.Main.class.getResource("views/ConfigScreen.fxml"));
            stage = primaryStage;
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}
