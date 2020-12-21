void setup(){
}


public void settings() {
  size(1300, 1300);
}

void draw() {
    game.loop();
}

void keyPressed() {
    println("pressed " + keyCode);
    game.start();
}


Game game = Game.create(this)
.setDimensions(13, 13, 90)
.addOffset(50, 50)
.addPlayer(1, 1, Direction.DOWN)
.addRobotCode(new Robot())
.addLight(6, 6, false)
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
