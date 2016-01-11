import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

/**
 * Created by Bryson on 1/9/2016.
 */
public class Draw extends JPanel implements ActionListener{
    public static int DELTA = 1;
    public static int SIZE = 1;
    public static int DELAY = 5;

    Timer timer = new Timer(DELAY, this);

    Biker player1 = new Biker(1);
    Biker player2 = new Biker(2);

    boolean firstTime = true;

    private InputListener inputListener;

    public Draw(InputListener inputListener) {
        this.inputListener = inputListener;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (firstTime){
            reset();
            firstTime = false;
        }
        g2d.setColor(Color.GREEN);
        for(Point p : onePoints) {
            g2d.fill(new Rectangle2D.Double(p.getX(), p.getY(), SIZE, SIZE));
        }

        g2d.setColor(Color.RED);
        for(Point p : twoPoints) {
            g2d.fill(new Rectangle2D.Double(p.getX(), p.getY(), SIZE, SIZE));
        }

    }

    public void reset() {
        timer.stop();

        firstTime = true;

        player1.setX(getWidth()*1/10 - SIZE + 1);
        player1.setY(getHeight()*1/2);

        player2.setX(getWidth()*9/10);
        player2.setY(getHeight()* 1/2);

        points.clear();
        onePoints.clear();
        twoPoints.clear();

        player1.reset();
        player2.reset();

        timer.start();

        inputListener.ready(player1, player2, this);
    }


    List<Point> points = new ArrayList<Point>();
    List<Point> onePoints = new ArrayList<Point>();
    List<Point> twoPoints = new ArrayList<Point>();

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

        Point oneP = new Point(player1.getX(), player1.getY());
        Point twoP = new Point(player2.getX(), player2.getY());

        if(points.contains(oneP) && points.contains(twoP)) {
            System.out.println("NO WIN");
            timer.stop();
        } else if(points.contains(oneP)) {
            System.out.println("TWO WINS");
            timer.stop();
        } else if(points.contains(twoP)) {
            System.out.println("One WINS");
            timer.stop();
        } else if(oneP.x == 0 || oneP.x == getWidth() || oneP.y == 0 || oneP.y == getHeight()) {
            System.out.println("TWO WINS");
            timer.stop();
        } else if(twoP.x == 0 || twoP.x == getWidth() || twoP.y == 0 || twoP.y == getHeight()) {
            System.out.println("ONE WINS");
            timer.stop();
        } else {
            points.add(oneP);
            points.add(twoP);

            onePoints.add(oneP);
            twoPoints.add(twoP);
        }

        repaint();
    }
}
