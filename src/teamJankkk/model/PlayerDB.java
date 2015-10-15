package teamJankkk.model;

import teamJankkk.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by karthik on 9/21/15.
 */
public class PlayerDB {

    private HashMap<Player, Integer> db;
    private ArrayList<Player> playerList;
    private ArrayList<String> stringPlayerList;

    public PlayerDB() {
        db = new HashMap<>();
    }

    public void createPlayer(String name, int index) {
        Player newPlayer = new Player(name, null, null);
        db.put(newPlayer, index);
    }

    public void setRace(String race, int index) {
        getPlayer(index).setRace(race);
    }

    public void setColor(String color, int index) {
        getPlayer(index).setColor(color);
    }

    public List<Player> getPlayerList() {
        playerList = new ArrayList<>();
        for(Map.Entry<Player, Integer> p : db.entrySet()) {
            playerList.add(p.getKey());
        }
        return playerList;
    }

    public List<String> getStringPlayerList() {
        stringPlayerList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Map.Entry<Player, Integer> p : db.entrySet()) {
            sb.append("Player: " + p.getKey().getName()
                    + ". Race: " + p.getKey().getRace()
                    + ". Color: "+ p.getKey().getColor());
            stringPlayerList.add(sb.toString());
            count++;

        }
        return stringPlayerList;
    }


    public Player getPlayer(int index) {

        if(index > 4) {
            System.out.println("Sorry player not inbounds");
        } else {
            for(Map.Entry<Player, Integer> p : db.entrySet()) {
                if(p.getValue().compareTo(index) == 0) {
                    return p.getKey();
                }
            }
        }
        return null;
    }

    public String toString(int index) {
        String name = getPlayer(index).getName();
        String color = getPlayer(index).getColor();
        String race = getPlayer(index).getRace();

        return "Player " + name + " of the " + race
                + " race and on the " + color + " team.";
    }
}
