import javax.swing.*;
import java.awt.*;

/**
 * Created by Bryson on 1/9/2016.
 */
public class Window {

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int width = (int) screenSize.getWidth();
    static int height = (int) screenSize.getHeight();

    public static void create(){
        JFrame f = new JFrame("Tron");
        InputListener inputListener = new InputListener();
        Draw g = new Draw(inputListener);
        g.setBackground(Color.BLACK);
        f.setSize(width, height);
        f.add(g);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(inputListener);
    }

}
