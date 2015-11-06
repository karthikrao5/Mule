package teamJankkk.tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import teamJankkk.model.Game;
import teamJankkk.model.Player;

import java.util.ArrayList;


/**
 * Created by karthik on 11/6/15.
 */
public class ResourceProductionTest {
    private Game game;
    private Player p1, p2;

    @Before
    public void setup() {
        game = new Game();
        game.createPlayer("Kmoney", "Bonzoid", "Red", 1);
        game.createPlayer("Dankkk", "Jankktron", "Purple", 2);
        for(Player p : game.getPlayerSet().keySet()) {
            if(p.getName().equals("Kmoney")) {
                p1 = p;
            } else {
                p2 = p;
            }
        }
    }

    @Test
    public void testPlayerInitialResources() {
        assertEquals(p1.getEnergy(), 0);
        assertEquals(p1.getSmithore(), 0);
        assertEquals(p1.getFood(), 0);
        assertEquals(p1.getMoney(), 1500);

        assertEquals(p2.getEnergy(), 0);
        assertEquals(p2.getSmithore(), 0);
        assertEquals(p2.getFood(), 0);
        assertEquals(p2.getMoney(), 1500);
    }

    @Test
    public void testAddMethods() {

        System.out.println(game.getCurrentPlayer().getName());
        assertEquals(game.getCurrentPlayer(), p1);
        game.addEnergy(200);
        game.addFood(100);
        game.addMoney(200);
        game.addSmithore(200);
        assertEquals(p1.getEnergy(), 200);
        assertEquals(p1.getFood(), 100);
        assertEquals(p1.getMoney(), 1700);
        assertEquals(p1.getSmithore(), 200);

        game.nextTurn();

        System.out.println(game.getCurrentPlayer().getName());
        assertEquals(game.getCurrentPlayer(), p2);
        game.addEnergy(200);
        game.addFood(100);
        game.addMoney(200);
        game.addSmithore(200);
        assertEquals(p2.getEnergy(), 200);
        assertEquals(p2.getFood(), 100);
        assertEquals(p2.getMoney(), 1700);
        assertEquals(p2.getSmithore(), 200);
    }

    @Test
    public void testMarketCalculation() {
        p1.addEnergy(100);
        p1.addFood(500);
        p1.addMoney(600);
        p1.addSmithore(100);

        p2.addEnergy(900);
        p2.addFood(1000);
        p2.addMoney(300);
        p2.addSmithore(800);

        ArrayList<Integer> marketTotals = game.calculateMarket();
        System.out.println(marketTotals.toString());
        assertEquals(marketTotals.get(0), (Integer) 900);
        assertEquals(marketTotals.get(1), (Integer) 1000);
        assertEquals(marketTotals.get(2), (Integer) 1500);
        assertEquals(marketTotals.get(3), (Integer) 3900);
    }

    @Test
    public void testPlayerResourceProduction() {
        assertNotNull(game.getPlayerSet());
        game.buyTile("tile12");
        assertTrue(game.getTileFromList("tile12").getIsClaimed());
        assertEquals(game.getTileFromList("tile12").getResource(), "SmithOre");
        assertEquals(game.getCurrentPlayer(), p1);
        assertEquals(game.getCurrentPlayer().getSmithore(), p1.getSmithore());
        game.calculateProduction();
        assertEquals(game.getCurrentPlayer().getSmithore(), 100);
    }
}
