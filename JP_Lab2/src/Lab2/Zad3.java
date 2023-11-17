package Lab2;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad3 extends JFrame implements ActionListener {
    MenuScreen menuScreen;
    private JPanel panel, panel2;
    private JButton b_1, b_exit;
    private JLabel label_1, label_2;
    private String imie;
    public Zad3() {
        setSize(700,500);
        setTitle("Zadanie 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        addPanel1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
        else if(source == b_1) {
            imie = JOptionPane.showInputDialog(null, "Podaj nowe imię", "Pobieranie imienia", JOptionPane.PLAIN_MESSAGE);
            label_2.setText(imie);
        }
    }

    public void addPanel1() {
        imie = JOptionPane.showInputDialog(null, "Podaj imię", "Pobieranie imienia", JOptionPane.PLAIN_MESSAGE);

        b_1 = new JButton("Podaj nowe imię");
        b_1.setBounds(200,280,300, 30);
        b_1.addActionListener(this);
        b_exit = new JButton("Wyjdź");
        b_exit.setBounds(570, 430, 100, 30);
        b_exit.addActionListener(this);

        panel = new JPanel(null);
        panel.add(b_1);
        panel.add(b_exit);

        addPanel2();
        panel.add(panel2);

        add(panel);
    }

    public void addPanel2() {
        label_1 = new JLabel("Witaj");
        label_1.setFont(new Font("SanSerif", Font.BOLD, 30));
        label_1.setForeground(Color.ORANGE);
        label_1.setHorizontalAlignment(SwingConstants.CENTER);

        label_2 = new JLabel(imie);
        label_2.setFont(new Font("SanSerif", Font.BOLD, 30));
        label_2.setForeground(Color.ORANGE);
        label_2.setHorizontalAlignment(SwingConstants.CENTER);

        panel2 = new JPanel(new GridLayout(2,1));
        panel2.setBounds(50,50,610,200);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.add(label_1);
        panel2.add(label_2);
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}
