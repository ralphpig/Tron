import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ralphpig on 1/9/16.
 */
public class InputListener extends KeyAdapter {

    Biker player1;
    Biker player2;

    boolean ready = false;

    public void ready(Biker player1, Biker player2) {
        this.player1 = player1;
        this.player2 = player2;
        ready = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        Biker.Direction oneD = player1.getDirection();
        Biker.Direction twoD = player2.getDirection();
        if (ready) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    if(oneD != Biker.Direction.SOUTH) player1.setDirection(Biker.Direction.NORTH);
                    break;
                case KeyEvent.VK_A:
                    if(oneD != Biker.Direction.EAST) player1.setDirection(Biker.Direction.WEST);
                    break;
                case KeyEvent.VK_S:
                    if(oneD != Biker.Direction.NORTH) player1.setDirection(Biker.Direction.SOUTH);
                    break;
                case KeyEvent.VK_D:
                    if(oneD != Biker.Direction.WEST) player1.setDirection(Biker.Direction.EAST);
                    break;
                case KeyEvent.VK_UP:
                    if(twoD != Biker.Direction.SOUTH) player2.setDirection(Biker.Direction.NORTH);
                    break;
                case KeyEvent.VK_LEFT:
                    if(twoD != Biker.Direction.EAST) player2.setDirection(Biker.Direction.WEST);
                    break;
                case KeyEvent.VK_DOWN:
                    if(twoD != Biker.Direction.NORTH) player2.setDirection(Biker.Direction.SOUTH);
                    break;
                case KeyEvent.VK_RIGHT:
                    if(twoD != Biker.Direction.WEST) player2.setDirection(Biker.Direction.EAST);
                    break;
            }
        }
    }
}
