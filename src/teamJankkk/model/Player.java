package teamJankkk.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Created by karthik on 9/21/15.
 */
public class Player {
    private String name, race, color;
    private int money, score, food, energy, smithore, crystite;
    private List<Tile> tilesOwned = new ArrayList<Tile>();

    public Player(String name, String race, String color) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.money = 1500;
        score = 0;
        food = 0;
        energy = 0;
        smithore = 0;
        crystite = 0;
    }

    public void addTilestoPlayerList(Tile tile) {
        tilesOwned.add(tile);
    }

    public void subtractMoney(int amount) {
        money -= amount;
        System.out.println("Player " + name + " has: " + money + " now.");
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

    public void addFood(int foodToAdd) {
        this.food = food + foodToAdd;
    }

    public void subtractFood(int foodToSubtract) {
        this.food = food - foodToSubtract;
    }

    public void addEnergy(int energyToAdd) {
        this.energy = energy + energyToAdd;
    }

    public void subtractEnergy(int energyToSubtract) {
        this.energy = energy - energyToSubtract;
    }

    public void addSmithore(int smithoreToAdd) {
        this.smithore = smithore + smithoreToAdd;
    }

    public void subtractSmithore(int smithoreToSubtract) {
        this.smithore = smithore - smithoreToSubtract;
    }

    public void addCrystite(int crystiteToAdd) {
        this.crystite = crystite + crystiteToAdd;
    }

    public void subtractCrystite(int crystiteToSubtract) {
        this.crystite = crystite + crystiteToSubtract;
    }

    public String getName() {
        return name;
    }

    public int getFood() {
        return food;
    }

    public int getSmithore() {
        return smithore;
    }

    public int getEnergy() {
        return energy;
    }

    public String getRace() {
        return race;
    }

    public String getColor() {
        return color;
    }

    public int howManyMules() {
        int muleCount = 0;
        for (int l = 0; l < tilesOwned.size(); l++) {
            if (tilesOwned.get(l).isInstalled()) {
                muleCount++;
            }
        }
        return muleCount;
    }

    public List<Tile> getTileList() {
        return tilesOwned;
    }
}
