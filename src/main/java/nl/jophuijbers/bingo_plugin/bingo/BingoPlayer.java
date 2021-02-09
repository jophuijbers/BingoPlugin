package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.entity.Player;

public class BingoPlayer {
    private Player player;
    private Lobby lobby;
    private Team team;

    public BingoPlayer(Player player) {
        this.player = player;
    }

    public BingoPlayer(Player player, Lobby lobby) {
        this.player = player;
        this.lobby = lobby;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
