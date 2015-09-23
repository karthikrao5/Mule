package teamJankkk.model;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int difficulty = 0, map = 0, humanPlayers = 0;

    public Game(int difficulty, int map, int humanPlayers) {
        this.difficulty = difficulty;
        this.map = map;
        this.humanPlayers = humanPlayers;
    }
}
