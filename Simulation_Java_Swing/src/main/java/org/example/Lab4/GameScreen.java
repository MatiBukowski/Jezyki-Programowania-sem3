package org.example.Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GameScreen extends JFrame {
    private MenuScreen menuScreen;
    private JPanel mainPanel, buttonsPanel;
    private GamePanel gamePanel;
    private JButton b_plus, b_minus, b_exit;
    private TextField t_time, t_points, t_balls;
    private TextField t_speed, t_RPM, t_gear;
    public GameScreen() {
        setSize(800,600);
        setTitle("Game Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(2,2));

        addMainPanel();
    }

    public void addMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;     //fill vertically and horizontally display area
        gbc.insets = new Insets(5,5,5,5);   //wstawki między elemnami grida

        addGamePanel(gbc);
        addButtonsPanel(gbc);

        add(mainPanel);

    }

    public void addGamePanel(GridBagConstraints gbc) {
        gamePanel = new GamePanel();
        gamePanel.setBackground(Color.GRAY);
        gbc.weightx = 9;
        gbc.weighty = 1;

        mainPanel.add(gamePanel,gbc);
    }

    public void addButtonsPanel(GridBagConstraints gbc) {
        buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBackground(Color.decode("#D3A4A7"));
        gbc.weightx = 1;

        GridBagConstraints c = new GridBagConstraints();
        c.weighty = 1;
        addComponents_2(c);
        mainPanel.add(buttonsPanel,gbc);
    }

    public void addComponents_2(GridBagConstraints c) {
        t_time = new TextField();
        t_time.setEnabled(false);
        t_time.setPreferredSize(new Dimension(200,70));
        c.gridx = 0;
        c.gridy = 0;
        buttonsPanel.add(t_time,c);

        t_points = new TextField();
        t_points.setEnabled(false);
        t_points.setPreferredSize(new Dimension(200,70));
        c.gridx = 0;
        c.gridy = 1;
        buttonsPanel.add(t_points,c);

        t_balls = new TextField();
        t_balls.setEnabled(false);
        t_balls.setPreferredSize(new Dimension(100,50));
        c.gridx = 0;
        c.gridy = 2;
        buttonsPanel.add(t_balls,c);

        b_plus = new MenuButtons("+1 BALL", 15,15,15,15, 15, Color.BLACK,"#69F95B", "#69F95B");
        b_plus.setFocusable(false);
        c.gridx = 0;
        c.gridy = 3;
        buttonsPanel.add(b_plus,c);

        b_minus = new MenuButtons("-1 BALL", 15,15,15,15, 15, Color.BLACK,"#F2444F", "#F2444F");
        b_minus.setFocusable(false);
        c.gridx = 0;
        c.gridy = 4;
        buttonsPanel.add(b_minus, c);

        b_exit = new MenuButtons("EXIT", 15,40,15,40, 17, Color.WHITE,"#AB000B", "#AB000B");
        b_exit.setFocusable(false);
//        b_exit.setPreferredSize(new Dimension(150,50));
        c.gridx = 0;
        c.gridy = 5;
        buttonsPanel.add(b_exit, c);
    }

    public void addTextFields() {

    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}
