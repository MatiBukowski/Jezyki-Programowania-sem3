package Lab2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Zad6 extends JFrame implements ActionListener {
    private MenuScreen menuScreen;
    private JPanel panel1, panel2;
    private JButton b_exit, b_add, b_remove;
    private JTable table;
    private JScrollPane scrollPane;
    private String[][] objects = {};
    private String heading[] = {"Name", "Phone number", "Email"};
    private DefaultTableModel model;

    public Zad6() {
        setSize(700, 500);
        setTitle("Zadanie 6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        addPanel1();
        addPanel2();
    }

    public void addPanel1() {
        panel1 = new JPanel(new BorderLayout());

        model = new DefaultTableModel(objects, heading);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        panel1.add(scrollPane, BorderLayout.CENTER);

        add(panel1);
    }
    public void addPanel2() {
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,100));
        panel2.setBackground(Color.gray);

        b_add = new JButton("Add new Contact");
        b_add.addActionListener(this);
        panel2.add(b_add);

        b_remove = new JButton("Remove Contact");
        b_remove.addActionListener(this);
        panel2.add(b_remove);

        b_exit = new JButton("Exit");
        b_exit.addActionListener(this);
        panel2.add(b_exit);

        add(panel2);
    }

    public void addRow() {
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();

        Object[] fields = {
                "Podaj imię", field1,
                "Podaj nr telefonu", field2,
                "Podaj email", field3
        };

        JOptionPane.showConfirmDialog(null, fields, "Dodawanie kontaktu", JOptionPane.PLAIN_MESSAGE);

        try {
            String name = field1.getText();
            String phone_number = field2.getText();
            String email = field3.getText();

            model.addRow(new Object[] {name,phone_number,email});
        } catch (Exception exception) {
            JOptionPane.showConfirmDialog(null, "To nie jest liczba", "Błąd", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void removeRow() {
        String row = JOptionPane.showInputDialog(null, "Podaj numer wiersza, który chcesz usunąć", "Dodawanie kontaktu", JOptionPane.PLAIN_MESSAGE);

        try {
            int int_row = Integer.valueOf(row);
            model.removeRow(int_row-1);
        } catch(Exception exception) {
            JOptionPane.showConfirmDialog(null, "To nie jest liczba", "Błąd", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
        else if(source == b_add) {
            addRow();
        }
        else if(source == b_remove) {
            removeRow();
        }
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }
}

class Kontakt {

    private String imie, nr_tel, email;
    public Kontakt(String imie, String nr_tel, String email) {
        this.imie = imie;
        this.nr_tel = nr_tel;
        this.email = email;
    }

    public String getImie() {
        return imie;
    }
    public String getNr_tel() {
        return nr_tel;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Imię: " + imie + " Nr tel: " + nr_tel + " Email: " + email;
    }

}

