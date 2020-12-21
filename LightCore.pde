void setup(){
}


public void settings() {
  size(1500, 1000);
}

void draw() {
    game.draw();
}

void keyPressed() {
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
