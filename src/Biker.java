import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ralphpig on 1/9/16.
 */
public class Biker{

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    private int x = 0;
    private int y = 400;

    private int player;

    private Direction direction;

    public Biker(int player) {
        this.player = player;
        if(player == 1) direction = Direction.EAST;
        if(player == 2) direction = Direction.WEST;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
