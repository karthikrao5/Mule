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
    private Boolean isEmpty;
    private Player owner;

    public Tile(String resource, boolean bool) {
        resourceList = new ArrayList<>(Arrays.asList("SmithOre",
                "Energy", "Food"));
        isEmpty = bool;
        Random rand = new Random();
        resource = resourceList.get(rand.nextInt(2));
    }

    public void setOwner(int p) {
        owner = PlayerDB.getPlayer(p);
    }

    public Player getOwner() {
        return owner;
    }

    public void setIsEmpty(boolean bool) {
        isEmpty = bool;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public int harvestResource() {
        return (int) Math.random();
    }
}
