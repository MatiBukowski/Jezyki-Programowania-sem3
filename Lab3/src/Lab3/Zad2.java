package Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Zad2 extends JFrame implements ActionListener{
    private MenuScreen menuScreen;
    private JPanel panel1, panel2;
    private JButton b_exit;
    private JLabel label;
    public  int rect_width, rect_height, oval_width, oval_height;


    public Zad2() {
        setSize(700, 600);
        setTitle("Zad 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        addPanel1();
        addPanel2();
    }

    public void addPanel1() {
        addOptionPane();

        panel1 = new Draw(rect_width, rect_height, oval_width, oval_height);
        panel1.setLayout(new BorderLayout());

        add(panel1);
    }

    public void addPanel2() {
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));

        label = new JLabel("Move shape by dragging mouse");
        label.setForeground(Color.GREEN);
        label.setFont(new Font("Serif", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        b_exit = new JButton("Exit");
        b_exit.setBackground(Color.RED);
        b_exit.setFocusable(false);
        b_exit.setPreferredSize(new Dimension(100, 50));
        b_exit.addActionListener(this);

        panel2.add(label);
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
class Draw extends JPanel implements MouseListener, MouseMotionListener{
    private int rect_width, rect_height, oval_width, oval_height;
    private Rectangle2D rectangle2D;
    private Shape circle;
    private double x_start, y_start;
    private double x_rect=30,y_rect=30;
    private int x_oval=30,y_oval=300;
    private double offSetX, offSetY;
    private boolean dragging_rect = false;
    private boolean dragging_oval = false;

    public Draw(int rect_width, int rect_height, int oval_width, int oval_height) {
        this.rect_height = rect_height;
        this.rect_width = rect_width;
        this.oval_width = oval_width;
        this.oval_height = oval_height;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        rectangle2D = new Rectangle2D.Double(x_rect, y_rect, rect_width, rect_height);
        g2.setColor(Color.BLUE);
        g2.fill(rectangle2D);

        g2.setColor(Color.ORANGE);
        circle = new Ellipse2D.Double(x_oval, y_oval, oval_width, oval_height);
        g2.fill(circle);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x_start = e.getX();
        y_start = e.getY();

        if((x_start>x_rect && x_start<x_rect+rect_width) && (y_start>y_rect && y_start<y_rect+rect_height)) {
            dragging_rect = true;
            offSetX = x_start - x_rect;
            offSetY = y_start - y_rect;
        }

        if((x_start>x_oval && x_start<x_oval+oval_width) && (y_start>y_oval && y_start<y_oval+oval_height)) {
            dragging_oval = true;
            offSetX = x_start - x_oval;
            offSetY = y_start - y_oval;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragging_rect = false;
        dragging_oval = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(dragging_rect) {
            double mx = e.getX();
            double my = e.getY();

            x_rect = mx - offSetX;
            y_rect = my - offSetY;
            //rectangle2D = new Rectangle2D.Double(x_rect,y_rect,rect_width, rect_height);
            repaint();
        }

        if(dragging_oval) {
            double mx = e.getX();
            double my = e.getY();

            x_oval = (int)(mx - offSetX);
            y_oval = (int)(my - offSetY);
            //circle = new Ellipse2D.Double(x_oval, y_oval, oval_width, oval_height);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
