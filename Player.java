import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class Player extends Entity {
    public Direction playerDir;

    public Player(PApplet g, int x, int y, Direction playerDir) {
        super(g, x, y);
        this.playerDir = playerDir;
    }

    public void draw(int x, int y, int w) {
        g.fill(255, 0, 0);
        g.stroke(0);
        g.circle(x + w / 2, y + w / 2, w / 2);
        if (playerDir == Direction.DOWN)
            g.triangle(x, y + w / 2, x + w, y + w / 2, x + w / 2, y + w);
        else if (playerDir == Direction.UP)
            g.triangle(x, y + w / 2, x + w, y + w / 2, x + w / 2, y);
        else if (playerDir == Direction.LEFT)
            g.triangle(x + w / 2, y, x + w / 2, y + w, x, y + w / 2);
        else // if (playerDir == Direction.RIGHT)
            g.triangle(x + w / 2, y, x + w / 2, y + w, x + w, y + w / 2);
    }
}