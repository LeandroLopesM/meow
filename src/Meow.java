import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

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
        JFrame template = new JFrame("Meow");
        template.add(new JLabel("Meow"));
        JButton w = new JButton("mrow");
        w.addActionListener( e -> {
            children.push( childSetup() );
        } );

        template.add( w );
        return template;
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
