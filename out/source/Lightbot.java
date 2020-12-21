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

public class Lightbot extends PApplet {


public void setup(){
}


public void settings() {
  size(1500, 1000);
}

public void draw() {
    game.draw();
}

public void keyPressed() {
    println("pressed " + keyCode);
    game.start();
}


Game game = Game.create(this)
.setDimensions(10, 10, 50)
.addPlayer(1, 1)
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
