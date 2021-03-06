package teamJankkk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader();
            primaryStage.setTitle("JANKKK MULLLLLL");
            stage = primaryStage;
            Pane root = (Pane) loader.load(getClass().getResource("views/ConfigScreen.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Main IO:" + e.getMessage());
        }
    }

    public static void setStage(Stage newStage) {
        stage = newStage;
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
