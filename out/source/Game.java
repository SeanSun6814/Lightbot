import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Game {

    public Entity[][] map;
    public int width;
    public int xOffset, yOffset;
    public int playerX, playerY;
    public PApplet g;

    public Game(PApplet g, Entity[][] map, int width, int playerX, int playerY, int xOffset, int yOffset) {
        this.map = map;
        this.width = width;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.g = g;
    }

    public void setup() {
        g.size(1000, 1000);
    }

    public void draw() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x].draw(calcXPixel(x), calcYPixel(y), width);
            }
        }
    }

    public int calcXPixel(int xPos) {
        return xPos * width + xOffset;
    }

    public int calcYPixel(int yPos) {
        return yPos * width + yOffset;
    }

    public void start() {

    }

    public static GameBuilder create(PApplet g) {
        return new GameBuilder(g);
    }

}
