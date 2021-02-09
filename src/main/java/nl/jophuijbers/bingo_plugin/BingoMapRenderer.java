package nl.jophuijbers.bingo_plugin;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

public class BingoMapRenderer extends MapRenderer {
    private final int width = 128;
    private final int height = 128;

    private final int line = 2;
    private final int box = 20;
    private final int space = 8;

    @Override
    public void render(MapView map, MapCanvas canvas, Player player) {
        map.setScale(MapView.Scale.FARTHEST);
        drawBackground(canvas, MapPalette.WHITE);

        for (int i = space; i < height; i+=box+line) {
            drawLine(canvas, MapPalette.DARK_BROWN, i, width-space, space, line+space); // top
        }

        //drawLine(canvas, MapPalette.DARK_BROWN, space, line+space, space, height-space); // left
        //drawLine(canvas, MapPalette.DARK_BROWN, space, width-space, height - space - line, line); // bottom
//        drawLine(canvas, MapPalette.DARK_BROWN, width - line, width, 0, height);
    }

    private void drawBackground(MapCanvas canvas, byte color) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                canvas.setPixel(x, y, color);
            }
        }
    }

    private void drawLine(MapCanvas canvas, byte color, int fromX, int toX, int fromY, int toY) {
        for (int x = fromX; x < toX; x++) {
            for (int y = fromY; y < toY; y++) {
                canvas.setPixel(x, y, color);
            }
        }
    }
}
