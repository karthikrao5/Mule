package teamJankkk.model;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int difficulty = 0,
            mapNumber = 0, humanPlayers = 0,
            playersTurn = 0, numberOfTurns = 0;

    public boolean endGame = false;

    public Game(int difficulty, int map, int humanPlayers) {
        this.difficulty = difficulty;
        this.mapNumber = map;
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
        if playersTurn == 0 {

        } else if playersTurn == 1 {

        } else if playersTurn == 2 {

        } else if playersTurn == 3 {

        }
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
