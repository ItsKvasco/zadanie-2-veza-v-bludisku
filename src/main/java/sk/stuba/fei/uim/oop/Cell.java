package sk.stuba.fei.uim.oop;
import java.util.ArrayList;

public class Cell {
    private final int x, y;
    private boolean visited = false;
    private boolean topWall = true;
    private boolean bottomWall = true;
    private boolean leftWall = true;
    private boolean rightWall = true;
    private final ArrayList<Cell> neighbors;

    public Cell(int x, int y) {
        this.neighbors = new ArrayList<Cell>();
        this.x = x;
        this.y = y;
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

    public boolean hasUnvisitedNeighbour(Cell currentCell) {
        for (int i = 0; i < currentCell.neighbors.size(); i++) {
            if (!currentCell.neighbors.get(i).isVisited()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCabin(int i, int j, int columns, int rows) {
        return i >= 0 && i < columns && j >= 0 && j < rows;
    }
}
