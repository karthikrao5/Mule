package teamJankkk.model;

import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;

/**
 * Created by karthik on 9/21/15.
 */
public class Player {
    private String name, race, color;
    private int money, score;
    private ArrayList<Tile> tilesOwned;

    public Player(String name, String race, String color) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.money = 1500;
        tilesOwned = new ArrayList<>();
    }

    public void addTilestoPlayerList(Tile tile) {
        tilesOwned.add(tile);
    }

    public void subtractMoney(int amount) {
        money -= amount;
    }

    public int getScore() {
        return score;
    }

    public void setName(String input) {
        name = input;
    }

    public void setRace(String input) {
        race = input;
    }

    public void setColor(String input) {
        color = input;
    }

    public void setMoney(int input) {
        money = input;
    }

    public int getMoney() {return money;}

    public void addMoney(int moneyToAdd) {
        this.money = money + moneyToAdd;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getColor() {
        return color;
    }
}
