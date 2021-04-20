package sk.stuba.fei.uim.oop;

public class Cell {
    private int x,y;
    private boolean isVisited = false;
    private boolean isTopWall = true;
    private boolean isBottomWall = true;
    private boolean isLeftWall = true;
    private boolean isRightWall = true;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

}

