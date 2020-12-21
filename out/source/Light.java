import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class Light extends Entity {

    public boolean on;

    public Light(PApplet g, int x, int y, boolean on) {
        super(g, x, y);
    }

    public void draw(int x, int y, int w) {
        if (on)
            g.fill(255, 128, 0);
        else
            g.fill(255, 204, 153);

        g.stroke(0);
        g.square(x, y, w);
    }
}
