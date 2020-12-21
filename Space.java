import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class Space extends Entity {

    public Space(PApplet g, int x, int y) {
        super(g, x, y);
    }

    public void draw(int x, int y, int w) {
        g.fill(255);
        g.stroke(0);
        g.square(x, y, w);
    }
}