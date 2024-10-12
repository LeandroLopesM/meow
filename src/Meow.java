import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Meow {
    JFrame root;
    Stack<JFrame> children;

    public Meow() {
        root = rootSetup();

        root.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed( MouseEvent e ) {
                children.push( childSetup() );
            }
        } );
    }


    private JFrame childSetup() {
        return null;
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
