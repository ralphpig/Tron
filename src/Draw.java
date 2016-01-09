import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Bryson on 1/9/2016.
 */
public class Draw extends JPanel{


    /*
    Biker Bryson = new Biker();
    Biker Michael = new Biker();
    */
    boolean firstTime = true;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (firstTime == true){
            /*
            Michael.setXPosition(getWidth()*9/10)
            Bryson.setXPosition(getWidth()*1/10)
            Michael.setYPosition(getWidth()* 1/2)
            Bryson.setXPosition(getWidth()*1/2)

             */
            firstTime = false;
        }

        /*


        Bryson.setShape(new Rectangle2D.Double(Bryson.getXPosition, Bryson.getYPosition, 1,1))
        Michael.setShape(new Rectangle2D.Double(Michael.getXPosition, Michael.getYPosition, 1,1))


        */
    }

}
