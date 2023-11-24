package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Zad1 extends JFrame implements MouseListener, KeyListener {
    private MenuScreen menuScreen;
    private JTextField textField;
    private JPanel panel;

    public Zad1() {
        setSize(700,600);
        setTitle("Zad 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        addPanel();
    }

    public void addPanel() {
        panel = new JPanel(new BorderLayout());
        textField = new JTextField();
        textField.addMouseListener(this);

        panel.add(textField, BorderLayout.CENTER);
        add(panel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Pozycja myszki: " + e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
