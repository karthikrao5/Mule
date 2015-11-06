package teamJankkk.tests;

import org.junit.Before;
import org.junit.Test;
import teamJankkk.model.Game;
import teamJankkk.model.Tile;

import static org.junit.Assert.*;

/**
 * Created by KRose on 11/5/15.
 */
public class BuyTileTest {

    Game game;
    public static final int TIMEOUT = 200;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test(timeout = TIMEOUT)
    public void testBuyWithSufficientMoney() {
        game.createPlayer("P1", "Bonzoid", "Red", 1);
        int money = game.getMoney();
        Tile tile = game.getTileFromList("tile11");
        game.buyTile("tile11");
        assertTrue(tile.getIsClaimed());
        assertEquals(game.getCurrentPlayer(), tile.getTileOwner());
        assertEquals((money - 100), game.getMoney());
        assertTrue(game.getIsSelectedLandInCurrentTurn());
    }

    @Test(timeout = TIMEOUT)
    public void testBuyWithNoMoney() {
        game.createPlayer("P1", "Jankktron", "Blue", 1);
        game.subtractMoney(1500);
        int money = game.getCurrentPlayer().getMoney();
        Tile tile = game.getTileFromList("tile10");
        game.buyTile("tile10");
        assertTrue((money < 100));
        assertFalse(tile.getIsClaimed());
    }

    @Test(timeout = TIMEOUT)
    public void testPlayerHasAlreadyBoughtLand() {
        game.createPlayer("P1", "Leggite", "Purple", 1);
        Tile tile1 = game.getTileFromList("tile31");
        game.buyTile("tile31");
        assertTrue(tile1.getIsClaimed());
        assertEquals(game.getCurrentPlayer(), tile1.getTileOwner());
        assertTrue(game.getIsSelectedLandInCurrentTurn());
        Tile tile2 = game.getTileFromList("tile13");
        game.buyTile("tile13");
        assertFalse(tile2.getIsClaimed());
    }
}
