package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Lobby {

    private int maxPlayers;
    private String name;
    private final ArrayList<BingoPlayer> players;
    private final ArrayList<Team> teams;
    private boolean isStarted;

    public Lobby(String name, int maxPlayers) {
        players = new ArrayList<>();
        teams = new ArrayList<>();
        this.maxPlayers = maxPlayers;
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BingoPlayer> getPlayers() {
        return players;
    }

    public void join(BingoPlayer player) {
        players.add(player);
    }
    public void leave(BingoPlayer player) {
        players.remove(player);
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
    public void addTeam(Team team) {
        teams.add(team);
    }
}
