package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maze extends Canvas{
    private JPanel maze;
    private ArrayList<Integer> map;

    public Maze(int WIDTH, int HEIGHT) {
        maze = new JPanel(new GridLayout(15,15));
//        maze.setBackground(Color.LIGHT_GRAY);
    }

    public JPanel getMaze() {
        return maze;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(100,100,150,150);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
//                g.fillRect(10,10,10,10);
            }
        }
    }

}
