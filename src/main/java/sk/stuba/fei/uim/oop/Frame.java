package sk.stuba.fei.uim.oop;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Frame {
    public static int WIDTH;
    public static int HEIGHT;
    private JFrame frame;

    public Frame() {
        frame = new JFrame("Tower in the maze");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void createFrame(){
        //Get window frame dimensions from user
        var console = new Scanner(System.in);
        System.out.print("Enter WIDTH: ");
        WIDTH = console.nextInt();
        System.out.print("Enter HEIGHT: ");
        HEIGHT = console.nextInt();
        //Setting up window
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
    public void addPanel(){
        var panel = new Panel();
        frame.add(panel.getPanel(), BorderLayout.SOUTH);
    }
}
