import javax.swing.*;

/**
 * Created by Bryson on 1/9/2016.
 */
public class Window {

    public static void create(){
        JFrame f = new JFrame("Tron");
        Draw g = new Draw();
        f.setSize(800,800);
        f.add(g);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
