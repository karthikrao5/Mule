package teamJankkk.model;

import java.io.Serializable;

/**
 * Created by karthik on 9/21/15.
 */
public class Mule implements Serializable{
    private String outfit;
    private Boolean hasOutfit;
    private Boolean isInstalled;
    private Tile tileThatOwnsMule;

    public Mule(String tileName, String resource) {
        this.outfit = resource;
        this.isInstalled = false;
        this.hasOutfit = false;
    }

    public void setTileThatOwnsMule(Tile tile) {
        tileThatOwnsMule = tile;
    }

    public Tile getTileThatOwnsMule() {
        return tileThatOwnsMule;
    }

    public String getMuleType() {
        return outfit;
    }

    public String getOutfit() {
        return this.outfit;
    }

    public Boolean getIsInstalled() { return this.isInstalled;}

    public Boolean getHasOutfit() { return true;}

    public void setOutfit(String input) {
        this.outfit = input;
        this.hasOutfit = true;
    }

    public void removeOutfit() {
        this.outfit = "";
        this.hasOutfit = false;
    }
}
