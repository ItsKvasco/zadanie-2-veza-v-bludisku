package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AI {
    private final Cell[][] cellsArray;
    private final Random randomizer = new Random();
    private final JFrame frame;
    private Player player;

    public AI(Cell[][] cellsArray, JFrame frame, Player player) {
        this.cellsArray = cellsArray;
        this.player = player;
        this.frame = frame;
    }

    public Player getPlayer() {
        return player;
    }

    public void DFS(Cell currentCell) {
        Cell nextCell;
        currentCell.setVisited(true);
        int random;
        while (currentCell.hasUnvisitedNeighbour(currentCell)) {
            //choose random unvisited neighbour
            //what if there are only 2 or 3 neighbours?
            if(currentCell.getNeighbors().size() == 2){
                random = randomizer.nextInt(2);
            }else if(currentCell.getNeighbors().size() == 3){
                random = randomizer.nextInt(3);
            }else{
                random = randomizer.nextInt(4);
            }
            nextCell = currentCell.getNeighbors().get(random);
            nextCell.setVisited(true);
            //Getting locations of cells
            var nextX = nextCell.getX();
            var nextY = nextCell.getY();
            var currX = currentCell.getX();
            var currY = currentCell.getY();
            //Remove the wall between current cell and the chosen one
            //Goes only up and down
            if(currX == nextX){
                if(currY - nextY < 0){
                    //Remove bottom wall of currCell and top wall of nextCell
                    currentCell.setBottomWall(false);
                    nextCell.setTopWall(false);
                }else{
                    //Remove top wall of currentCell and bottom wall of nextCell
                    currentCell.setTopWall(false);
                    nextCell.setBottomWall(false);
                }
            }
            //Goes only side to side
            if(currY == nextY){
                if(currX - nextX < 0){
                    //Remove right wall currCell and left wall nextCell
                    currentCell.setRightWall(false);
                    nextCell.setLeftWall(false);

                }else {
                    //Remove left currCell wall and right wall of nextCell
                    currentCell.setLeftWall(false);
                    nextCell.setRightWall(false);
                }
            }
            //Recursive call
            DFS(nextCell);
        }
    }
    public void makePanel(int width, int height){
        var panel = new Panel(width, height);
        GridBagConstraints c = new GridBagConstraints();
        panel.addButtons(c);
        frame.add(panel.getPanel(), BorderLayout.SOUTH);
    }
    public void printMaze(int columns, int rows, Cell[][] cellsArray){
        var canvas = new MyCanvas(columns,rows, cellsArray);
        frame.add(canvas);
    }
    public void makeFrame(int width, int height, JFrame frame){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public void fillCellArray(Cell[][] cellsArray) {
        var columns = cellsArray[0].length;
        var rows = cellsArray.length;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                var cell = new Cell(i, j);
                cellsArray[i][j] = cell;
            }
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                cellsArray[i][j].setNeighbors(i, j, cellsArray);
            }
        }
    }

}




