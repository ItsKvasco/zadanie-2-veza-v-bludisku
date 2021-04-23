package sk.stuba.fei.uim.oop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player implements MouseListener {
    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.print("ahoj"+mouseEvent.getX()+" a "+mouseEvent.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent useEvent) {
        System.out.print("ahoj");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
