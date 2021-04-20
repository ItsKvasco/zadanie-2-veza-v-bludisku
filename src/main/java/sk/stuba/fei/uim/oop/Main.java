package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public int WIDTH;
    public int HEIGHT;

    public static void main(String[] args) {
     Main main = new Main();
    }

    public Main(){
        var frame = new JFrame("Tower in the maze");
        getSizeFromUser();
        setupFrame(WIDTH, HEIGHT, frame);
        var panel = new Panel(WIDTH, HEIGHT);
        var grid = new Maze(WIDTH, HEIGHT);
        var sidePanelLeft = new JPanel();
        var sidePanelRight = new JPanel();
        var sidePanelTop = new JPanel();
        sidePanelLeft.setBackground(Color.DARK_GRAY);
        sidePanelLeft.setPreferredSize(new Dimension(WIDTH/30,HEIGHT));
        sidePanelRight.setBackground(Color.DARK_GRAY);
        sidePanelRight.setPreferredSize(new Dimension(WIDTH/30,HEIGHT));
        sidePanelTop.setBackground(Color.DARK_GRAY);
        sidePanelTop.setPreferredSize(new Dimension(WIDTH,HEIGHT/30));
        //Adding panels to specific position on frame
        frame.add(panel.getPanel(),BorderLayout.SOUTH);
        frame.add(sidePanelLeft,BorderLayout.WEST);
        frame.add(sidePanelRight,BorderLayout.EAST);
        frame.add(sidePanelTop,BorderLayout.NORTH);
        //Adding grid to specific position on frame
        frame.add(grid.getMaze(),BorderLayout.CENTER);


    }

    public void getSizeFromUser(){
        //Get window frame dimensions from user
        var console = new Scanner(System.in);
        System.out.print("Enter WIDTH: ");
        WIDTH = console.nextInt();
        System.out.print("Enter HEIGHT: ");
        HEIGHT = console.nextInt();
    }

    public void setupFrame(int WIDTH, int HEIGHT, JFrame frame){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
