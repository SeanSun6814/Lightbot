public class GroundSensor {
    public GroundSensor() {

    }

    public String getFront() {
        return getTypeAssumingDirection(Game.game.player.playerDir);
    }

    public String getLeft() {
        Direction dir;
        if (Game.game.player.playerDir == Direction.UP) {
            dir = Direction.LEFT;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            dir = Direction.RIGHT;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            dir = Direction.DOWN;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            dir = Direction.UP;
        }
        return getTypeAssumingDirection(dir);
    }

    public String getRight() {
        Direction dir;
        if (Game.game.player.playerDir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            dir = Direction.UP;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            dir = Direction.DOWN;
        }
        return getTypeAssumingDirection(dir);
    }

    public String getBack() {
        Direction dir;
        if (Game.game.player.playerDir == Direction.UP) {
            dir = Direction.DOWN;
        } else if (Game.game.player.playerDir == Direction.DOWN) {
            dir = Direction.UP;
        } else if (Game.game.player.playerDir == Direction.LEFT) {
            dir = Direction.RIGHT;
        } else { // if (Game.game.player.playerDir == Direction.RIGHT) {
            dir = Direction.LEFT;
        }
        return getTypeAssumingDirection(dir);
    }

    private String getTypeAssumingDirection(Direction dir) {
        int nextX, nextY;

        if (dir == Direction.UP) {
            nextX = Game.game.player.x;
            nextY = Game.game.player.y - 1;
        } else if (dir == Direction.DOWN) {
            nextX = Game.game.player.x;
            nextY = Game.game.player.y + 1;
        } else if (dir == Direction.LEFT) {
            nextX = Game.game.player.x - 1;
            nextY = Game.game.player.y;
        } else { // if (dir == Direction.RIGHT) {
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
