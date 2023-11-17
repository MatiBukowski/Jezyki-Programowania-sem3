package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zad4 extends JFrame implements ActionListener {

    private MenuScreen menuScreen;
    private JPanel mainPanel, panel;
    private JButton b_exit;
    private JTextField t_result;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton b_add, b_sub, b_mul, b_div, b_dec, b_equ, b_del, b_clr;
    private double num1=0, num2=0, result=0;
    private char operator;
    public Zad4() {
        setSize(420,550);
        setTitle("Zadanie 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        addMainPanel();
    }

    public void addMainPanel() {
        mainPanel = new JPanel(null);
        //mainPanel.setBackground(Color.GRAY);
        mainPanel.setBounds(0,0,420,550);

        t_result = new JTextField();
        t_result.setBounds(50,25,300, 50);
        t_result.setEditable(false);
        mainPanel.add(t_result);

        b_exit = new JButton("Wyjdź");
        b_exit.setBounds(320,483,80,30);
        b_exit.addActionListener(this);
        mainPanel.add(b_exit);

        addFunctionButtons();
        addNumberButtons();
        displayButtons();

        mainPanel.add(panel);
        mainPanel.add(b_del);
        mainPanel.add(b_clr);

        add(mainPanel);
    }

    public void addFunctionButtons() {
        b_add = new JButton("+");
        b_sub = new JButton("-");
        b_mul = new JButton("*");
        b_div = new JButton("/");
        b_dec = new JButton(".");
        b_equ = new JButton("=");
        b_del = new JButton("Delete");
        b_clr = new JButton("Clear");
        functionButtons[0] = b_add;
        functionButtons[1] = b_sub;
        functionButtons[2] = b_mul;
        functionButtons[3] = b_div;
        functionButtons[4] = b_dec;
        functionButtons[5] = b_equ;
        functionButtons[6] = b_del;
        functionButtons[7] = b_clr;

        for(int i =0; i<8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        b_del.setBounds(50,430,145,50);
        b_clr.setBounds(205,430,145,50);
    }

    public void addNumberButtons() {
        for(int i =0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }
    }

    public void displayButtons() {
        panel = new JPanel(new GridLayout(4,4,10,10));
        panel.setBounds(50,100,300,300);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(b_add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(b_sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(b_mul);
        panel.add(b_dec);
        panel.add(numberButtons[0]);
        panel.add(b_equ);
        panel.add(b_div);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }

        for(int i=0; i<10; i++) {
            if(source == numberButtons[i])
                t_result.setText(t_result.getText().concat(String.valueOf(i)));
        }

        if(source == b_dec)
            t_result.setText(t_result.getText().concat("."));
        if(source == b_add) {
            num1 = Double.parseDouble(t_result.getText());
            operator = '+';
            t_result.setText("");
        }
        if(source == b_sub) {
            if(t_result.getText().equals(""))
                t_result.setText("-");
            else {
                num1 = Double.parseDouble(t_result.getText());
                operator = '-';
                t_result.setText("");
            }
        }
        if(source == b_mul) {
            num1 = Double.parseDouble(t_result.getText());
            operator = '*';
            t_result.setText("");
        }
        if(source == b_div) {
            num1 = Double.parseDouble(t_result.getText());
            operator = '/';
            t_result.setText("");
        }
        if(source == b_equ) {
            num2 = Double.parseDouble(t_result.getText());

            switch(operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    if(num2 == 0.0) {
                        t_result.setText("Can't divide by 0");
                        return;
                    }
                    else result=num1/num2;
                    break;
            }
            t_result.setText(String.valueOf(result));
            num1=result;
        }
        if(source == b_clr) {
            t_result.setText("");
        }
        if(source == b_del) {
            String text = t_result.getText();
            t_result.setText("");
            for(int i =0; i<text.length()-1; i++) {
                t_result.setText(t_result.getText() + text.charAt(i));
            }
        }
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}
