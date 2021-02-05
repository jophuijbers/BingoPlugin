package nl.jophuijbers.bingo_plugin.commands;

import nl.jophuijbers.bingo_plugin.bingo.Game;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reset implements CommandExecutor {

    private final Game game;

    public Reset(Game game) {
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            game.reset();
            return true;
        }
        return false;
    }
}
