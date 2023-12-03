package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Zad5 extends JFrame implements ActionListener{
    private MenuScreen menuScreen;
    private JPanel panel1, panel2;
    private JButton b_exit;
    private JLabel label1, label2, label3;
    private int rect_width, rect_height, oval_width, oval_height;


    public Zad5() {
        setSize(700, 600);
        setTitle("Zad 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        addPanel1();
        addPanel2();
    }

    public void addPanel1() {
        addOptionPane();

        label1 = new JLabel("");
        label1.setFont(new Font("Serif", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(250,40));

        label2 = new JLabel("");
        label2.setFont(new Font("Serif", Font.BOLD, 18));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setPreferredSize(new Dimension(300,40));

        label3 = new JLabel("Scroll to change size of shape");
        label3.setFont(new Font("Serif", Font.BOLD, 18));
        label3.setForeground(Color.GREEN);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setPreferredSize(new Dimension(300,40));

        panel1 = new Draw_3(rect_width, rect_height, oval_width, oval_height, label1, label2);
        panel1.setLayout(new BorderLayout());

        add(panel1);
    }

    public void addPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 70));

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
class Draw_3 extends JPanel implements MouseListener, MouseWheelListener {
    private int rect_width, rect_height, oval_width, oval_height;
    private Rectangle2D rectangle2D;
    private Shape circle;
    private double x_rect=100,y_rect=30;
    private int x_oval=100,y_oval=300;
    private JLabel label1, label2;
    private boolean clicked = false;
    private boolean rect_select = false, oval_select = false;

    public Draw_3(int rect_width, int rect_height, int oval_width, int oval_height, JLabel label1, JLabel label2) {
        this.rect_height = rect_height;
        this.rect_width = rect_width;
        this.oval_width = oval_width;
        this.oval_height = oval_height;
        this.label1 = label1;
        this.label2 = label2;

        addMouseListener(this);
        addMouseWheelListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(!rect_select) {
            rectangle2D = new Rectangle2D.Double(x_rect, y_rect, rect_width, rect_height);
            g2.setColor(Color.BLUE);
            g2.fill(rectangle2D);
        }
        else if(rect_select) {
            rectangle2D = new Rectangle2D.Double(x_rect, y_rect, rect_width, rect_height);
            g2.setColor(Color.GREEN);
            g2.fill(rectangle2D);
        }

        if(!oval_select) {
            circle = new Ellipse2D.Double(x_oval, y_oval, oval_width, oval_height);
            g2.setColor(Color.ORANGE);
            g2.fill(circle);
        }
        else if(oval_select) {
            circle = new Ellipse2D.Double(x_oval, y_oval, oval_width, oval_height);
            g2.setColor(Color.GREEN);
            g2.fill(circle);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!clicked) {
            label2.setText("You clicked the drawing panel");
            label2.setForeground(Color.ORANGE);
            clicked = true;
        }
        else if(clicked) {
            label2.setText("You unclicked the drawing panel");
            label2.setForeground(Color.RED);
            clicked = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        double x_start = e.getX();
        double y_start = e.getY();

        if (oval_select == false && rect_select == false) {
            if ((x_start > x_rect && x_start < x_rect + rect_width) && (y_start > y_rect && y_start < y_rect + rect_height)) {
                rect_select = true;
                repaint();      // tylko po to aby zmieniał się kolor przy kliknięciu na figurę
            }
        }
        else if (oval_select == false && rect_select == true) {
            if ((x_start > x_rect && x_start < x_rect + rect_width) && (y_start > y_rect && y_start < y_rect + rect_height)) {
                rect_select = false;
                repaint();      // tylko po to aby zmieniał się kolor przy kliknięciu na figurę
            }
        }

        if (rect_select == false && oval_select == false) {
            if ((x_start > x_oval && x_start < x_oval + oval_width) && (y_start > y_oval && y_start < y_oval + oval_height)) {
                oval_select = true;
                repaint();      // tylko po to aby zmieniał się kolor przy kliknięciu na figurę
            }
        }
        else if (rect_select == false && oval_select == true) {
            if ((x_start > x_oval && x_start < x_oval + oval_width) && (y_start > y_oval && y_start < y_oval + oval_height)) {
                oval_select = false;
                repaint();      // tylko po to aby zmieniał się kolor przy kliknięciu na figurę
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label1.setText("You entered the drawing panel");
        label1.setForeground(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label1.setText("You exited the drawing panel");
        label1.setForeground(Color.RED);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(rect_select) {
            if(e.getWheelRotation() == -1) {
                rect_width += 5;
                rect_height += 5;
                repaint();
            }
            else if(e.getWheelRotation() == 1) {
                rect_width -= 5;
                rect_height -= 5;
                repaint();
            }
        }

        if(oval_select) {
            if(e.getWheelRotation() == -1) {
                oval_width += 5;
                oval_height += 5;
                repaint();
            }
            else if(e.getWheelRotation() == 1) {
                oval_width -= 5;
                oval_height -= 5;
                repaint();
            }
        }
    }
}