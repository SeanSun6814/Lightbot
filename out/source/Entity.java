import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

// a base for all objects on map
public abstract class Entity {
    public volatile int x, y;
    public PApplet g;

    public Entity(PApplet g, int x, int y) {
        this.x = x;
        this.y = y;
        this.g = g;
    }

    public abstract void draw(int x, int y, int w);

}
