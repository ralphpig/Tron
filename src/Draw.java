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

    private Timer timer = new Timer(DELAY, this);

    Biker player1 = new Biker(1, "Michael");
    Biker player2 = new Biker(2, "Bryson");
    Biker loser;

    boolean firstTime = true;
    boolean gameOver = false;

    private InputListener inputListener;

    public Draw(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    List<Point> points = new ArrayList<Point>();        // Every point
    List<Point> onePoints = new ArrayList<Point>();     // Player1 points
    List<Point> twoPoints = new ArrayList<Point>();     // Player2 points

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

        if(gameOver) {
            //TODO Bryson run explode code using the 'loser Biker'
            if(loser == null) {
                //TODO Explode both players
            } else {
                System.out.println("Explode " + loser.name);
            }
            timer.stop(); //TODO Remove stop()
        }
    }

    public void reset() {
        timer.stop();

        firstTime = true;
        gameOver = false;

        player1.setX(getWidth()*1/10 - SIZE + 1);
        player1.setY(getHeight()*1/2);

        player2.setX(getWidth()*9/10);
        player2.setY(getHeight()* 1/2);

        points.clear();
        onePoints.clear();
        twoPoints.clear();

        player1.reset();
        player2.reset();
        loser = null;

        timer.start();

        inputListener.ready(player1, player2, this);
    }

    public void endGame() {
        timer.stop();

        gameOver = true;
    }

    public void endGame(Biker loser) {
        this.loser = loser;
        gameOver = true;
    }

    public void pause() {
        if(!gameOver) {
            if(timer.isRunning()) {
                timer.stop();
            } else {
                timer.start();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver) {
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
                endGame();
            } else if(points.contains(oneP)) {
                System.out.println("TWO WINS");
                endGame(player1);
            } else if(points.contains(twoP)) {
                System.out.println("ONE WINS");
                endGame(player2);
            } else if(oneP.x == 0 || oneP.x == getWidth() || oneP.y == 0 || oneP.y == getHeight()) {
                System.out.println("TWO WINS");
                endGame(player1);
            } else if(twoP.x == 0 || twoP.x == getWidth() || twoP.y == 0 || twoP.y == getHeight()) {
                System.out.println("ONE WINS");
                endGame(player2);
            } else {
                points.add(oneP);
                points.add(twoP);

                onePoints.add(oneP);
                twoPoints.add(twoP);
            }
        }
        repaint();
    }
}
