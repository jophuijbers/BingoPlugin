package nl.jophuijbers.bingo_plugin;

import nl.jophuijbers.bingo_plugin.bingo.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

    private final Game game;

    public Events(Game game) {
        this.game = game;
    }

    @EventHandler
    public void onPickupPlayer(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            game.playerPickUpItem(event.getItem().getItemStack().getType(), (Player) event.getEntity());
        }
    }
}
