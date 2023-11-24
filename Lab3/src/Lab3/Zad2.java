package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;

public class Zad2 extends JFrame implements ActionListener {
    private MenuScreen menuScreen;
    private JPanel panel1, panel2;
    private JButton b_exit, b_r, b_c;


    public Zad2() {
        setSize(700, 600);
        setTitle("Zad 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        addPanel1();
        addPanel2();
    }

    public void addPanel1() {
        panel1 = new Draw();
        panel1.setLayout(new BorderLayout());

        add(panel1);
    }

    public void addPanel2() {
        panel2 = new Draw();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));

        b_r = new JButton("Rectangle");
        b_r.setPreferredSize(new Dimension(100, 50));
        b_r.addActionListener(this);
        b_c = new JButton("Circle");
        b_c.setPreferredSize(new Dimension(100, 50));
        b_exit = new JButton("Exit");
        b_exit.setBackground(Color.RED);
        b_exit.setPreferredSize(new Dimension(100, 50));

        panel2.add(b_r);
        panel2.add(b_c);
        panel2.add(b_exit);

        add(panel2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == b_r) {
            JLabel drawRectangle = new DrawRectangle();
            panel1.add(drawRectangle);
            pack();
        }
    }


    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

}
    class Draw extends JPanel {
        public Draw() {

        }

    }

    class DrawRectangle extends JLabel implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            Graphics g = getGraphics();
            g.setColor(Color.BLUE);
            g.drawRect(0,0,50,50);

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//
//        Graphics2D g2 = (Graphics2D) g;
//
//            Rectangle2D.Double rectangle2D = new Rectangle2D.Double(0,0,10,10);
//            g2.drawRect(0,0,10,10);
//
//    }


    }

