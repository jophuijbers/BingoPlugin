package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public abstract class Message {
    static String WELCOME() { return "Welcome to " + ChatColor.LIGHT_PURPLE + "minecraft bingo"; }

    static String PLAYER_JOIN(BingoPlayer player) {
        return player.getPlayer().getName() + ChatColor.GREEN + " joined the lobby (" + player.getLobby().getPlayers().size() + "/" + player.getLobby().getMaxPlayers() + ")";
    }
    static String PLAYER_LEAVE(String name) {
        return name + ChatColor.RED + " left the lobby";
    }
    static String PLAYER_NOT_IN_LOBBY() {
        return ChatColor.RED + "You have not yet joined a lobby";
    }
    static String PLAYER_ALREADY_IN_LOBBY() {
        return ChatColor.RED + "You are already in a lobby";
    }

    static String LOBBY_FULL() {
        return "Lobby is " + ChatColor.RED + "full";
    }

    static String TEAM_WON(Team team) {
        return "The winner is " + team.getColor() + team.getName();
    }
    static String TEAM_JOIN(Team team) {
        return "You joined " + team.getColor() + team.getName();
    }

    static String GAME_STARTED() {
        return "Bingo started";
    }
    static String GAME_ALREADY_STARTED() {
        return "Lobby is " + ChatColor.RED + "already in a game";
    }

    static String ITEM_FOUND(BingoPlayer finder, String item) {
        return finder.getTeam().getColor() + finder.getPlayer().getName() + ChatColor.WHITE + " found " + ChatColor.GREEN + item.toLowerCase().replace("_", " ");
    }
    static String BINGO() {
        return ChatColor.LIGHT_PURPLE + "BINGOOO...";
    }
}
