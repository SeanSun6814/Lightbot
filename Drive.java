import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;
import java.lang.*;

public class Drive {

    public Drive() {

    }

    public void rotateLeft() {
        if (Game.game.player.playerDir == Direction.UP) {
            Game.game.player.playerDir = Direction.LEFT;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            Game.game.player.playerDir = Direction.RIGHT;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            Game.game.player.playerDir = Direction.DOWN;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            Game.game.player.playerDir = Direction.UP;
        }
        new Delay();
    }

    public void rotateRight() {
        if (Game.game.player.playerDir == Direction.UP) {
            Game.game.player.playerDir = Direction.RIGHT;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            Game.game.player.playerDir = Direction.LEFT;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            Game.game.player.playerDir = Direction.UP;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            Game.game.player.playerDir = Direction.DOWN;
        }
        new Delay();
    }

    public void moveForward() {
        int nextX, nextY;

        if (Game.game.player.playerDir == Direction.UP) {
            nextX = Game.game.player.x;
            nextY = Game.game.player.y - 1;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            nextX = Game.game.player.x;
            nextY = Game.game.player.y + 1;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            nextX = Game.game.player.x - 1;
            nextY = Game.game.player.y;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            nextX = Game.game.player.x + 1;
            nextY = Game.game.player.y;
        }

        if (Game.game.map[nextY][nextX] instanceof Space) {
            Game.game.player.x = nextX;
            Game.game.player.y = nextY;
        } else {
            Game.log("ERROR! You can only go on a 'Space' block!");
        }
        new Delay();
    }

}
