package teamJankkk.tests;

import org.junit.Before;
import org.junit.Test;
import teamJankkk.model.Mule;
import static org.junit.Assert.*;
import teamJankkk.model.Game;
import teamJankkk.model.Tile;

/**
 * Created by nik on 11/4/15.
 */
public class MuleInstalledTest {

    Game temp;

    @Before
    public void setup() {
        temp = new Game();
        temp.createPlayer("WillMyMuleInstall", "Leggite", "Red", 1);
        temp.createPlayer("IthinkMineWill", "Bonzoid", "Purple", 2);
        temp.setNumberOfPlayers(2);
    }

    @Test
    public void muleInstalledTest() {
        setup();
        temp.buyTile("tile01");
        temp.buyMule("SmithOre");
        temp.dropMule("tile01");
        //Player 1 buys a Tile, an appropriately outfitted Mule, and then
        //installs the outfited Mule on a Tile that's resource matches
        // the Mule outfit type
        temp.nextTurn();
        temp.buyTile("tile20");
        temp.buyMule("Food");
        temp.dropMule("tile20");
        //Player 2 buys a Tile, an appropriately outfitted Mule, and then
        //installs the outfited Mule on a Tile that's resource matches
        // the Mule outfit type
        int currentFood = temp.getFood();
        temp.nextTurn();
        Tile tile01 = temp.getTileFromList("tile01");
        Mule residentMule = tile01.getResidentMule();
        assertNotNull(residentMule);
        assertTrue(tile01.getIsInstalled());
        int currentSmithore = temp.getSmithore();
        temp.harvest();
        //production is calculated for both players
        int harvestOre = temp.getSmithore();
        temp.nextTurn();
        int harvestFood = temp.getFood();
        assertEquals(currentSmithore+100, harvestOre);
        assertEquals(currentFood+200, harvestFood);
    }
}
/*
Mule smithoreMule = (new Mule(null, "SmithOre"));
Mule energyMule = (new Mule(null, "Energy"));
Mule foodMule = (new Mule(null, "Food"));
*/