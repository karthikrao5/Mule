package teamJankkk.model;

/**
 * Created by karthik on 9/24/15.
 */
public class Tile {

    private String resource;
    private Boolean isEmpty;
    private Player owner;

    public Tile(String resource) {
        this.resource = resource;
    }

    public void setOwner(Player p) {
        owner = p;
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
}
