package teamJankkk.model;

import teamJankkk.controller.ConfigController;
import teamJankkk.controller.Map1Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private int currentTurn = 0;
    private static int numberOfPlayers = 0;
    private int currentPlayer = 1;
    public boolean endGame = false;
    List<Tile> tileList = new ArrayList<>();
    boolean playerPurchasedLand;

    public Game() {
        //x axis is i
        //y axis is j
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 2 && j == 2) {
                    System.out.println("Nigga");
                } else {
                    tileList.add(new Tile("tile" + i + j));
                }
            }
        }
        System.out.println(tileList.toString());
        playerPurchasedLand = false;
    }

    public void dropMule(String name) {
        Tile temp = getTileFromList(name);
        temp.createMule();
        System.out.println("Mule dropped here.");
    }

    public Tile getTileFromList(String name) {
        for(Tile t : tileList) {
            if(t.getTileName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public boolean tileIsOwned(String name) {
        System.out.println(getTileFromList(name).getTileName());
        System.out.println("tileIsOwned: " + getTileFromList(name).getIsClaimed());
        return getTileFromList(name).getIsClaimed();
    }

    public void connectTile(String name) {
        try {
            if(PlayerDB.getPlayer(currentPlayer).getMoney() >= 100) {
                System.out.println("hello");
                if(!playerPurchasedLand) {
                    getTileFromList(name).setIsClaimed(true);
                    System.out.println("After connect tile: " + getTileFromList(name).getIsClaimed());
                    PlayerDB.getPlayer(currentPlayer).addTilestoPlayerList(getTileFromList(name));
                    PlayerDB.getPlayer(currentPlayer).subtractMoney(100);
                    playerPurchasedLand = true;
                } else {
                    System.out.println("Land already purchased in your turn.");
                }

            } else {
                System.out.println("You do not have enough" +
                        "money to buy this land!");
            }
        } catch(NullPointerException e) {
            e.getStackTrace();
        }

    }

    public static void setNumberOfPlayers(int num) {
        numberOfPlayers = num;
    }

    public int nextTurn() {
        currentTurn++;
        Map1Controller.timer();
        playerPurchasedLand = false;
        int n = nextPlayer();
        System.out.println("nextTurn = " + n);
        return n;
    }

    private void nextTurnLogic() {

        if (currentTurn > 2) {
            this.harvest();
        }
    }

    public void landGrant() {

    }

    public boolean isLandGrantPhase() {
        return (currentTurn < 2);
    }

    public void harvest()  {
        for(Tile t : tileList) {
            t.calculateProduction();
        }
    }

    public void runGame() {

    }

    public int getCurrentTurnNumber() {
        return currentTurn;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    private int nextPlayer() {
//        System.out.println("getNumberofPlayers " + numberOfPlayers);
        if(currentPlayer >= numberOfPlayers) {
            currentPlayer = 1;
        } else {
            currentPlayer++;
        }
        return currentPlayer;
    }
}
