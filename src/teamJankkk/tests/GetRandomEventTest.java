package teamJankkk.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import teamJankkk.model.Game;
import teamJankkk.model.Tile;

/**
 * Created by johnhudgins on 11/6/15.
 */
public class GetRandomEventTest {

    private Game jGame;
    @Before
    public void setUp() {
        jGame = new Game();
        jGame.createPlayer("P1", "Bonzoid", "Red", 1);
        int money = jGame.getMoney();
        Tile tile = jGame.getTileFromList("tile11");
        jGame.buyTile("tile11");
    }

    @Test
    public void testEvents() {
        Assert.assertTrue(jGame.getRandomEvent(0)[0].equals("OH CRAP A ROBBER"));
        Assert.assertTrue(jGame.getRandomEvent(1)[0].equals("YOU SUCK"));
        Assert.assertTrue(jGame.getRandomEvent(2)[0].equals("YOUR TURN IS OVER"));
        Assert.assertTrue(jGame.getRandomEvent(3)[0].equals("Just incase you were tired..."));
        Assert.assertTrue(jGame.getRandomEvent(4)[0].equals("WE HAVE SOLVED WORLD HUNGER"));
        Assert.assertTrue(jGame.getRandomEvent(5)[0].equals("NEW SMITHORE!!!"));
        Assert.assertTrue(jGame.getRandomEvent(6)[0].equals("NEW MONEY!"));
    }
}