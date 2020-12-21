import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class Nothing extends Entity {

    public Nothing(PApplet g, int x, int y) {
        super(g, x, y);
    }

    public void draw(int x, int y, int w) {
        g.line(x, y + w, x + w, y);
    }
}
