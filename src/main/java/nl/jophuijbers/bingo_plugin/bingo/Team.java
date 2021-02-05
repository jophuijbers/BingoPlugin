package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Team {

    private final ArrayList<Player> players;
    private final Card card;
    private final String name;

    public Team(String name, Card card) {
        this.name = name;
        this.card = card;
        players = new ArrayList<>();
    }

    public void join(Player player) {
        players.add(player);
    }
    public void leave(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }
}
