package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class MyCanvas extends Canvas {
    private final int columns;
    private final int rows;
    private final Cell[][] cellsArray;

    public MyCanvas(int columns, int rows, Cell[][] cellsArray) {
        this.columns = columns;
        this.rows = rows;
        this.cellsArray = cellsArray;
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if(cellsArray[i][j].isTopWall()){
                    g.drawLine(10 + i * 50,10 + j * 50,60 + i * 50,10 + j * 50);
                }
                if(cellsArray[i][j].isBottomWall()){
                    g.drawLine(10 + i * 50,60 + j * 50,60 + i * 50,60 + j * 50);
                }
                if(cellsArray[i][j].isLeftWall()){
                    g.drawLine(10 + i * 50,10 + j * 50,10 + i * 50,60 + j * 50);
                }
                if (cellsArray[i][j].isRightWall()) {
                    g.drawLine(60 + i * 50,10 + j * 50,60 + i * 50,60 + j * 50);
                }
            }
        }
    }
}
