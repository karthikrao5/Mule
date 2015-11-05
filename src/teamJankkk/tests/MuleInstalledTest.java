package teamJankkk.tests;

import org.junit.Before;
import org.junit.Test;
import teamJankkk.model.Mule;

import static org.junit.Assert.*;

/**
 * Created by nik on 11/4/15.
 */
public class MuleInstalledTest {

    @Before
    public void setup() {

    }

    @Test
    public void playerCreationTest() {
        //Player p = (new Player("Name", null, null));
        Mule m = (new Mule());
        assertNotNull(m);
    }
}
