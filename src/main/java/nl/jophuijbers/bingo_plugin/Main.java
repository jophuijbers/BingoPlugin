package nl.jophuijbers.bingo_plugin;

import nl.jophuijbers.bingo_plugin.bingo.Game;
import nl.jophuijbers.bingo_plugin.commands.GameCommands;
import nl.jophuijbers.bingo_plugin.commands.JoinGame;
import nl.jophuijbers.bingo_plugin.commands.LeaveGame;
import nl.jophuijbers.bingo_plugin.commands.Reset;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final Game game = new Game(this);

    @Override
    public void onEnable() {
        getLogger().info("Bingo plugin enabled");
        registerCommands();
        getServer().getPluginManager().registerEvents(new Events(game), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Bingo plugin disabled");
    }

    private void registerCommands() {
        getCommand("start").setExecutor(new GameCommands(game));
        getCommand("end").setExecutor(new GameCommands(game));
        getCommand("join").setExecutor(new JoinGame(game));
        getCommand("leave").setExecutor(new LeaveGame(game));
        getCommand("reset").setExecutor(new Reset(game));
    }
}
