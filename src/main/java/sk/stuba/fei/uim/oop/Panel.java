package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel{
    private JPanel panel;
    private JButton[] buttons;

    public Panel(){
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);
        panel.setPreferredSize(new Dimension(Frame.WIDTH, (Frame.HEIGHT) / 8));
        GridBagConstraints c = new GridBagConstraints();
        addButtons(c);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public void addButtons(GridBagConstraints c){
        //Initializing array of buttons
        JButton[] buttons = new JButton[5];
        //Top arrow button conf
        buttons[0] = new JButton(new AbstractAction("↑") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("UP");
            }
        });
        buttons[0].setBackground(Color.LIGHT_GRAY);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(buttons[0],c);
        //Down arrow button conf
        buttons[1] = new JButton(new AbstractAction("↓") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("DOWN");
            }
        });
        buttons[1].setBackground(Color.LIGHT_GRAY);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(buttons[1],c);
        //Right arrow button conf
        buttons[2] = new JButton(new AbstractAction("→") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("RIGHT");
            }
        });
        buttons[2].setBackground(Color.LIGHT_GRAY);
        c.gridx = 3;
        c.gridy = 3;
        panel.add(buttons[2],c);
        //Left arrow button conf
        buttons[3] = new JButton(new AbstractAction("←") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("LEFt");
            }
        });
        buttons[3].setBackground(Color.LIGHT_GRAY);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(buttons[3],c);
        //Reset button conf
        buttons[4] = new JButton(new AbstractAction("RESET") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("RESET");
            }
        });
        buttons[4].setBackground(Color.LIGHT_GRAY);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(buttons[4],c);
    }
}
