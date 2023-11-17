package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad5 extends JFrame implements ActionListener {

    private MenuScreen menuScreen;
    private JPanel panel1, panel2, panel3;
    private JButton b_exit, b_check;
    private JPasswordField passwordField;
    private JLabel l_info;
    public Zad5() {
        setSize(700,500);
        setTitle("Zadanie 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        setResizable(false);

        addPanel1();
        addPanel2();
        addPanel3();
    }

    public void addPanel1() {
        passwordField = new JPasswordField();
        passwordField.setColumns(50);
        passwordField.addActionListener(this);

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,5,40));
        panel1.add(passwordField);
        add(panel1);
    }

    public void addPanel2() {
        b_check = new JButton("Sprawdź");
        b_check.addActionListener(this);

        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,5,40));
        panel2.add(b_check);
        add(panel2);
    }

    public void addPanel3() {
        b_exit = new JButton("Wyjdź");
        b_exit.addActionListener(this);

        l_info = new JLabel();
        l_info.setSize(40,30);

        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,150,20));
        panel3.add(l_info);
        panel3.add(b_exit);
        add(panel3);
    }

    public void checkAlgorithm() {
        String[] specialCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "[", "]", "{", "}", "|",
                ":", ";", "'", "<", ">", ",", ".", "/", "?"};
        String[] digit = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        int number_of_characters = 0;
        int number_of_digit = 0;


        for(String x: specialCharacters) {
            if (passwordField.getText().contains(x))
                number_of_characters++;
        }

        for(String x: digit) {
            if (passwordField.getText().contains(x))
                number_of_digit++;
        }

        if(passwordField.getText().length()>=12 && number_of_characters<2 && number_of_digit<2)
            l_info.setText("Hasło średniej trudności");
        else if(passwordField.getText().length()<12 && number_of_characters==0 && number_of_digit==0)
            l_info.setText("Hasło słabe");
        else if((passwordField.getText().length()>5 && passwordField.getText().length()<=10) && ((number_of_characters)>0 || number_of_digit>0))
            l_info.setText("Hasło średniej trudności");
        else if((passwordField.getText().length()>0 && passwordField.getText().length()<=5) && ((number_of_characters>0 && number_of_characters<=2) || (number_of_digit>0 && number_of_digit<=2)))
            l_info.setText("Hasło słabe");
        else if(passwordField.getText().length()>=15 && number_of_characters>1 && number_of_digit>1)
            l_info.setText("Hasło trudne");
        else l_info.setText("Hasło słabe");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
        else if(source == b_check || source == passwordField) {
            checkAlgorithm();
        }
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}
