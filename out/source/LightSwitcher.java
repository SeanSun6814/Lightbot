import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;
import java.lang.*;

public class LightSwitcher {
    public LightSwitcher() {

    }

    public void switchLight() {
        int nextX, nextY;

        nextX = Game.game.player.x;
        nextY = Game.game.player.y - 1;

        if (Game.game.map[nextY][nextX] instanceof Light) {
            ((Light) Game.game.map[nextY][nextX]).on = !(((Light) Game.game.map[nextY][nextX]).on);
        } else {
            Game.log("ERROR! The thing you are trying to switch is not a light!");
        }

    }
}
