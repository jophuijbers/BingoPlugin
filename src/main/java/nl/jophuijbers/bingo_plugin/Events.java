package nl.jophuijbers.bingo_plugin;

import nl.jophuijbers.bingo_plugin.bingo.BingoGame;
import nl.jophuijbers.bingo_plugin.bingo.BingoPlayer;
import nl.jophuijbers.bingo_plugin.bingo.Game;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

    private final BingoGame game;

    public Events(BingoGame game) {
        this.game = game;
    }

    @EventHandler
    public void onPickupPlayer(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            BingoPlayer player = game.getBingoPlayer((Player) event.getEntity());
            game.playerPickUpItem(event.getItem().getItemStack().getType(), player);
        }
    }

    @EventHandler
    public void onMapInitialize(MapInitializeEvent event) {
        MapView map = event.getMap();
        event.getMap().removeRenderer(event.getMap().getRenderers().get(0));
        map.addRenderer(new BingoMapRenderer());
    }
}
