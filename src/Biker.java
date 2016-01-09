import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ralphpig on 1/9/16.
 */
public class Biker implements KeyListener{

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    private int x = 0;
    private int y = 0;

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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(player == 1) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_W:
                    direction = Direction.NORTH;
                    break;
                case KeyEvent.VK_A:
                    direction = Direction.WEST;
                    break;
                case KeyEvent.VK_S:
                    direction = Direction.SOUTH;
                    break;
                case KeyEvent.VK_D:
                    direction = Direction.EAST;
                    break;
            }
        }
        if(player == 2) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_UP:
                    direction = Direction.NORTH;
                    break;
                case KeyEvent.VK_DOWN:
                    direction = Direction.SOUTH;
                    break;
                case KeyEvent.VK_LEFT:
                    direction = Direction.EAST;
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = Direction.WEST;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
