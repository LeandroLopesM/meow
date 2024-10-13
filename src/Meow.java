import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Meow {
    JFrame root;
    Stack<JFrame> children = new Stack<>();

    public Meow() {
        root = rootSetup();

        root.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed( MouseEvent e ) {
                children.push( childSetup() );
            }
        } );

        root.setVisible(true);
    }


    private JFrame childSetup() {
        JFrame template = new JFrame("Meow");
        template.add(new JLabel("Meow"));
        JButton w = new JButton("mrow");
        w.addActionListener( e -> {
            children.push( childSetup() );
        } );

        template.add( w );
        template.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        template.setSize(100,100);

        template.setLocation( new Random().nextInt(0, Toolkit.getDefaultToolkit().getScreenSize().width) + template.getWidth() ,  new Random().nextInt(0, Toolkit.getDefaultToolkit().getScreenSize().height) + template.getHeight());

        template.setVisible(true);
        return template;
    }

    private JFrame rootSetup() {
        JFrame that = new JFrame("A wild cat appears!");
        that.getContentPane().add(new JLabel( new ImageIcon("src/resources/plonk.jpg") ));
        that.setBackground(Color.black);
        that.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        that.pack();

        that.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    while(!children.isEmpty()) {
                        children.peek().setVisible(false);
                        children.peek().dispose();
                        children.pop();
                        TimeUnit.MILLISECONDS.sleep(200);
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        return that;
    }

    public static void main(String[] args) throws Exception {
        new Meow();
    }
}
