package sk.stuba.fei.uim.oop;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends Canvas implements KeyListener, MouseListener {
    private final int columns,rows;
    private final Cell[][] cellsArray;
    private final Player player;
    private final Panel panel;
    private boolean flagClicked = false,
                    flagClickedAgain = false;
//                    flagMoveClick = false;

    public Board(int columns, int rows, Player player, Cell[][] cellsArray, Panel panel) {
        this.panel = panel;
        this.cellsArray = cellsArray;
        this.columns = columns;
        this.rows = rows;
        panel.setBoard(this);
        this.fillCellArray(cellsArray);
        this.randomizedDFS(cellsArray[0][0]);
        this.fillAvailablePaths(cellsArray);
        this.player = player;
        addKeyListener(this);
        addMouseListener(this);
    }
    public void setFlagClicked(boolean flagClicked) {
        this.flagClicked = flagClicked;
    }
    public void fillAvailablePaths(Cell[][] cellsArray){
        for(int i = 0; i < columns ; i++ ){
            for (int j = 0; j < rows; j++) {
                if(!cellsArray[i][j].isBottomWall()){
                    int k = 0;
                    while(!cellsArray[i][j+k].isBottomWall()){
                        k++;
                        cellsArray[i][j].addAvailablePath(cellsArray[i][j+k]);
                    }
                }
                if(!cellsArray[i][j].isTopWall()){
                    int k = 0;
                    while(!cellsArray[i][j-k].isTopWall()){
                        k++;
                        cellsArray[i][j].addAvailablePath(cellsArray[i][j-k]);
                    }
                }
                if(!cellsArray[i][j].isLeftWall()){
                    int k = 0;
                    while(!cellsArray[i-k][j].isLeftWall()){
                        k++;
                        cellsArray[i][j].addAvailablePath(cellsArray[i-k][j]);

                    }
                }
                if(!cellsArray[i][j].isRightWall()){
                    int k = 0;
                    while(!cellsArray[i+k][j].isRightWall()){
                        k++;
                        cellsArray[i][j].addAvailablePath(cellsArray[i+k][j]);
                    }
                }
            }
        }
    }
    public void randomizedDFS(Cell currentCell) {
        currentCell.setVisited(true);
        //next cell ---- random unvisited neighbour
        var nextCell = currentCell.randomUnvisitedNeighbour();
        while (nextCell != null) {
            //connect cells
            currentCell.connectCells(currentCell, nextCell);
            //Recursive call
            randomizedDFS(nextCell);
            //random unvisited neighbor
            nextCell = currentCell.randomUnvisitedNeighbour();
        }
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
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 40, 40);
        g.setColor(Color.WHITE);
        g.fillRect(15 + (columns-1) * 50, 15 + (rows - 1) * 50, 40, 40);
        g.setColor(Color.BLACK);
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
        //Checking position
        if(player.getX() == columns-1 && player.getY() == rows-1){
            player.setX(0);
            player.setY(0);
            for(int i = 0;i < cellsArray.length; i++){
                for(int j = 0; j < cellsArray.length; j++){
                    cellsArray[i][j].setVisited(false);
                    cellsArray[i][j].setTopWall(true);
                    cellsArray[i][j].setBottomWall(true);
                    cellsArray[i][j].setRightWall(true);
                    cellsArray[i][j].setLeftWall(true);
                    cellsArray[i][j].setNeighbors(i, j, cellsArray);
                    cellsArray[i][j].removeAvailablePaths();
                }
            }
            panel.setWinsCounter(panel.getWinsCounter()+1);
            panel.updateScore();
            randomizedDFS(cellsArray[0][0]);
            fillAvailablePaths(cellsArray);
            flagClicked = false;
            repaint();
        }
        //Highlighting available path
        g.setColor(Color.GRAY);
        if(this.flagClicked){
            var paths = cellsArray[player.getX()][player.getY()].getAvailablePaths();
            for (Cell path : paths) {
                g.fillRect(path.getX() * 50 + 15, path.getY() * 50 + 15, 40, 40);
            }
        }
        //Movement of player
        g.setColor(Color.DARK_GRAY);
        g.fillRect(player.getX() * 50 + 15, player.getY() * 50 + 15, 40, 40);
//        flagMoveClick = false;
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if(!(cellsArray[player.getX()][player.getY()].isTopWall())){
                    player.move(player.getX(), player.getY()-1);
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if(!(cellsArray[player.getX()][player.getY()].isBottomWall())){
                    player.move(player.getX(), player.getY()+1);
                }
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if(!(cellsArray[player.getX()][player.getY()].isLeftWall())){
                    player.move(player.getX()-1, player.getY());
                }
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if(!(cellsArray[player.getX()][player.getY()].isRightWall())){
                    player.move(player.getX()+1, player.getY());
                }
                break;
        }
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int tmpX = player.getX()*50 + 15;
        int tmpXx = player.getX()*50 + 65;
        int tmpY = player.getY()*50 + 15;
        int tmpYy = player.getY()*50 + 65;
        if((mouseEvent.getX() >= tmpX && mouseEvent.getX() <= tmpXx)
        && (mouseEvent.getY() >= tmpY && mouseEvent.getY() <=tmpYy)){
            if(!flagClickedAgain && flagClicked){
                flagClicked = false;
                flagClickedAgain = true;
            }else{
                flagClicked = true;
                flagClickedAgain = false;
            }
        }
        var path = cellsArray[player.getX()][player.getY()].getAvailablePaths();
        if(flagClicked){
            for(Cell cell : path){
                if((mouseEvent.getX() >= cell.getX()*50 + 15 && mouseEvent.getX() <= cell.getX()*50 + 65)
                && (mouseEvent.getY() >= cell.getY()*50 + 15 && mouseEvent.getY() <=cell.getY()*50 + 65)){
                    player.move(cell.getX(), cell.getY());
                    flagClicked = false;
                }
            }
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}




