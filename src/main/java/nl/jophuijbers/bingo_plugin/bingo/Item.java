package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.Material;

public class Item {

    private final Material material;
    private boolean isFound = false;

    public Item(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }
}
