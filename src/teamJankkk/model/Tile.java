package teamJankkk.model;

import teamJankkk.controller.BuyMuleController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by karthik on 9/24/15.
 */
public class Tile implements Serializable{

    private String resource;
    private Boolean isClaimed;
    private Boolean isInstalled;
    private String tileName;
    private Player owner;
    private Mule residentMule;
    private String imageURL;

    public Tile(String tileName) {
        this.tileName = tileName;
        isClaimed = false;
        isInstalled = false;
        owner = null;
        residentMule = null;

    }

    public void setImageURL(String input) {
        imageURL = input;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setResidentMule(Mule mule) {
        residentMule = mule;
    }

    public Mule getResidentMule() {
        return residentMule;
    }

    public void setTileOwner(Player p) {
        owner = p;
    }

    public Player getTileOwner() {
        return owner;
    }

    public boolean getIsInstalled() {
        return isInstalled;
    }

    public void setIsInstalled(Boolean bool) {
        isInstalled = bool;
    }

    public void setResource(String input) {
        resource = input;
    }

    public String getTileName() {
        return tileName;
    }

    public String getResource() {
        return resource;
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
