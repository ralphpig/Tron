import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by Bryson on 1/9/2016.
 */
public class Draw extends JPanel implements ActionListener{
    public static int DELTA = 1;
    public static int SIZE = 2;

    Timer t = new Timer(2, this);

    Biker player1 = new Biker(1);
    Biker player2 = new Biker(2);

    boolean firstTime = true;

    private InputListener inputListener;

    public Draw(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (firstTime){
            player2.setX(getWidth()*9/10);
            player2.setY(getHeight()* 1/2);

            player1.setX(getWidth()*1/10 - SIZE);
            player1.setY(getHeight()*1/2);
            firstTime = false;
            inputListener.ready(player1, player2);
            t.start();
        }
        g2d.setColor(Color.BLUE);
        g2d.fill(new Rectangle2D.Double(player1.getX(), player1.getY(), SIZE, SIZE));

        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle2D.Double(player2.getX(), player2.getY(), SIZE, SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(player1.getDirection()){
            case NORTH:
                player1.setY(player1.getY() - DELTA);
                break;
            case EAST:
                player1.setX(player1.getX() + DELTA);
                break;
            case SOUTH:
                player1.setY(player1.getY() + DELTA);
                break;
            case WEST:
                player1.setX(player1.getX() - DELTA);
                break;
        }
       switch(player2.getDirection()){
            case NORTH:
                player2.setY(player2.getY() - DELTA);
                break;
            case EAST:
                player2.setX(player2.getX() + DELTA);
                break;
            case SOUTH:
                player2.setY(player2.getY() + DELTA);
                break;
            case WEST:
                player2.setX(player2.getX() - DELTA);
                break;
        }
        repaint();
    }
}
