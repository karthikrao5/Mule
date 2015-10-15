package teamJankkk.model;

/**
 * Created by karthik on 9/21/15.
 */
public class Mule {
    private String outfit;
    private Boolean hasOutfit;
    private Boolean isInstalled;
    private Tile muleTile;

    public Mule(String outfit) {
        this.outfit = outfit;
        this.isInstalled = false;
        this.hasOutfit = false;
    }

    public String getMuleType() {
        return outfit;
    }

    public String getOutfit() {
        return this.outfit;
    }

    public void setOutfit(String input) {
        this.outfit = input;
        this.hasOutfit = true;
    }

    public void setTile(Tile input) {
        this.muleTile = input;
        this.isInstalled = true;
    }

    public void removeOutfit() {
        this.outfit = "";
        this.hasOutfit = false;
    }
}