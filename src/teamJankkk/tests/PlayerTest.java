package teamJankkk.tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import teamJankkk.model.Player;

/**
 * Created by karthik on 11/4/15.
 */
public class PlayerTest {

    @Before
    public void setup() {

    }

    @Test
    public void playerCreationTest() {
        Player p = (new Player("Name", null, null));
        assertNotNull(p);
    }
}
