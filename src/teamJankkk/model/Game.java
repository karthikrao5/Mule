package teamJankkk.model;

import teamJankkk.controller.ConfigController;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int currentTurn, numberOfPlayers;
    private static int currentPlayer;

    public boolean endGame = false;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.currentPlayer = 1;
    }

    public static int nextTurn() {
        currentTurn++;
        return nextPlayer();

    }

    public void landGrant() {

    }

    public void runGame() {

    }

    public static int getCurrentTurnNumber() {
        return currentTurn;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private static int nextPlayer() {
        if(currentPlayer >= numberOfPlayers) {
            currentPlayer = 0;
        } else {
            currentPlayer++;
        }
        return currentPlayer;
    }
}
