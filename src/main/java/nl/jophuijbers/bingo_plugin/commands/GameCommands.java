package nl.jophuijbers.bingo_plugin.commands;

import nl.jophuijbers.bingo_plugin.bingo.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCommands implements CommandExecutor {

    private final Game game;

    public GameCommands(Game game) {
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("start")) {
            game.start();
            return true;
        }
        else if (cmd.getName().equalsIgnoreCase("end")) {
            game.stop();
            return true;
        }
        return false;
    }
}
