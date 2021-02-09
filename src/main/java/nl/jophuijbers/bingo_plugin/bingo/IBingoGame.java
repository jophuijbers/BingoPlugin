package nl.jophuijbers.bingo_plugin.bingo;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface IBingoGame {
    void joinBingo(Player player);

    void start();
    void stop();

    void join(Player player);
    void leave(Player player);

    void playerPickUpItem(Material item, Player player);
}
