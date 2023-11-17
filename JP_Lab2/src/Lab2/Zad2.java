package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class Zad2 extends JFrame implements ActionListener {
    MenuScreen menuScreen;
    private JPanel panel1;
    private JButton b_color, b_size, b_place, b_exit;
    private JLabel label;
    private int label_width = 100;
    private int label_height = 50;
    public Zad2() {
        setSize(700,500);
        setTitle("Zadanie 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        addPanel1();
    }

    public void addPanel1() {
        b_color = new JButton("Zmień kolor");
        b_color.setBounds(18,50,200,50);
        b_color.addActionListener(this);
        b_size = new JButton("Zmień rozmiar");
        b_size.setBounds(238,50,200,50);
        b_size.addActionListener(this);
        b_place = new JButton("Zmień położenie");
        b_place.setBounds(458,50,200,50);
        b_place.addActionListener(this);
        b_exit = new JButton("Wyjdź");
        b_exit.setBounds(570, 430, 100, 30);
        b_exit.addActionListener(this);
        label = new JLabel("Zmień mnie");
        label.setBounds(300, 280, label_width,label_height);


        panel1 = new JPanel(null);
        panel1.add(b_color);
        panel1.add(b_size);
        panel1.add(b_place);
        panel1.add(b_exit);
        panel1.add(label);

        add(panel1);
    }

    public void actionForColor() {
//        Color color;
//            String string_color = JOptionPane.showInputDialog(null, "Podaj kolor po angielsku","Zmiana koloru", JOptionPane.PLAIN_MESSAGE);
//            try {
//                Field field = Class.forName("java.awt.Color").getField(string_color);
//                color = (Color) field.get(null);
//                label.setForeground(color);
//            } catch (Exception exception) {
//               JOptionPane.showConfirmDialog(null, "Kolor nie istnieje", "Błąd", JOptionPane.WARNING_MESSAGE);
//            }
        Color color = JColorChooser.showDialog(null, "Podaj kolor", Color.BLACK);
        label.setForeground(color);
    }
    public void actionForSize() {
        String size = JOptionPane.showInputDialog(null, "Podaj rozmiar czcionki","Zmiana rozmiaru", JOptionPane.PLAIN_MESSAGE);

        try {
            int int_size = Integer.valueOf(size);
            label.setFont(new Font("SanSerif", Font.PLAIN, int_size));

            label_width = 10*int_size;
            label_height = 5*int_size;
            label.setSize(label_width, label_height);
        } catch (Exception exception) {
            JOptionPane.showConfirmDialog(null, "To nie jest liczba", "Błąd", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void actionForPlace() {
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        Object[] fields = {
                "Podaj położenie dla X (od 0 do 600)", field1,
                "Podaj położenie dla Y (od 100 do 400)", field2
        };

        JOptionPane.showConfirmDialog(null, fields, "Zmiana położenia", JOptionPane.PLAIN_MESSAGE);
        String x = field1.getText();
        String y = field2.getText();

        try{
            int int_x = Integer.valueOf(x);
            int int_y = Integer.valueOf(y);

            label.setBounds(int_x, int_y, label_width, label_height);
        } catch(Exception exception) {
            JOptionPane.showConfirmDialog(null, "Błąd", "Błąd", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_color) {
            actionForColor();
        }
        else if(source == b_size) {
            actionForSize();
        }
        else if(source == b_place) {
            actionForPlace();
        }
        else if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}
