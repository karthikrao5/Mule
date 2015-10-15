package teamJankkk.controller;
import teamJankkk.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //save3Button.setOnAction(this::saveName);
        buyButton.setOnAction(this::buy);
    }

    @FXML
    public void buy(ActionEvent event) {
        
    }
}
