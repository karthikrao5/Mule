package teamJankkk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by karthik on 9/24/15.
 */
public class Tile {

    List<String> resourceList;
    private String resource;
    private Boolean isClaimed;
    private Boolean isInstalled;
    private Player owner;

    public Tile() {
        resourceList = new ArrayList<>(Arrays.asList("SmithOre",
                "Energy", "Food"));
        Random rand = new Random();
        resource = resourceList.get(rand.nextInt(2));
        isClaimed = false;
    }

    public void setOwner(int p) {
        owner = PlayerDB.getPlayer(p);
    }

    public String getResource() {
        return resource;
    }

    public Player getOwner() {
        return owner;
    }

    public void setIsClaimed(boolean bool) {
        isClaimed = bool;
    }

    public boolean getIsClaimed() {
        return isClaimed;
    }

    public int harvestResource() {
        return (int) Math.random();
    }
}
