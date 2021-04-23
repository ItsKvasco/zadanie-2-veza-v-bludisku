package sk.stuba.fei.uim.oop;
import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    private final int x, y;
    private boolean visited = false;
    private boolean topWall = true;
    private boolean bottomWall = true;
    private boolean leftWall = true;
    private boolean rightWall = true;
    private final ArrayList<Cell> neighbors;
    private final ArrayList<Cell> availablePaths;

    public Cell(int x, int y) {
        this.neighbors = new ArrayList<>();
        this.availablePaths = new ArrayList<>();
        this.x = x;
        this.y = y;
    }
    public void removeAvailablePaths(){
        while(!availablePaths.isEmpty()){
            availablePaths.remove(0);
        }
    }
    public ArrayList<Cell> getAvailablePaths() {
        return availablePaths;
    }

    public void addAvaiblePath(Cell cell){
        availablePaths.add(cell);
    }

    public boolean isTopWall() {
        return topWall;
    }

    public boolean isBottomWall() {
        return bottomWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public void setBottomWall(boolean bottomWall) {
        this.bottomWall = bottomWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Cell> getNeighbors() {
        return neighbors;
    }
    public Cell randomUnvisitedNeighbour(){
        var tmp = getNeighbors();
        tmp.removeIf(Cell::isVisited);
        Collections.shuffle(tmp);
        if(!tmp.isEmpty()){
            return tmp.get(0);
        }
        return null;
    }
    public void setNeighbors(int i, int j, Cell[][] cellsArray) {
        var columns = cellsArray[0].length;
        var rows = cellsArray.length;
        if (isCabin(i, j, columns, rows)) {
            if (isCabin(i + 1, j, columns, rows))
                neighbors.add(cellsArray[i + 1][j]);
            if (isCabin(i - 1, j, columns, rows))
                neighbors.add(cellsArray[i - 1][j]);
            if (isCabin(i, j + 1, columns, rows))
                neighbors.add(cellsArray[i][j + 1]);
            if (isCabin(i, j - 1, columns, rows))
                neighbors.add(cellsArray[i][j - 1]);
        }
    }
    public static boolean isCabin(int i, int j, int columns, int rows) {
        return i >= 0 && i < columns && j >= 0 && j < rows;
    }

    public void connectCells(Cell currentCell, Cell nextCell){
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
    }
}
