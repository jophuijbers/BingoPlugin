package nl.jophuijbers.bingo_plugin;

import nl.jophuijbers.bingo_plugin.bingo.BingoGame;
import nl.jophuijbers.bingo_plugin.bingo.Game;
import nl.jophuijbers.bingo_plugin.commands.Bingo;
import nl.jophuijbers.bingo_plugin.commands.Lobby;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final Game game = new Game();
    private final BingoGame bingoGame = new BingoGame();

    @Override
    public void onEnable() {
        getLogger().info("Bingo plugin enabled");
        getCommand("bingo").setExecutor(new Bingo(bingoGame));
        getCommand("lobby").setExecutor(new Lobby(bingoGame));
        getServer().getPluginManager().registerEvents(new Events(bingoGame), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Bingo plugin disabled");
    }
}
