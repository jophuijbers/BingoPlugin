package nl.jophuijbers.bingo_plugin.commands;

import nl.jophuijbers.bingo_plugin.bingo.BingoGame;
import nl.jophuijbers.bingo_plugin.bingo.BingoPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lobby implements CommandExecutor {

        private final BingoGame game;

        public Lobby(BingoGame game) {
            this.game = game;
        }

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
            if (cmd.getName().equalsIgnoreCase("lobby")) {
                if (sender instanceof Player) {
                    BingoPlayer player = game.getBingoPlayer((Player) sender);
                    if (player != null) {
                        if (args.length > 0) {
                            switch (args[0]) {
                                case "join":
                                    game.joinLobby(player);
                                    return true;
                                case "leave":
                                    game.leaveLobby(player);
                                    return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
}
