package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BingoGame {

    private final ArrayList<BingoPlayer> players;
    private final Lobby lobby;

    public BingoGame() {
        players = new ArrayList<>();
        lobby = new Lobby("Lobby 1", 4);
    }

    public Card getCard() {
        Card card = new Card();
        card.addItem(new Item(Material.WHEAT_SEEDS));
        card.addItem(new Item(Material.DIRT));
        card.addItem(new Item(Material.OAK_LOG));
        return card;
    }

    public void playerPickUpItem(Material item, BingoPlayer player) {
        if (player.getLobby() != null) {
            if (player.getLobby().isStarted()) {
                if (isItemOnCard(item, player.getTeam().getCard())) {
                    itemFound(player, item);
                }
            }
        }
    }

    public boolean isItemOnCard(Material itemPickedUp, Card card) {
        for (Item item : card.getItems()) {
            if (itemPickedUp == item.getMaterial()) {
                item.setFound(true);
                return true;
            }
        }
        return false;
    }

    public void itemFound(BingoPlayer finder, Material item) {
        for (BingoPlayer player : finder.getTeam().getPlayers()) {
            player.getPlayer().sendMessage(Message.ITEM_FOUND(finder, item.name()));
        }
        checkBingo(finder.getTeam());
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
        for (BingoPlayer player : lobby.getPlayers()) {
            player.getPlayer().sendMessage(Message.BINGO());
            player.getPlayer().sendMessage(Message.TEAM_WON(team));
        }
        stop();
    }

    public void joinBingo(Player player) {
        players.add(new BingoPlayer(player));
        player.sendMessage(Message.WELCOME());

        ItemStack map = new ItemStack(Material.MAP, 1);
        player.getInventory().addItem(map);
    }

    public void start() {
        lobby.addTeam(new Team("team blue", ChatColor.BLUE, getCard()));
        lobby.addTeam(new Team("team red", ChatColor.RED, getCard()));

        int count = 0;
        for (BingoPlayer player : lobby.getPlayers()) {
            if (count % 2 == 0) {
                lobby.getTeams().get(0).join(player);
                player.setTeam(lobby.getTeams().get(0));
            } else {
                lobby.getTeams().get(1).join(player);
                player.setTeam(lobby.getTeams().get(1));
            }
            count++;
        }
        lobby.setStarted(true);
        lobby.getPlayers().forEach(player -> {
            player.getPlayer().sendMessage(Message.TEAM_JOIN(player.getTeam()));
            player.getPlayer().sendMessage(Message.GAME_STARTED());
        });

//        ItemStack map = new ItemStack(Material.MAP, 1);
//        for (BingoPlayer player : lobby.getPlayers()) {
//            player.getPlayer().getInventory().addItem(map);
//        }
    }

    public void stop() {
        // todo: count down
        lobby.getPlayers().forEach(p -> p.getPlayer().sendMessage(Message.PLAYER_LEAVE(p.getPlayer().getName())));
        lobby.setStarted(false);
        lobby.getPlayers().clear();
        lobby.getTeams().forEach(team -> team.getPlayers().clear());
    }

    public void joinLobby(BingoPlayer player) {
        if (player.getLobby() == null) {
            if (!lobby.isStarted()) {
                if (lobby.getPlayers().size() < lobby.getMaxPlayers()) {
                    lobby.join(player);
                    player.setLobby(lobby);
                    lobby.getPlayers().forEach(p -> p.getPlayer().sendMessage(Message.PLAYER_JOIN(player)));
                    if (lobby.getPlayers().size() == lobby.getMaxPlayers()) {
                        start();
                    }
                    return;
                }
                player.getPlayer().sendMessage(Message.LOBBY_FULL());
                return;
            }
            player.getPlayer().sendMessage(Message.GAME_ALREADY_STARTED());
            return;
        }
        player.getPlayer().sendMessage(Message.PLAYER_ALREADY_IN_LOBBY());
    }

    public void leaveLobby(BingoPlayer player) {
        if (player.getLobby() != null) {
            lobby.getPlayers().forEach(p -> p.getPlayer().sendMessage(Message.PLAYER_LEAVE(player.getPlayer().getName())));
            lobby.leave(player);
            player.setLobby(null);
            return;
        }
        player.getPlayer().sendMessage(Message.PLAYER_NOT_IN_LOBBY());
    }

    public BingoPlayer getBingoPlayer(Player player) {
        for (BingoPlayer bingoPlayer : players) {
            if (bingoPlayer.getPlayer().getUniqueId() == player.getUniqueId()) {
                return bingoPlayer;
            }
        }
        return null;
    }
}
