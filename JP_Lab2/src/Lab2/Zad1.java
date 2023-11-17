package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad1 extends JFrame implements ActionListener {
    MenuScreen menuScreen;
    private JButton b_1, b_exit;
    private JPanel panel1, panel2, panel3, panel4;
    private JLabel label1, label2;
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextArea textArea;
    public Zad1() {
        setSize(700,500);
        setTitle("Zadanie 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));

        addPanel1();
        addPanel2();
        addPanel3();
        addPanel4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_1) {
            textArea.setText("Text: " + textField.getText() + "\nPassword: " + passwordField.getText());
        }
        else if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
    }

    public void addPanel1() {
        label1 = new JLabel("Podaj tekst");
        label1.setFont(new Font("SanSerif", Font.BOLD, 20));
        label2 = new JLabel("Podaj hasło");
        label2.setFont(new Font("SanSerif", Font.BOLD, 20));

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 115,65));
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.add(label1, BorderLayout.CENTER);
        panel1.add(label2, BorderLayout.CENTER);
        add(panel1);
    }

    public void addPanel2() {
        textField = new JFormattedTextField();
        textField.setColumns(23);
        passwordField = new JPasswordField();
        passwordField.setColumns(23);

        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 50));
        panel2.setBackground(Color.GRAY);
        panel2.add(textField);
        panel2.add(passwordField);
        add(panel2);
    }

    public void addPanel3() {
        b_1 = new JButton("Przepisz");
        b_1.addActionListener(this);

        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,40));
        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.add(b_1);
        add(panel3);
    }

    public void addPanel4() {
        textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setRows(5);
        b_exit = new JButton("Wyjdź");
        b_exit.addActionListener(this);


        //panel4 = new JPanel(new GridLayout(1,2));
        panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,150,20));
        panel4.setBackground(Color.GRAY);
        panel4.add(textArea);
        panel4.add(b_exit);
        add(panel4);
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}
