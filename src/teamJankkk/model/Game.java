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

    PlayerDB database;
    int currentTurn = 0;
    int numberOfPlayers = 0;
    int currentPlayer = 1;
    boolean endGame = false;
    List<Tile> tileList = new ArrayList<>();
    boolean playerPurchasedLand;
    List<String> resourceList = new ArrayList<>(Arrays.asList("SmithOre", "Energy",
            "Food"));
    Random rand;


    int tempCurrentTurn = 0;
    int tempNumberOfPlayers = 0;
    int tempCurrentPlayer = 1;
    List<Tile> tempTileList = new ArrayList<>();


    public Game() {
        database = new PlayerDB();
        rand = new Random();
        //x axis is i
        //y axis is j
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Tiles instantiated.");
                } else if ((i == 0 && j == 1) || (i == 1 && j == 2) ||
                        (i == 3 && j == 0) || (i == 1 && j == 4)) {

                    Tile temp = new Tile("tile" + i + j);
                    temp.setResource("SmithOre");
                    tileList.add(temp);
                } else if ((i == 0 && j == 2) || (i == 1 && j == 1) ||
                        (i == 3 && j == 1) || (i == 4 && j == 3) ||
                        (i == 3 && j == 4)) {

                    Tile temp = new Tile("tile" + i + j);
                    temp.setResource("Energy");
                    tileList.add(temp);

                } else if ((i == 2 && j == 0) || (i == 2 && j == 1) ||
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
        for (Tile t : tileList) {
            if (t.getTileName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public boolean tileIsOwned(String name) {
        System.out.println(getTileFromList(name).getTileName() + " contains" +
                " " + getTileFromList(name).getResource());
        System.out.println("tileIsOwned: " + getTileFromList(name).getIsClaimed() + " by: " + database.getPlayer(currentPlayer).getName());
        return getTileFromList(name).getIsClaimed();
    }

    public void connectTile(String name) {
        try {
            if (database.getPlayer(currentPlayer).getMoney() >= 100) {
                if (!playerPurchasedLand) {
                    getTileFromList(name).setIsClaimed(true);
                    database.getPlayer(currentPlayer).addTilestoPlayerList(getTileFromList(name));
                    database.getPlayer(currentPlayer).subtractMoney(100);
                    playerPurchasedLand = true;
                } else {
                    System.out.println("Land already purchased in your turn.");
                }

            } else {
                System.out.println("You do not have enough" +
                        "money to buy this land!");
            }
        } catch (NullPointerException e) {
            e.getStackTrace();
        }

    }

    public void setNumberOfPlayers(int num) {
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

    private int nextPlayer() {
//        System.out.println("getNumberofPlayers " + numberOfPlayers);
        if (currentPlayer >= numberOfPlayers) {
            currentPlayer = 1;
        } else {
            currentPlayer++;
        }
        return currentPlayer;
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

    public void harvest() {
        List<Player> playerList = database.getPlayerList();
        for(Player p : playerList) {
            p.calculateProduction();
        }
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

    public List<Tile> getTileList() {
        return tileList;
    }


    public void saveGameState() {
        for (int i = 0; i < tileList.size(); i++) {
            tempTileList.add(tileList.get(i));
        }
        tempCurrentPlayer = currentPlayer;
        tempCurrentTurn = currentTurn;
        tempNumberOfPlayers = numberOfPlayers;

    }

    public void loadGameState() {
        for (int i = 0; i < tempTileList.size(); i++) {
            tileList.add(tempTileList.get(i));
        }
        currentPlayer = tempCurrentPlayer;
        currentTurn = tempCurrentTurn;
        numberOfPlayers = tempNumberOfPlayers;
    }

    public void createPlayer(String name, int index) {
        database.createPlayer(name, index);
    }

    public void setRace(String name, int index) {
        database.setRace(name, index);
    }

    public void setColor(String name, int index) {
        database.setColor(name, index);
    }

    public Player getPlayer(int index) {
        return database.getPlayer(index);
    }

    public String getColor(int index) {
        return database.getPlayer(index).getColor();
    }

    public int getMoney(int index) {
        return database.getPlayer(index).getMoney();
    }

    public void addSmithore(int index, int sum) {
        database.getPlayer(index).addSmithore(sum);
    }

    public void addEnergy(int index, int sum) {
        database.getPlayer(index).addEnergy(sum);
    }

    public void addFood(int index, int sum) {
        database.getPlayer(index).addFood(sum);
    }

    public int getMuleCount(int index) {
        return database.getPlayer(index).howManyMules();
    }

    public void subtractMoney(int index, int sum) {
        database.getPlayer(index).subtractMoney(sum);
    }

    public boolean isTileOwned(String tileName) {
        List<Tile> temp = database.getPlayer(currentPlayer).getTileList();
        for(Tile t : temp) {
            if(t.getTileName().equals(tileName)) {
                return true;
            }
        }
        return false;
    }

}
