package teamJankkk.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by karthik on 9/21/15.
 */
public class Player {
    private String name, race, color;
    private int money, score, food, energy, smithore, crystite;

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

    public void addEnergy(int energyToAdd) {
        this.energy = energy + energyToAdd;
    }

    public void addSmithore(int smithoreToAdd) {
        this.smithore = smithore + smithoreToAdd;
    }

    public void addCrystite(int crystiteToAdd) {
        this.crystite = crystite + crystiteToAdd;
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
