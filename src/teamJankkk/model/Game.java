package teamJankkk.model;

import teamJankkk.controller.ConfigController;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int currentTurn = 0;
    private static int numberOfPlayers = 0;
    private static int currentPlayer = 1;
    public boolean endGame = false;

    public Game() {
    }

    public static void setNumberOfPlayers(int num) {
        numberOfPlayers = num;
    }

    public static int nextTurn() {
        currentTurn++;
        int n = nextPlayer();
        System.out.println("nextTurn = " + n);
        return n;

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

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private static int nextPlayer() {
        System.out.println("getNumberofPlayers " + numberOfPlayers);
        if(currentPlayer >= numberOfPlayers) {
            currentPlayer = 1;
        } else {
            currentPlayer++;
        }
        return currentPlayer;
    }
}
