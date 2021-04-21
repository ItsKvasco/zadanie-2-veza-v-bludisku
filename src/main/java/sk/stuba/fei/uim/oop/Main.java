package sk.stuba.fei.uim.oop;
import javax.swing.*;

public class Main {
    public static void main(String[]args){
        new Main();
    }

    public Main(){
        final int width = 1000;
        final int height = 1000;
        final int rows = 18;
        final int columns = 18;
        var frame = new JFrame("Test");
        var cellsArray = new Cell[columns][rows];
        AI ai = new AI(cellsArray, frame);
        //
        ai.fillCellArray(cellsArray);
        ai.DFS(cellsArray[1][1]);
        ai.makeFrame(width,height,frame);
        //painting
        ai.printMaze(columns, rows, cellsArray);
    }
}
