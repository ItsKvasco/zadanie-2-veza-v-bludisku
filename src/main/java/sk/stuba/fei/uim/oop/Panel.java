package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel implements ActionListener{
    private int winsCounter = 0;
    private final JPanel panel;
    private JLabel score;
    GridBagConstraints c;
    private Board board;

    public int getWinsCounter() {
        return winsCounter;
    }

    public void setWinsCounter(int winsCounter) {
        this.winsCounter = winsCounter;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void updateScore(){
        score.setText("Games won : "+ this.winsCounter);
    }

    public Panel(int width, int height, Player player, Cell[][] cellsArray) {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        panel.setPreferredSize(new Dimension(width, height / 8));
        this.c = new GridBagConstraints();
        //Initializing array of buttons
        var buttons = new JButton[5];
        //JLabel conf
        score = new JLabel();
        score.setText("Games won : "+ this.winsCounter);
        score.setForeground(Color.LIGHT_GRAY);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(score, c);
        //Top arrow button conf
        buttons[0] = new JButton(new AbstractAction("↑") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(cellsArray[player.getX()][player.getY()].isTopWall())){
                    player.move(player.getX(), player.getY()-1);
                }
                board.repaint();
            }
        });
        buttons[0].setBackground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(buttons[0], c);

        //Down arrow button conf
        buttons[1] = new JButton(new AbstractAction("↓") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(cellsArray[player.getX()][player.getY()].isBottomWall())){
                    player.move(player.getX(), player.getY()+1);
                }
                board.repaint();
            }
        });
        buttons[1].setBackground(Color.LIGHT_GRAY);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(buttons[1], c);

        //Right arrow button conf
        buttons[2] = new JButton(new AbstractAction("→") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(cellsArray[player.getX()][player.getY()].isRightWall())){
                    player.move(player.getX()+1, player.getY());
                }
                board.repaint();
            }
        });
        buttons[2].setBackground(Color.LIGHT_GRAY);
        c.gridx = 3;
        c.gridy = 3;
        panel.add(buttons[2], c);

        //Left arrow button conf
        buttons[3] = new JButton(new AbstractAction("←") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(cellsArray[player.getX()][player.getY()].isLeftWall())){
                    player.move(player.getX()-1, player.getY());
                }
                board.repaint();
            }
        });
        buttons[3].setBackground(Color.LIGHT_GRAY);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(buttons[3], c);

        //Reset button conf
        buttons[4] = new JButton(new AbstractAction("RESET") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
                    }
                }
                setWinsCounter(0);
                updateScore();
                board.randomizedDFS(cellsArray[0][0]);
                board.repaint();
            }
        });
        buttons[4].setBackground(Color.LIGHT_GRAY);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(buttons[4], c);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
    }
}
