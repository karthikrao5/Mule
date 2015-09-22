package teamJankkk.model;

import teamJankkk.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik on 9/21/15.
 */
public class PlayerDB {

    private List<Player> db;

    public PlayerDB() {
        db = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        db.add(p);
    }

    public Player getPlayer(String name) {
        //iterate thru list and return player with
        //with certain name
        return null;
    }

    public List<Player> getPlayerList() {
        return db;
    }
}
