package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Zad7 extends JFrame implements ActionListener {
    private MenuScreen menuScreen;
    private JPanel panel1, panel2;
    private JButton b_exit, b_load, b_zoomin, b_zoomout;
    private JLabel l_image;
    private JScrollPane scrollPane;
    public Zad7() {
        setSize(700, 537);
        setTitle("Zadanie 7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);

        addPanel1();
        addPanel2();
    }

    public void addPanel1() {
        panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.gray);
        panel1.setBounds(0,0,500,500);

        add(panel1);
    }
    public void addPanel2() {
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,50));
        panel2.setBackground(Color.red);
        panel2.setBounds(500,0,190,500);

        b_load = new JButton("Load Image");
        b_load.addActionListener(this);
        panel2.add(b_load);

        b_zoomin = new JButton("Zoom in");
        b_zoomin.addActionListener(this);
        panel2.add(b_zoomin);

        b_zoomout = new JButton("Zoom out");
        b_zoomout.addActionListener(this);
        panel2.add(b_zoomout);

        b_exit = new JButton("Exit");
        b_exit.addActionListener(this);
        panel2.add(b_exit);

        add(panel2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == b_exit) {
            this.setVisible(false);
            menuScreen.setVisible(true);
        }
        else if(source == b_load) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:/Users/mateu/Desktop"));

            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                try{
                    ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());

                    l_image = new JLabel();
                    l_image.setIcon(image);
                    scrollPane = new JScrollPane(l_image);

                    panel1.add(scrollPane);


                }catch(Exception exception) {
                    JOptionPane.showConfirmDialog(null, "To nie jest obraz", "Błąd", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(source == b_zoomin) {
        }
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

}
