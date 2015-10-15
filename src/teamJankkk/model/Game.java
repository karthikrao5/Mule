package teamJankkk.model;

import teamJankkk.controller.BuyMuleController;
import teamJankkk.controller.ConfigController;
import teamJankkk.controller.Map1Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

    private static int currentTurn = 0;
    private static int numberOfPlayers = 0;
    private static int currentPlayer = 1;
    public boolean endGame = false;
    static List<Tile> tileList = new ArrayList<>();
    boolean playerPurchasedLand;
    List<String> resourceList = new ArrayList<>(Arrays.asList("SmithOre", "Energy",
            "Food"));
    Random rand;

    public Game() {

        rand = new Random();
        //x axis is i
        //y axis is j
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 2 && j == 2) {
                    System.out.println("Tiles instantiated.");
                } else if((i == 0 && j == 1) || (i == 1 && j == 2) ||
                        (i == 3 && j == 0) || (i == 1 && j == 4)){

                    Tile temp = new Tile("tile" + i + j);
                    temp.setResource("SmithOre");
                    tileList.add(temp);
                } else if((i == 0 && j == 2) || (i == 1 && j == 1) ||
                        (i == 3 && j == 1) || (i == 4 && j == 3) ||
                        (i == 3 && j == 4)) {

                    Tile temp = new Tile("tile" + i + j);
                    temp.setResource("Energy");
                    tileList.add(temp);

                } else if((i == 2 && j == 0) || (i == 2 && j == 1) ||
                        (i == 2 && j == 3) || (i == 2 && j == 4)) {
                    Tile temp = new Tile("tile" + i + j);
                    temp.setResource("Food");

                } else {
                    int random = rand.nextInt(2);
                    Tile temp = new Tile("tile" + i + j);
                    temp.setResource(resourceList.get(random));
                    tileList.add(temp);
                }
            }
        }
        playerPurchasedLand = false;
    }

    public void dropMule(String name) {
        Tile temp = getTileFromList(name);
        temp.createMule();
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
        System.out.println(getTileFromList(name).getTileName() + " and it contains" +
                " " + getTileFromList(name).getResource());
        System.out.println("tileIsOwned: " + getTileFromList(name).getIsClaimed() + " by: " + PlayerDB.getPlayer(currentPlayer).getName());
        return getTileFromList(name).getIsClaimed();
    }

    public void connectTile(String name) {
        try {
            if(PlayerDB.getPlayer(currentPlayer).getMoney() >= 100) {
                if(!playerPurchasedLand) {
                    getTileFromList(name).setIsClaimed(true);
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
        //Map1Controller.timer();
        playerPurchasedLand = false;
        int n = nextPlayer();
        System.out.println("nextTurn = " + n);
        nextTurnLogic();
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


    public static int getCurrentTurnNumber() {
        return currentTurn;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static List<Tile> getTileList()  {
        return tileList;
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
