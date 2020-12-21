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
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightbot extends PApplet {
















class Game {

    public Entity[][] map;
    public int width;
    public int xOffset, yOffset;
    public int playerX, playerY;

    public Game(Entity[][] map, int width, int playerX, int playerY, int xOffset, int yOffset) {
        this.map = map;
        this.width = width;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void setup(){
        size(1000,1000);
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

}

abstract class Entity {
    public int x, y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(int x, int y, int w);

}

class Space extends Entity {

    public Space(int x, int y) {
        super(x, y);
    }

    public void draw(int x, int y, int w) {
        fill(255);
        stroke(0);
        square(x, y, w);
    }
}

class Nothing extends Entity {

    public Nothing(int x, int y) {
        super(x, y);
    }

    public void draw(int x, int y, int w) {

    }
}

class Player extends Entity {

    public Player(int x, int y) {
        super(x, y);
    }

    public void draw(int x, int y, int w) {

    }
}

class GameBuilder {
    public Entity[][] map;
    public int spacing;
    public int xOffset = 0, yOffset = 0;
    public int playerX, playerY;

    public GameBuilder(int w, int h, int spacing) {
        map = new Entity[w][h];
        this.spacing = spacing;
    }

    public GameBuilder addOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        return this;
    }

    public GameBuilder addSpace(int x, int y) {
        map[y][x] = new Space(x, y);
        return this;
    }

    public GameBuilder addPlayer(int x, int y) {
        this.playerX = playerX;
        this.playerY = playerY;
        return this;
    }

    public GameBuilder fillTheRestWithNothing() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == null)
                    map[y][x] = new Nothing(x, y);
            }
        }
        return this;
    }

    public Game build() {
        return new Game(map, spacing, playerX, playerY, xOffset, yOffset);
    }

}

    public void keyPressed() {
        println("pressed " + keyCode);
        game.start();
    }

    public void draw() {
        game.draw();
}

GameBuilder gb = new GameBuilder(10, 10, 50);
Game game = gb.addPlayer(1, 1)
.addSpace(1, 1)
.addSpace(1, 2)
.addSpace(1, 3)
.addSpace(1, 4)
.addSpace(1, 5)
.fillTheRestWithNothing()
.build();

// class Pos {
// int x, y;

// public Pos() {
// x = y = 0;
// }

// public Pos(int x, int y) {
// this.x = x;
// this.y = y;
// }

// public boolean equals(Object obj) {
// if (obj == null || !(obj instanceof Pos))
// return false;
// return (x == obj.x && y == obj.y);
// }

// }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightbot" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
