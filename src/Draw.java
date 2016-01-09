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
    public static int DELTA = 10;


    /*
    Biker Bryson = new Biker(1);
    Biker Michael = new Biker(2);
    */
    boolean firstTime = true;
    Timer t = new Timer(1,this);

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (firstTime == true){
            /*

            Michael.setX(getWidth()*9/10)
            Bryson.setX(getWidth()*1/10)
            Michael.setY(getWidth()* 1/2)
            Bryson.setX(getWidth()*1/2)
            Michael.set
             */
            firstTime = false;
        }

        /*


        Bryson.setShape(new Rectangle2D.Double(Bryson.getX(), Bryson.getY(), 1,1))
        Michael.setShape(new Rectangle2D.Double(Michael.getX(), Michael.getY(), 1,1))


        */

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
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

         */
    }

}
