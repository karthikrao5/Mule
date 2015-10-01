package teamJankkk.model;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int currentTurn, numberOfPlayers, currentPlayer;

    public boolean endGame = false;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        currentPlayer = 0;
    }

    public static void nextTurn() {
        currentTurn++;
        nextPlayer();
    }

    public void landGrant() {

    }

    public void runGame() {

    }

    public int getCurrentTurnNumber() {
        return currentTurn;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private static void nextPlayer() {
        if(currentPlayer >= numberOfPlayers) {
            currentPlayer = 0;
        } else {
            currentPlayer++;
        }
    }
}
