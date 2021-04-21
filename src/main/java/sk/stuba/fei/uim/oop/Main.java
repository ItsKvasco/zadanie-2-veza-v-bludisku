package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[]args){
        new Main();
    }

    public Main(){
        final int width = 1000;
        final int height = 1000;
        final int rows = 18;
        final int columns = 18;
        //Making frame instance
        var frame = new JFrame("Test");
        //Creating cellsArray instance
        var cellsArray = new Cell[columns][rows];
        //Creating Player instance
        var player = new Player(1,1);
        //Creating ArtificialIntelligence instance
        AI ai = new AI(cellsArray, frame, player);
        //using AI methods
        ai.fillCellArray(cellsArray);
        ai.DFS(cellsArray[1][1]);
        ai.makeFrame(width,height,frame);
            //painting
        ai.printMaze(columns, rows, cellsArray);
        ai.makePanel(width,height);
    }
}
