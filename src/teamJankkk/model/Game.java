package teamJankkk.model;

import teamJankkk.controller.BuyMuleController;
import teamJankkk.controller.ConfigController;
import teamJankkk.controller.Map1Controller;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by karthik on 9/23/15.
 */
public class Game {

//    PlayerDB database;
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
    private HashMap<Player, Integer> database;

    public Game() {
//        database = new PlayerDB();
        database = new HashMap<>();
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
                        (i == 3 && j == 4) || (i == 2 && (j == 0 || j == 1 ||
                    j == 3 || j == 4))) {

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
        for(Tile t : getCurrentPlayer().getTileList()) {
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
        for(Map.Entry<Player, Integer> p : database.entrySet()) {
            if(p.getValue().compareTo(currentPlayer) == 0) {
                return p.getKey();
            }
        }
//        return database.get(currentPlayer);
        return null;
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

//    private Set<Map.Entry<Player, Integer>> getEntrySet() {
//        return database.entrySet();
//    }

    public void createPlayer(String name, int index) {
//        database.add(index, new Player(name, null, null));
        database.put(new Player(name, null, null), index);
    }

    public void setRace(String name, int index) {
        getCurrentPlayer().setRace(name);
//        database.get(index).setRace(name);
//        database.setRace(name, index);
    }

    public void setColor(String name, int index) {
        getCurrentPlayer().setColor(name);
//        database.get(index).setColor(name);
//        database.setColor(name, index);
    }

    public String getColor() {
        return getCurrentPlayer().getColor();
//        return database.get(currentPlayer).getColor();
    }


    //===========================RESOURCE METHODS==================================


    public int getMoney() {
        return getCurrentPlayer().getMoney();
//        return database.get(currentPlayer).getMoney();
    }

    public int getEnergy() {
        return getCurrentPlayer().getEnergy();
    }

    public int getFood() {
        return getCurrentPlayer().getFood();
//        return database.get(currentPlayer).getFood();
    }

    public int getSmithore() {
        return getCurrentPlayer().getSmithore();
//        return database.get(currentPlayer).getSmithore();

    }

//    public Player getPlayer(int index) {
//        return database.getPlayer(index);
//    }


//    public int getMoney(int index) {
//        return database.getPlayer(index).getMoney();
//    }


    public void addEnergy(int amount) {
        getCurrentPlayer().addEnergy(amount);
//        database.get(currentPlayer).addEnergy(amount);
    }

    public void addSmithore(int amount) {
        getCurrentPlayer().addSmithore(amount);
//        database.get(currentPlayer).addSmithore(amount);
    }

    public void addFood(int amount) {
        getCurrentPlayer().addFood(amount);
//        database.get(currentPlayer).addFood(amount);
    }

    public void addMoney(int amount) {
        getCurrentPlayer().addMoney(amount);
//        database.get(currentPlayer).addMoney(amount);
    }

    public void subtractMoney(int amount) {
        getCurrentPlayer().subtractMoney(amount);
//        database.get(currentPlayer).subtractMoney(amount);
    }

    public void subtractEnergy(int amount) {
        getCurrentPlayer().subtractEnergy(amount);
//        database.get(currentPlayer).subtractEnergy(amount);
    }

    public void subtractSmithore(int amount) {
        getCurrentPlayer().subtractSmithore(amount);
//        database.get(currentPlayer).subtractSmithore(amount);
    }
    public void subtractFood(int amount) {
        getCurrentPlayer().subtractFood(amount);
//        database.get(currentPlayer).subtractFood(amount);
    }


    //================MARKET LOGIC================================

    public ArrayList<Integer> calculateMarket() {
        ArrayList<Integer> marketTotal = new ArrayList<>();
        int totalSmithore = 0;
        int totalEnergy = 0;
        int totalFood = 0;
        int totalMoney = 0;

        for(Player p : database.keySet()) {
            totalSmithore += p.getSmithore();
            totalEnergy += p.getEnergy();
            totalFood += p.getFood();
            totalMoney += p.getMoney();
        }
        marketTotal.add(totalSmithore);
        marketTotal.add(totalEnergy);
        marketTotal.add(totalEnergy);
        marketTotal.add(totalMoney);
        return marketTotal;
        //returns an arraylist so AuctionHouseController
        //can display the market totals in labels
    }

    public int currentPlayerRank() {
        int thisPlayazScore = getCurrentPlayer().getScore();
        int returnRank = 0;

        for(Player p : database.keySet()) {
            if(p.getScore() <= getCurrentPlayer().getScore()) {
                returnRank++;
            }
        }
        
        return returnRank;
    }

    public String[] getRandomEvent(int number) {
        String[] theRandomEvent = new String[2];
        if (number == 0) {
            theRandomEvent[0] = "OH CRAP A ROBBER";
            theRandomEvent[1] = "Minus 100 cash, like stealing money from a baby!";
            getCurrentPlayer().subtractMoney(100);
        } else if (number == 1) {
            theRandomEvent[0] = "YOU SUCK";
            theRandomEvent[1] = "NO MORE CRYSTITE FOR YOU";
            getCurrentPlayer().subtractCrystite(100);
        } else if (number == 2) {
            theRandomEvent[0] = "YOUR TURN IS OVER";
            theRandomEvent[1] = "LOSERRRRR";
            int BITXCH = nextTurn();
        } else if (number == 3) {
            theRandomEvent[0] = "Just incase you were tired...";
            theRandomEvent[1] = "HAVE FUNERGY!!!!";
            getCurrentPlayer().addEnergy(100);
        } else if (number == 4) {
            theRandomEvent[0] = "WE HAVE SOLVED WORLD HUNGER";
            theRandomEvent[1] = "HERES SOME FREE FOOD";
            getCurrentPlayer().addFood(100);
        } else if (number == 5) {
            theRandomEvent[0] = "NEW SMITHORE!!!";
            theRandomEvent[1] = "HERES 100 FREE SMITHORE LUCKY DAY";
            getCurrentPlayer().addSmithore(100);
        } else if (number == 6) {
            theRandomEvent[0] = "NEW MONEY!";
            theRandomEvent[1] = "HERES 100 FREE CASH!!";
            getCurrentPlayer().addMoney(100);
        }
        return theRandomEvent;
    }

    public void calculateProduction() {
        for(Player p : database.keySet()) {
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
