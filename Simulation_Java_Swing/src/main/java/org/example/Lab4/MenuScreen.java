package org.example.Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame implements ActionListener {
    private JPanel panel1, panel2;
    private JButton b_start, b_close;

    public MenuScreen() {
        setSize(800,600);
        setTitle("Menu Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        addPanel();
    }

    public void addPanel() {
        panel1 = new JPanel();
        panel1.setBackground(Color.decode("#DCC7C8"));
        GroupLayout layout = new GroupLayout(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,100,130));
        panel2.setBackground(Color.decode("#DCC7C8"));
        panel2.setPreferredSize(new Dimension(300,getHeight()));

        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(panel2));
        layout.setVerticalGroup(layout.createParallelGroup().addComponent(panel2));

        b_start = new MenuButtons("START",25,45,25,45, 20, Color.ORANGE, "#0099F7", "#F11712");
        panel2.add(b_start);
        b_start.addActionListener(this);

        b_close = new MenuButtons("CLOSE",20,30,20,30, 15, Color.WHITE, "#E42800", "#211E1E");
        panel2.add(b_close);
        b_close.addActionListener(this);

        add(panel1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    MenuScreen menuScreen = new MenuScreen();
                    menuScreen.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_start) {
            this.setVisible(false);
            GameScreen gameScreen = new GameScreen();
            gameScreen.setVisible(true);
            gameScreen.setMenuScreen(this);
        }
        else if(source == b_close) {
            System.exit(0);
        }
    }
}
