package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame implements ActionListener {

    private JButton b_1, b_2, b_3, b_4, b_5, b_6;
    private JPanel panel, panel2;
    public MenuScreen() {
        setSize(700,600);
        setTitle("Menu Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        addPanel();
    }

    public void addPanel() {

        panel = new MenuLines();
        panel.setBackground(Color.WHITE);
        GroupLayout layout = new GroupLayout(panel);


        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 100,30));
        panel2.setPreferredSize(new Dimension(300,getHeight()));

        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(panel2));
        layout.setVerticalGroup(layout.createParallelGroup().addComponent(panel2));

        panel2.setBackground(Color.WHITE);

        b_1 = new MenuButtons("Zadanie 1");
        b_1.addActionListener(this);
        panel2.add(b_1);
        b_2 = new MenuButtons("Zadanie 2");
        b_2.addActionListener(this);
        panel2.add(b_2);
        b_3 = new MenuButtons("Zadanie 3");
        b_3.addActionListener(this);
        panel2.add(b_3);
        b_4 = new MenuButtons("Zadanie 4");
        b_4.addActionListener(this);
        panel2.add(b_4);
        b_5 = new MenuButtons("Zadanie 5");
        b_5.addActionListener(this);
        panel2.add(b_5);
        b_6 = new MenuButtons("Zadanie 6");
        b_6.addActionListener(this);
        panel2.add(b_6);

        panel.add(panel2);
        add(panel);
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
    }

}
