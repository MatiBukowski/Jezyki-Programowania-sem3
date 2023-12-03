package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Zad6 extends JFrame implements ActionListener{
    private MenuScreen menuScreen;
    private JPanel panel2;
    private Draw_4 panel1;
    private JButton b_exit;
    private JLabel label1, label2, label3;
    private int rect_width, rect_height, oval_width, oval_height;

    public Zad6() {
        setSize(700, 600);
        setTitle("Zad 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        addOptionPane();

        panel1 = new Draw_4(rect_width, rect_height, oval_width, oval_height);
        panel1.setLayout(new BorderLayout());
        panel1.addKeyListener(panel1);
        panel1.setFocusable(true);

        add(panel1);

        addPanel2();
    }

    public void addPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 70));

        label1 = new JLabel("Space - shape change");
        label1.setForeground(Color.GREEN);
        label1.setFont(new Font("Serif", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(250,40));

        label2 = new JLabel("Shift - size change");
        label2.setForeground(Color.GREEN);
        label2.setFont(new Font("Serif", Font.BOLD, 18));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setPreferredSize(new Dimension(300,40));

        label3 = new JLabel("Ctrl - Color change");
        label3.setForeground(Color.GREEN);
        label3.setFont(new Font("Serif", Font.BOLD, 18));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setPreferredSize(new Dimension(300,40));

        b_exit = new JButton("Exit");
        b_exit.setBackground(Color.RED);
        b_exit.setFocusable(false);
        b_exit.setPreferredSize(new Dimension(100, 50));
        b_exit.addActionListener(this);

        panel2.add(label1);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(b_exit);

        add(panel2);
    }

    public void addOptionPane() {
        int check = 0;

        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();

        Object[] fields = {
                "Rectangle width", field1,
                "Rectangle height", field2,
                "Oval width", field3,
                "Oval height", field4
        };

        while(check == 0) {
            JOptionPane.showConfirmDialog(null, fields, "Shapes's dimensions", JOptionPane.PLAIN_MESSAGE);

            String st_rect_width = field1.getText();
            String st_rect_height = field2.getText();
            String st_oval_width = field3.getText();
            String st_oval_height = field4.getText();

            try {
                rect_height = Integer.valueOf(st_rect_height);
                rect_width = Integer.valueOf(st_rect_width);
                oval_height = Integer.valueOf(st_oval_height);
                oval_width = Integer.valueOf(st_oval_width);
                check = 1;

            } catch (Exception exception) {
                JOptionPane.showConfirmDialog(null, "It's not a number", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

}
class Draw_4 extends JPanel implements KeyListener {
    private int rect_width, rect_height, oval_width, oval_height;
    private Rectangle2D rectangle2D;
    private Shape circle;
    private double x_rect = 100, y_rect = 200;
    private int x_oval = 100, y_oval = 200;
    private boolean isRect = true, isOval = false;
    private boolean new_color = false;
    private int memory_rect_width, memory_rect_height;

    public Draw_4(int rect_width, int rect_height, int oval_width, int oval_height) {
        this.rect_height = rect_height;
        this.rect_width = rect_width;
        this.oval_width = oval_width;
        this.oval_height = oval_height;
        this.memory_rect_width = rect_width;
        this.memory_rect_height = rect_height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(isRect) {
            if(!new_color) {
                rectangle2D = new Rectangle2D.Double(x_rect, y_rect, rect_width, rect_height);
                g2.setColor(Color.BLUE);
                g2.fill(rectangle2D);
            }
            else if(new_color) {
                rectangle2D = new Rectangle2D.Double(x_rect, y_rect, rect_width, rect_height);
                g2.setColor(Color.RED);
                g2.fill(rectangle2D);
            }
        }

        if(isOval) {
            circle = new Ellipse2D.Double(x_oval, y_oval, oval_width, oval_height);
            g2.setColor(Color.ORANGE);
            g2.fill(circle);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32) {
            isRect = false;
            isOval = true;
            repaint();
        }
        else if(e.getKeyCode() == 16) {
            rect_width = 150;
            rect_height = 150;
            repaint();
        }
        else if(e.getKeyCode() == 17) {
            new_color = true;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 32) {
            isRect = true;
            isOval = false;
            repaint();
        }
        else if(e.getKeyCode() == 16) {
            rect_width = memory_rect_width;
            rect_height = memory_rect_height;
            repaint();
        }
        else if(e.getKeyCode() == 17) {
            new_color = false;
            repaint();
        }
    }
}