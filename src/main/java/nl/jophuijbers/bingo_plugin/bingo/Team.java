package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.ChatColor;
import org.bukkit.Color;

import java.util.ArrayList;

public class Team {

    private final ArrayList<BingoPlayer> players;
    private final Card card;
    private final String name;
    private boolean winner;
    private ChatColor color;

    public Team(String name, ChatColor color, Card card) {
        this.name = name;
        this.color = color;
        this.card = card;
        players = new ArrayList<>();
    }

    public void join(BingoPlayer player) {
        players.add(player);
    }
    public void leave(BingoPlayer player) {
        players.remove(player);
    }

    public ArrayList<BingoPlayer> getPlayers() {
        return players;
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public ChatColor getColor() {
        return color;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }
}
