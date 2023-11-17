package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame implements ActionListener {
    private JButton b_1, b_2, b_3, b_4, b_5, b_6, b_7;
    private JPanel panel;
    public MenuScreen() {
        setSize(700,500);
        setTitle("Menu Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_1) {
            this.setVisible(false);
            Zad1 zad1 = new Zad1();
            zad1.setVisible(true);
            zad1.setMenuScreen(this);
        }
        else if(source == b_2) {
            this.setVisible(false);
            Zad2 zad2 = new Zad2();
            zad2.setVisible(true);
            zad2.setMenuScreen(this);
        }
        else if(source == b_3) {
            this.setVisible(false);
            Zad3 zad3 = new Zad3();
            zad3.setVisible(true);
            zad3.setMenuScreen(this);
        }
        else if(source == b_4) {
            this.setVisible(false);
            Zad4 zad4 = new Zad4();
            zad4.setVisible(true);
            zad4.setMenuScreen(this);
        }
        else if(source == b_5) {
            this.setVisible(false);
            Zad5 zad5 = new Zad5();
            zad5.setVisible(true);
            zad5.setMenuScreen(this);
        }


    }

    public static void main(String[] args) {
        MenuScreen menuScreen = new MenuScreen();
        menuScreen.setVisible(true);
    }

    public void addPanel() {
        b_1 = new JButton("Zadanie 1");
        b_1.addActionListener(this);
        b_2 = new JButton("Zadanie 2");
        b_2.addActionListener(this);
        b_3 = new JButton("Zadanie 3");
        b_3.addActionListener(this);
        b_4 = new JButton("Zadanie 4");
        b_4.addActionListener(this);
        b_5 = new JButton("Zadanie 5");
        b_5.addActionListener(this);
        b_6 = new JButton("Zadanie 6");
        b_6.addActionListener(this);
        b_7 = new JButton("Zadanie 7");
        b_7.addActionListener(this);

        panel = new JPanel(new GridLayout(7,1));
        panel.setBackground(Color.CYAN);

        panel.add(b_1, BorderLayout.CENTER);
        panel.add(b_2, BorderLayout.CENTER);
        panel.add(b_3, BorderLayout.CENTER);
        panel.add(b_4, BorderLayout.CENTER);
        panel.add(b_5, BorderLayout.CENTER);
        panel.add(b_6, BorderLayout.CENTER);
        panel.add(b_7, BorderLayout.CENTER);

        add(panel);
    }
}
