package nl.jophuijbers.bingo_plugin.bingo;

import nl.jophuijbers.bingo_plugin.bingo.Item;

import java.util.ArrayList;

public class Card {

    private final ArrayList<Item> items;

    public Card() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
