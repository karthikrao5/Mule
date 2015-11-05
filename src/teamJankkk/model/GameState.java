package teamJankkk.model;


import java.io.*;




/**
 * Created by karthik on 11/3/15.
 */
public class GameState {

    public void saveGame(Game game) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("/Users/karthik/Mule/src/teamJankkk/model/gameState.data"));
            ObjectOutputStream obj = new ObjectOutputStream(fos);
            obj.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Game loadGame(String fileName) {
        Game loadedGame = null;
        try {
            ObjectInput objInput = new ObjectInputStream(new FileInputStream("/Users/karthik/Mule/src/teamJankkk/model/gameState.data"));
            loadedGame = (Game) objInput.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.getMessage();
        }
        return loadedGame;
    }
}
