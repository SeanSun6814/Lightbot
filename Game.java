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
import java.lang.*;

public class Game {

    public static volatile Game game; // a global static reference to the current game for everyone to use
    public volatile Entity[][] map; // map of the entire game
    public volatile int width; // size of each block
    public volatile int xOffset, yOffset; // top/left margin for game (in pixels)
    public volatile PApplet g; // reference to canvas for drawing things to the screen
    public volatile boolean started = false;
    public volatile Player player;
    public volatile RobotBase robot;
    public volatile String log = "";
    public volatile int logMillis;

    public Game(PApplet g, Entity[][] map, RobotBase robot, int width, int playerX, int playerY, Direction playerDir,
            int xOffset, int yOffset) {
        this.map = map;
        this.width = width;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.robot = robot;
        player = new Player(g, playerX, playerY, playerDir);
        this.g = g;
    }

    public void loop() {
        // if (started)
        // update();
        draw();
    }

    // public void update() {
    // robot.loop();
    // }

    private void drawLog() {
        if (g.millis() - logMillis < 1500) {
            g.textSize(32);
            g.fill(255, 0, 0);
            g.text(log, 20, 50);
        } else {
            log = "";
        }
    }

    // draws everything
    public void draw() {
        g.background(204);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x].draw(calcXPixel(x), calcYPixel(y), width);
            }
        }
        player.draw(calcXPixel(player.x), calcXPixel(player.y), width);
        drawLog();
    }

    // util function to tell each entity its position to draw
    public int calcXPixel(int xPos) {
        return xPos * width + xOffset;
    }

    // util function to tell each entity its position to draw
    public int calcYPixel(int yPos) {
        return yPos * width + yOffset;
    }

    public Thread robotThread;

    public void start() {
        Game.log("Starting robot!");
        robotThread = new Thread() {
            public void run() {
                robot.init();

                while (started) {
                    robot.loop();
                }
            }
        };
        robotThread.start();
        started = true;
    }

    public static void pause() {
        Game.game.draw();
        Game.game.g.delay(1000);
    }

    public static void log(String msg) {
        System.out.println(msg);
        Game.game.log = msg;
        Game.game.logMillis = Game.game.g.millis();
    }

    // provide access point to game builder so user code is nicer
    public static GameBuilder create(PApplet g) {
        return new GameBuilder(g);
    }

}
