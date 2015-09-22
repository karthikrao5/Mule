package teamJankkk.model;

import java.io.Serializable;

/**
 * Created by karthik on 9/21/15.
 */
public final class Player {
    private String name, race, color;
    private int difficulty;

    public Player(String name, String race, String color) {
        this.name = name;
        this.race = race;
        this.color = color;
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

    public void setDifficulty(int input) {
        difficulty = input;
    }

    public String getName() {
        return name;
    }
}
