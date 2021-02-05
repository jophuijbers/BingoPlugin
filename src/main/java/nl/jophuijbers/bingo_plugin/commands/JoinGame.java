package nl.jophuijbers.bingo_plugin.commands;

import nl.jophuijbers.bingo_plugin.bingo.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinGame implements CommandExecutor {

    private final Game game;

    public JoinGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            game.joinTeam(player);
            return true;
        }
        return false;
    }
}
