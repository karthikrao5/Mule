package teamJankkk.model;

import teamJankkk.controller.BuyMuleController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by karthik on 9/24/15.
 */
public class Tile {


    private String resource;
    private Boolean isClaimed;
    private Boolean isInstalled;
    private int owner;
    private String tileName;
    private Mule mule;

    public Tile(String inputName) {
        tileName = inputName;
//        Random rand = new Random();
//        resource = resourceList.get(rand.nextInt(2));
        isClaimed = false;
        isInstalled = false;
        mule = null;
    }

    public void createMule() {
        if(BuyMuleController.hasMule) {
            System.out.println("inside hasMule");
            System.out.println("This tile's resource is : " + resource);
            System.out.println("buymulecontroller: " + BuyMuleController.outfitString);
            if(BuyMuleController.outfitString.equals(resource)) {
                System.out.println("inside muletype equals");
                Mule newMule = new Mule(BuyMuleController.outfitString);
                isInstalled = true;
                newMule.setTile(this);
                System.out.println("Mule created.");
                System.out.println("Mule belongs to :" + newMule.getTile());
            }
        }
    }

    public void setResource(String input) {
        resource = input;
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
        if (!this.isInstalled) {
            System.out.println("Land piece isn't Installed");
        } else {
            String theType = this.getResource();
            if (theType.equals("SmithOre")) {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).addSmithore(100);
            } else if (theType.equals("Energy")) {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).addEnergy(100);
            } else if (theType.equals("Food")) {
                PlayerDB.getPlayer(Game.getCurrentPlayer()).addFood(100);
            }
        }
    }

    public boolean isInstalled() {
        return isInstalled;
    }
}
