package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class Zad3 extends JFrame implements KeyListener, ActionListener {
    private MenuScreen menuScreen;
    private JPanel panel;
    private JLabel l_A, l_B, l_C, l_Info;
    private JButton b_exit;
    private JTextField textField;

    public Zad3() {
        setSize(700, 600);
        setTitle("Zad 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new BorderLayout());

        addPanel();
    }

    public void addPanel() {
        panel = new JPanel();
        l_A = new JLabel("A - Change color to RED");
        l_A.setForeground(Color.RED);
        l_A.setPreferredSize(new Dimension(300, 100));
        l_B = new JLabel("B - Change color to Blue");
        l_B.setForeground(Color.BLUE);
        l_B.setPreferredSize(new Dimension(300, 100));
        l_C = new JLabel("C - Clean TextField");
        l_C.setPreferredSize(new Dimension(300, 100));
        l_Info = new JLabel("Ctrl - Resume writing");
        l_Info.setPreferredSize(new Dimension(300, 100));
        b_exit = new JButton("Exit");
        b_exit.setPreferredSize(new Dimension(100, 50));
        b_exit.setBackground(Color.RED);
        b_exit.setFocusable(false);
        b_exit.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setFont(new Font("Serif", Font.BOLD, 20));
        textField.addKeyListener(this);
        textField.addActionListener(this);

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textField)
                        .addComponent(l_A)
                        .addComponent(l_B)
                        .addComponent(l_C)
                        .addComponent(l_Info))
                .addGroup(layout.createParallelGroup(LEADING).addComponent(b_exit)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(textField))
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(l_A).addComponent(b_exit))
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(l_B))
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(l_C))
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(l_Info)));

        add(panel);
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!textField.isEditable()) {
            if(e.getKeyChar() == 'A')
                textField.setForeground(Color.RED);
            else if(e.getKeyChar() == 'B')
                textField.setForeground(Color.BLUE);
            else if(e.getKeyChar() == 'C')
                textField.setText("");
            else if(e.getKeyCode() == 17)
                textField.setEditable(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == textField) {
            textField.setEditable(false);
        }
        else if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
    }
}
