package org.example.Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener{
    private TextField t_speed, t_RPM, t_gear;
    private Speed speed;
    private int speed_amount = 0;
    private int gear_number;
    private Timer timer;

    public GamePanel() {
        setFocusable(true);

        setLayout(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();
        d.insets = new Insets(30,20,30,20);
        addComponents(d);

        timer = new Timer(100,this);
        timer.start();

        addSpeed();
    }
    public void addComponents(GridBagConstraints d) {
        t_speed = new TextField();
        t_speed.setText(String.valueOf(speed_amount));
        t_speed.setEnabled(false);
        t_speed.setFont(new Font("Serif", Font.BOLD, 25));
        t_speed.setPreferredSize(new Dimension(150,70));
        d.gridx = 0;
        d.gridy = 0;
        add(t_speed, d);

        t_RPM = new TextField();
        t_RPM.setEnabled(false);
        t_RPM.setPreferredSize(new Dimension(150,70));
        t_RPM.setFont(new Font("Serif", Font.BOLD, 25));
        d.gridx = 2;
        d.gridy = 0;
        add(t_RPM, d);

        t_gear = new TextField("N");
        t_gear.setEnabled(false);
        t_gear.setPreferredSize(new Dimension(100,70));
        t_gear.setFont(new Font("Serif", Font.BOLD, 25));
        d.gridx = 1;
        d.gridy = 1;
        add(t_gear, d);
    }

    public void addSpeed() {
        speed = new Speed();
        addMouseListener(speed);
        addKeyListener(speed);

        new Thread(speed).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        speed_amount = (int)speed.getSpeed_amount();
        t_speed.setText(String.valueOf(speed_amount));

        gear_number = speed.getGear_number();
        if(gear_number != 0) {
            t_gear.setText(String.valueOf(gear_number));
        }
        else
            t_gear.setText("N");
    }
}

