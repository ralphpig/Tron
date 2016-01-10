import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Bryson on 1/9/2016.
 */
public class Draw extends JPanel implements ActionListener{
    public static int DELTA = 5;


    Timer t = new Timer(100, this);

    Biker Bryson = new Biker(1);
    Biker Michael = new Biker(2);

    boolean firstTime = true;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (firstTime){
            Michael.setX(getWidth()*9/10);
            Michael.setY(getWidth()* 1/2);

            Bryson.setX(getWidth()*1/10 - 10);
            Bryson.setY(getWidth()*1/2);
            t.start();
            firstTime = false;
        }
        g2d.setColor(Color.BLUE);
        g2d.fill(new Rectangle2D.Double(Bryson.getX(), Bryson.getY(), 10,10));

        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle2D.Double(Michael.getX(), Michael.getY(), 10,10));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(Bryson.getDirection()){
            case NORTH:
                Bryson.setY(Bryson.getY() - DELTA);
                break;
            case EAST:
                Bryson.setY(Bryson.getX() + DELTA);
                break;
            case SOUTH:
                Bryson.setY(Bryson.getY() + DELTA);
                break;
            case WEST:
                Bryson.setY(Bryson.getY() - DELTA);
                break;
        }
       switch(Michael.getDirection()){
            case NORTH:
                Michael.setY(Michael.getY() - DELTA);
                break;
            case EAST:
                Michael.setY(Michael.getX() + DELTA);
                break;
            case SOUTH:
                Michael.setY(Michael.getY() + DELTA);
                break;
            case WEST:
                Michael.setY(Michael.getY() - DELTA);
                break;
        }
        repaint();
    }
}
