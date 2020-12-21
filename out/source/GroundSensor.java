public class GroundSensor {
    public GroundSensor() {

    }

    public String getFrontGroundType() {
        int nextX = Game.game.player.x, nextY = Game.game.player.y;

        if (Game.game.player.playerDir == Direction.UP) {
            nextX = Game.game.player.x;
            nextY = Game.game.player.y - 1;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            nextX = Game.game.player.x;
            nextY = Game.game.player.y + 1;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            nextX = Game.game.player.x - 1;
            nextY = Game.game.player.y;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            nextX = Game.game.player.x + 1;
            nextY = Game.game.player.y;
        }
        if (Game.game.map[nextY][nextX] instanceof Space)
            return "Space";
        else if (Game.game.map[nextY][nextX] instanceof Nothing)
            return "Nothing";
        else if (Game.game.map[nextY][nextX] instanceof Light)
            return "Light";
        return "Null";
    }
}
