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
  size(1300, 1300);
}

public void draw() {
    game.draw();
}

public void keyPressed() {
    println("pressed " + keyCode);
    game.start();
}


Game game = Game.create(this)
.setDimensions(13, 13, 90)
.addOffset(50, 50)
.addPlayer(1, 1)
.addSpace(1, 1)
.addSpace(1, 2)
.addSpace(1, 3)
.addSpace(1, 4)
.addSpace(1, 5)
.addSpace(2, 5)
.addSpace(3, 5)
.addSpace(3, 6)
.addSpace(3, 7)
.addSpace(3, 8)
.addSpace(3, 9)
.addSpace(4, 7)
.addSpace(5, 7)
.addSpace(6, 7)
.addSpace(7, 7)
.fillTheRestWithNothing()
.build();
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightbot" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
