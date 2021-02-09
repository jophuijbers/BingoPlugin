package nl.jophuijbers.bingo_plugin.bingo;

import nl.jophuijbers.bingo_plugin.commands.Bingo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game {

    private final ArrayList<BingoPlayer> players;
    private final Lobby lobby;

    public Game() {
        players = new ArrayList<>();
        lobby = new Lobby("Lobby 1", 10);
    }

    public Card getCard() {
        Card card = new Card();
        card.addItem(new Item(Material.WHEAT_SEEDS));
        card.addItem(new Item(Material.DIRT));
        card.addItem(new Item(Material.OAK_LOG));
        return card;
    }

    public void playerPickUpItem(Material item, Player player) {
//        if ()
//
//
//
//        lobbies.get(0).getTeams().forEach(team -> {
//            if (team.getPlayers().contains(player)) {
//                if (isItemOnCard(item, team.getCard())) {
//                    team.getPlayers().forEach(p -> p.sendMessage(Message.ITEM_FOUND(team.getName(), item.name())));
//                    checkBingo(team);
//                }
//            }
//        });
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

    public void checkBingo(Team team) {
        for (Item item : team.getCard().getItems()) {
            if (!item.isFound()) {
                return;
            }
        }
        win(team);
    }

    public void win(Team team) {
//        Bukkit.broadcastMessage(Message.TEAM_WON(team.getName()));
//        stop();
    }

    public void start() {
//        lobbies.get(0).setStarted(true);
//        Bukkit.broadcastMessage(Message.GAME_STARTED());
//
//        lobbies.get(0).addTeam(new Team("Team 1", getCard()));
//        lobbies.get(0).addTeam(new Team("Team 2", getCard()));
//
//        int count = 0;
//        for (Player player : lobbies.get(0).getPlayers()) {
//            if (count % 2 == 0) {
//                lobbies.get(0).getTeams().get(0).join(player);
//            } else {
//                lobbies.get(0).getTeams().get(1).join(player);
//            }
//            count++;
//        }
    }
    public void stop() {
//        lobbies.get(0).setStarted(false);
//        Bukkit.broadcastMessage(Message.GAME_ENDED());
//
//        lobbies.get(0).getPlayers().clear();
    }

    public void join(Player player) {
//        for (Lobby lobby : lobbies) {
//            if (lobby.getPlayers().size() < lobby.getMaxPlayers()) {
//                if (!lobby.isStarted()) {
//                    lobby.join(new BingoPlayer(player, lobby));
//                    lobby.getPlayers().forEach(p -> p.getPlayer().sendMessage(Message.PLAYER_JOIN(player.getName())));
//                    return;
//                }
//                player.sendMessage(Message.GAME_ALREADY_STARTED());
//                return;
//            }
//            player.sendMessage(Message.LOBBY_FULL());
//            return;
//        }
    }

    public void join(BingoPlayer player) {
//        for (Lobby lobby : lobbies) {
//            if (lobby.getPlayers().size() < lobby.getMaxPlayers()) {
//                if (!lobby.isStarted()) {
//                    lobby.join(player);
//                    player.setLobby(lobby);
//                    lobby.getPlayers().forEach(p -> p.getPlayer().sendMessage(Message.PLAYER_JOIN(player.getPlayer().getName())));
//                    return;
//                }
//                player.getPlayer().sendMessage(Message.GAME_ALREADY_STARTED());
//                return;
//            }
//            player.getPlayer().sendMessage(Message.LOBBY_FULL());
//            return;
//        }
    }
    public void leave(BingoPlayer player) {
//        BingoPlayer bingoPlayer = getBingoPlayer(player);
//        if (bingoPlayer != null) {
//
//        } else {
//            player.sendMessage(Message.PLAYER_NOT_IN_LOBBY());
//        }
//        for (Lobby lobby : lobbies) {
//            if (lobby.getPlayers().contains(player)) {
//                lobby.leave(player);
//                lobby.getPlayers().forEach(p -> p.sendMessage(Message.PLAYER_LEAVE(player.getName())));
//                return;
//            }
//        }
    }

    private BingoPlayer getBingoPlayer(Player player) {
//        for (Lobby l : lobbies) {
//            for (BingoPlayer p : l.getPlayers()) {
//                if (p.getPlayer().getUniqueId() == player.getUniqueId()) {
//                    return p;
//                }
//            }
//        }
        return null;
    }
}
