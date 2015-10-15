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
    private int owner;
    private String tileName;
    private Mule mule;

    public Tile(String inputName) {
        tileName = inputName;
        resourceList = new ArrayList<>(Arrays.asList("SmithOre",
                "Energy", "Food"));
        Random rand = new Random();
        resource = resourceList.get(rand.nextInt(2));
        isClaimed = false;
        mule = null;
    }

    public void createMule() {
        if(mule.getMuleType().equals(resource)) {
            mule = new Mule(resource);
            isInstalled = true;
            System.out.println("Mule created.");
        }
    }

    public String getTileName() {
        return tileName;
    }

    public void setOwner(int p) {
        owner = p;
        isClaimed = true;
        //owner = PlayerDB.getPlayer(p);
    }

    public String getResource() {
        return resource;
    }

//    public Player getOwner() {
//        return owner;
//    }

    public void setIsClaimed(boolean bool) {
        isClaimed = bool;
    }

    public boolean getIsClaimed() {
        return isClaimed;
    }

    public boolean getIsInstalled() {
        return isInstalled;
    }

    public int harvestResource() {
        return (int) Math.random();
    }

    public void calculateProduction() {
        if (!isInstalled) {
            System.out.println("Land piece isn't Installed;");
        } else {

        }
    }
}
