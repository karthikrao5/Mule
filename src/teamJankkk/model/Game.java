package teamJankkk.model;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int difficulty = 0, map = 0, humanPlayers = 0, playersTurn = 0, numberOfTurns = 0;

    public Game(int difficulty, int map, int humanPlayers) {
        this.difficulty = difficulty;
        this.map = map;
        this.humanPlayers = humanPlayers;
    }

    public void nextTurn() {
        if (playersTurn < 4) {
            playersTurn++;
        } else if (playersTurn == 4) {
            playersTurn = 0;
        }
    }

    public void landGrant() {

    }

    public void runGame() {
        if (numberOfTurns == 0 || numberOfTurns == 1) {
            landGrant();
            numberOfTurns++;
        }
    }

    public int getTurnNumber() { return numberOfTurns; }
    public int getPlayerTurn() { return playersTurn; }
}
