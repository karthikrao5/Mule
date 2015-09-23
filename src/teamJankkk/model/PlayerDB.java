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

    private static HashMap<Player, Integer> db;
    private static ArrayList<Player> playerList;
    private static ArrayList<String> stringPlayerList;

    public PlayerDB() {
    }

    public static void createDB() {
        db = new HashMap<>();
    }

    public static void createPlayer(String name, int index) {
        Player newPlayer = new Player(name, null, null);
        db.put(newPlayer, index);
    }

    public static void setRace(String race, int index) {
        getPlayer(index).getKey().setRace(race);
    }

    public static void setColor(String color, int index) {
        getPlayer(index).getKey().setColor(color);
    }

    public static List<Player> getPlayerList() {
        playerList = new ArrayList<>();
        for(Map.Entry<Player, Integer> p : db.entrySet()) {
            playerList.add(p.getKey());
        }
        return playerList;
    }

    public static List<String> getStringPlayerList() {
        stringPlayerList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Map.Entry<Player, Integer> p : db.entrySet()) {
            sb.append("Player: " + p.getKey().getName()
                    + ". Race: " + p.getKey().getRace()
                    + ". Color: "+ p.getKey().getRace());
            stringPlayerList.add(sb.toString());
            count++;

        }
        return stringPlayerList;
    }

//    public static String getPlayerListString() {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 4; i++) {
//            sb.append("Player: " + playerList.get(i).getName());
//        }
//        return sb.toString();
//    }

    private static Map.Entry<Player, Integer> getPlayer(int index) {

        if(index > 4) {
            System.out.println("Sorry player not inbounds");
        } else {
            for(Map.Entry<Player, Integer> p : db.entrySet()) {
                if(p.getValue().compareTo(index) == 0) {
                    return p;
                }
            }
        }
        return null;
    }

    public static String toString(int index) {
        String name = getPlayer(index).getKey().getName();
        String color = getPlayer(index).getKey().getColor();
        String race = getPlayer(index).getKey().getRace();

        return "Player " + name + " of the " + race
                + " race and on the " + color + " team.";
    }
}