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
        int currentSmithore = temp.getSmithore();
        //Player 1 buys a Tile, an appropriately outfitted Mule, and then
        //installs the outfited Mule on a Tile that's resource matches
        // the Mule outfit type
        temp.nextTurn();
        temp.buyTile("tile20");
        temp.buyMule("Energy");
        temp.dropMule("tile20");
        int currentEnergy = temp.getEnergy();
        //Player 2 buys a Tile, an appropriately outfitted Mule, and then
        //installs the outfited Mule on a Tile that's resource matches
        // the Mule outfit type
        temp.nextTurn();
        Tile tile01 = temp.getTileFromList("tile01");
        Mule residentMule = tile01.getResidentMule();
        assertNotNull(residentMule);
        assertTrue(tile01.getIsInstalled());
        int harvestOre = temp.getSmithore();
        temp.nextTurn();
        Tile tile20 = temp.getTileFromList("tile20");
        residentMule = tile20.getResidentMule();
        assertNotNull(residentMule);
        assertTrue(tile20.getIsInstalled());
        int harvestEnergy = temp.getEnergy();
        //production is calculated for both players
        //it goes through 2 turns so both should be increased by 200
        //100 per turn
        assertEquals(currentSmithore+200, harvestOre);
        assertEquals(currentEnergy+200, harvestEnergy);


    }
}
/*
Mule smithoreMule = (new Mule(null, "SmithOre"));
Mule energyMule = (new Mule(null, "Energy"));
Mule foodMule = (new Mule(null, "Food"));
*/