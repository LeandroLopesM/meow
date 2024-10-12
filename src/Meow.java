import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Meow {
    JFrame root;
    JFrame[] children;

    public Meow() {
        root = rootSetup();
    }

    private JFrame rootSetup() {
        JFrame that = new JFrame("A wild cat appears!");
        that.getContentPane().add(new JLabel( new ImageIcon("src/resources/plonk.jpg") ));
        that.setBackground(Color.black);
        that.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return that;
    }

    public static void main(String[] args) throws Exception {
        new Meow();
    }
}
