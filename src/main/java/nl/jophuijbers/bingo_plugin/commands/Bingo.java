package nl.jophuijbers.bingo_plugin.commands;

import nl.jophuijbers.bingo_plugin.bingo.BingoGame;
import nl.jophuijbers.bingo_plugin.bingo.BingoPlayer;
import nl.jophuijbers.bingo_plugin.bingo.Game;
import nl.jophuijbers.bingo_plugin.bingo.IBingoGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bingo implements CommandExecutor {

    private final BingoGame game;

    public Bingo(BingoGame game) {
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("bingo")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length > 0) {
                    switch (args[0]) {
                        case "start":
                            game.start();
                            return true;
                        case "stop":
                            game.stop();
                            return true;
                    }
                } else {
                    game.joinBingo(player);
                    return true;
                }
            }
        }
        return false;
    }
}
