package nl.jophuijbers.bingo_plugin.bingo;

import nl.jophuijbers.bingo_plugin.Main;
import nl.jophuijbers.bingo_plugin.bingo.Card;
import nl.jophuijbers.bingo_plugin.bingo.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Game {

    private final Plugin plugin;
    private boolean isStarted;

    private final int maxPlayers = 1;
    private ArrayList<Team> teams;

    public Game(Plugin plugin) {
        this.plugin = plugin;
        reset();
    }

    public Card getCard() {
        Card card = new Card();
        card.addItem(new Item(Material.WHEAT_SEEDS));
        card.addItem(new Item(Material.DIRT));
        card.addItem(new Item(Material.OAK_LOG));
        return card;
    }

    public void start() {
        isStarted = true;
        Bukkit.broadcastMessage(ChatColor.YELLOW + "GAME STARTED");
    }
    public void stop() {
        isStarted = false;
        Bukkit.broadcastMessage(ChatColor.YELLOW + "GAME ENDED");
    }

    public void playerPickUpItem(Material item, Player player) {
        checkItem(item, player);
        checkBingo(getTeam(player));
    }

    public void checkItem(Material itemPickedUp, Player player) {
        for (Item item : getTeam(player).getCard().getItems()) {
            if (itemPickedUp == item.getMaterial()) {
                item.setFound(true);
                player.sendMessage(ChatColor.YELLOW + "YOU FOUND " + itemPickedUp.name());
            }
        }
    }

    public void checkBingo(Team team) {
        for (Item item : team.getCard().getItems()) {
            if (!item.isFound()) {
                return;
            }
        }
        win(team);
    }

    public void win(Team team) {
        Bukkit.broadcastMessage(ChatColor.YELLOW + "BINGO! - " + team.getName().toUpperCase() + " WON!");
        stop();
        reset();
    }

    public void joinTeam(Player player) {
        if (!isStarted) {
            for (Team team : teams) {
                if (team.getPlayers().size() < maxPlayers) {
                    team.join(player);
                    player.sendMessage(ChatColor.BLUE + "YOU JOINED TEAM " + team.getName().toUpperCase());
                    return;
                }
            }
            player.sendMessage(ChatColor.RED + "ALL TEAMS ARE FULL");
        } else {
            player.sendMessage(ChatColor.RED + "GAME ALREADY STARTED");
        }
    }

    public void leaveTeam(Player player) {
        if (!isStarted) {
            Team team = getTeam(player);
            if (team != null) {
                team.leave(player);
                player.sendMessage(ChatColor.BLUE + "YOU LEFT TEAM " + team.getName().toUpperCase());
            }
            player.sendMessage(ChatColor.RED + "YOU ARE NOT YET IN A TEAM");
        }
        player.sendMessage(ChatColor.RED + "GAME ALREADY STARTED");
    }

    public Team getTeam(Player player) {
        for (Team team : teams) {
            if (team.getPlayers().contains(player)) {
                return team;
            }
        }
        return null;
    }

    public void reset() {
        teams = new ArrayList<>();
        teams.add(new Team("Team 1", getCard()));
        teams.add(new Team("Team 2", getCard()));
    }
}
