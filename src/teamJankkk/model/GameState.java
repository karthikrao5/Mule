package teamJankkk.model;


import java.io.IOException;
import java.io.StringWriter;
import com.google.gson.Gson;



/**
 * Created by karthik on 11/3/15.
 */
public class GameState {
    Game game;


    public void saveGame(Game game) {
        this.game = game;

        Gson object = new Gson();
        System.out.println(object.toJson(game));
    }
}
