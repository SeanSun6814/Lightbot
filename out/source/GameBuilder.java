import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class GameBuilder {
    // these are all temporary variables for final game construction
    public Entity[][] map;
    public int spacing;
    public int xOffset = 0, yOffset = 0;
    public int playerX, playerY;
    public Direction playerDir;
    public PApplet g;
    public RobotBase robot;

    public GameBuilder(PApplet g) {
        this.g = g;
    }

    public GameBuilder setDimensions(int w, int h, int spacing) {
        map = new Entity[w][h];
        this.spacing = spacing;
        return this;
    }

    public GameBuilder addOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        return this;
    }

    public GameBuilder addSpace(int x, int y) {
        map[y][x] = new Space(g, x, y);
        return this;
    }

    public GameBuilder addLight(int x, int y, boolean on) {
        map[y][x] = new Light(g, x, y, on);
        return this;
    }

    public GameBuilder addPlayer(int x, int y, Direction playerDir) {
        this.playerX = x;
        this.playerY = y;
        this.playerDir = playerDir;
        return this;
    }

    public GameBuilder addRobotCode(RobotBase robot) {
        this.robot = robot;
        return this;
    }

    public GameBuilder fillTheRestWithNothing() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == null)
                    map[y][x] = new Nothing(g, x, y);
            }
        }
        return this;
    }

    public Game build() {
        Game.game = new Game(g, map, robot, spacing, playerX, playerY, playerDir, xOffset, yOffset);
        return Game.game;
    }

}
