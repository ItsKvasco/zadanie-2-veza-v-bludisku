package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[]args){
        new Main();
    }

    public Main(){
        final int width = 920;
        final int height = 1100;
        final int rows = 18;
        final int columns = 18;
        var title = "Rook in a maze";

        //Creating frame
        var frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setSize(width, height);
        frame.setVisible(true);

        //Creating required instances
        var cellsArray = new Cell[columns][rows];
        var player = new Player(0,0);
        var panel = new Panel(width, height, player, cellsArray);
        var board = new Board(columns, rows, player, cellsArray, panel);

        //Adding components to frame
        frame.add(board, BorderLayout.CENTER);
        frame.add(panel.getPanel(), BorderLayout.SOUTH);
    }
}
