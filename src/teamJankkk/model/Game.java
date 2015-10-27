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
    Mule boughtMule;
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


    //====================TILE METHODS====================================
    public boolean getPlayerIsBoughtMule() {
        return getCurrentPlayer().isBoughtMule();
    }

    public void setPlayerIsBoughtMule(Boolean bool) {
        getCurrentPlayer().setIsBoughtMule(bool);
    }

    public void dropMule(String name) {

        if(playerPurchasedLand) {
            Tile currTile = getTileFromList(name);
            if(currTile.getTileOwner().equals(getCurrentPlayer())) {
                if(getCurrentPlayer().isBoughtMule()
                        && boughtMule.getOutfit().equals(currTile.getResource())) {
                    boughtMule.setTileThatOwnsMule(currTile);
                    getCurrentPlayer().setIsBoughtMule(false);
                }
            }

        } else {
            System.out.println("You do not have a mule purchased.");
        }
    }

    public void buyMule(String outfit) {
        boughtMule = new Mule(null, outfit);
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
//        System.out.println(getTileFromList(name).getTileName() + " contains" +
//                " " + getTileFromList(name).getResource());
//        System.out.println("tileIsOwned: " + getTileFromList(name).getIsClaimed() + " by: " + database.getPlayer(currentPlayer).getName());
        return getTileFromList(name).getIsClaimed();
    }

    public void buyTile(String name) {
        try {
            if (getCurrentPlayer().getMoney() >= 100) {
                System.out.println("playerPurchasedLand: " + playerPurchasedLand);
                if (!playerPurchasedLand) {
                    System.out.println("INside !playerPurchasedLand");
                    Tile currTile = getTileFromList(name);
                    currTile.setIsClaimed(true);
                    currTile.setTileOwner(getCurrentPlayer());
                    getCurrentPlayer().addTilestoPlayerList(currTile);
                    getCurrentPlayer().subtractMoney(100);
                    System.out.println("Mule's tile location: "
                            + currTile.getResidentMule().getTileThatOwnsMule().getTileName());
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

    public List<Tile> getTileList() {
        return tileList;
    }

    public boolean isTileOwned(String tileName) {
        for(Tile t : database.getPlayer(currentPlayer).getTileList()) {
            if(t.getTileName().equals(tileName)) {
                return true;
            }
        }
        return false;
    }



    //====================GAME STATE METHODS============================


    public boolean getIsSelectedLandInCurrentTurn() {
        System.out.println("getIsSelectedLandInCurrentTurn returning: " + playerPurchasedLand);
        return playerPurchasedLand;
    }

    public void setIsSelectedLandInCurrentTurn(Boolean bool) {
        playerPurchasedLand = bool;
    }

    public void setNumberOfPlayers(int num) {
        numberOfPlayers = num;
    }

    public int nextTurn() {
        currentTurn++;
        //Map1Controller.timer();
        playerPurchasedLand = false;

        if (currentPlayer >= numberOfPlayers) {
            currentPlayer = 1;
        } else {
            currentPlayer++;
        }
        harvest();
        return currentPlayer;
    }

    public boolean isLandGrantPhase() {
        return (currentTurn < 2);
    }

    public void harvest() {
        calculateProduction();
    }


    public int getCurrentTurnNumber() {
        return currentTurn;
    }

    public Player getCurrentPlayer() {
        return database.getPlayer(currentPlayer);
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
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


    //===========================RESOURCE METHODS==================================


    public int getMoney() {
        return database.getPlayer(currentPlayer).getMoney();
    }

    public int getEnergy() {
        return database.getPlayer(currentPlayer).getEnergy();
    }

    public int getFood() {
        return database.getPlayer(currentPlayer).getFood();
    }

    public int getSmithore() {
        return database.getPlayer(currentPlayer).getSmithore();

    }

//    public Player getPlayer(int index) {
//        return database.getPlayer(index);
//    }

    public String getColor() {
        return database.getPlayer(currentPlayer).getColor();
    }

//    public int getMoney(int index) {
//        return database.getPlayer(index).getMoney();
//    }


    public void addEnergy(int amount) {
        database.getPlayer(currentPlayer).addEnergy(amount);
    }

    public void addSmithore(int amount) {
        database.getPlayer(currentPlayer).addSmithore(amount);
    }

    public void addFood(int amount) {
        database.getPlayer(currentPlayer).addFood(amount);
    }

    public void addMoney(int amount) {
        database.getPlayer(currentPlayer).addMoney(amount);
    }

    public void subtractMoney(int amount) {
        database.getPlayer(currentPlayer).subtractMoney(amount);
    }

    public void subtractEnergy(int amount) {
        database.getPlayer(currentPlayer).subtractEnergy(amount);
    }

    public void subtractSmithore(int amount) {
        database.getPlayer(currentPlayer).subtractSmithore(amount);
    }
    public void subtractFood(int amount) {
        database.getPlayer(currentPlayer).subtractFood(amount);
    }


    //================MARKET LOGIC================================

    public ArrayList<Integer> calculateMarket() {
        ArrayList<Integer> marketTotal = new ArrayList<>();
        int totalSmithore = 0;
        int totalEnergy = 0;
        int totalFood = 0;
        int totalMoney = 0;

        for(Player p : database.dbKeySet()) {
            totalSmithore += p.getSmithore();
            totalEnergy += p.getEnergy();
            totalFood += p.getFood();
            totalMoney = p.getMoney();
        }
        marketTotal.add(totalSmithore);
        marketTotal.add(totalEnergy);
        marketTotal.add(totalEnergy);
        marketTotal.add(totalMoney);
        return marketTotal;

    }

    public void calculateProduction() {
        for(Player p : database.dbKeySet()) {
            for(Tile t : p.getTileList()) {
                if (!t.getIsInstalled()) {
                    System.out.println("Land piece isn't Installed");
                } else {
                    String theType = t.getResource();
                    if (theType.equals("SmithOre")) {
                        p.addSmithore(100);
                    } else if (theType.equals("Energy")) {
                        p.addEnergy(100);
                    } else if (theType.equals("Food")) {
                        p.addFood(100);
                    }
                }
            }
        }
    }
}
