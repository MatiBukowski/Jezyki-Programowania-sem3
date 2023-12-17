package org.example.Lab4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Speed implements Runnable, KeyListener, MouseListener {

    private int upVelocity = 1;
    private int downVelocity = 2;
    private float speed_amount = 0;
    private int gear_number;
    private boolean keyPressed = false;
    private int delay = 1200;
    private int gear1_min = 9;
    private int gear1_max = 61;
    private int gear2_min = 17;
    private int gear2_max = 112;
    private int gear3_min = 25;
    private int gear3_max = 159;
    private int gear4_min = 35;
    private int gear4_max = 225;
    private int gear5_min = 47;
    private int gear5_max = 280;

    public Speed() {
    }

    @Override
    public void run() {
        while (true) {
            reduceWithoutGas();
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void reduceWithoutGas() {
        if (!keyPressed && gear_number == 1) {
            if (speed_amount > gear1_min)
                speed_amount -= downVelocity/2;
            else if(speed_amount < gear1_min) {
                speed_amount += upVelocity;
            }
        }
        else if(!keyPressed && gear_number == 2) {
            if (speed_amount > gear2_min)
                speed_amount -= downVelocity/2;
        }
        else if(!keyPressed && gear_number == 3) {
            if (speed_amount > gear3_min)
                speed_amount -= downVelocity/2;
        }
        else if(!keyPressed && gear_number == 4) {
            if (speed_amount > gear4_min)
                speed_amount -= downVelocity/2;
        }
        else if(!keyPressed && gear_number == 5) {
            if (speed_amount > gear5_min)
                speed_amount -= downVelocity/2;
        }
    }

    public void speedUp(KeyEvent e) {

        if(e.getKeyChar() == 's') {
            if (speed_amount > 0)
                speed_amount -= downVelocity;
        }
        else if(e.getKeyChar() == 'w') {
            if(gear_number == 0) {

            }
            else if(gear_number == 1) {
                if(speed_amount < gear1_max)
                    speed_amount += upVelocity;
            }
            else if(gear_number == 2) {
                if(speed_amount < gear2_max && speed_amount >= gear2_min)
                    speed_amount += upVelocity;
                else if(speed_amount < gear2_max && speed_amount < gear2_min)
                    speed_amount += 0.2*upVelocity;
            }
            else if(gear_number == 3) {
                if(speed_amount < gear3_max && speed_amount >= gear3_min)
                    speed_amount += upVelocity;
                else if(speed_amount < gear3_max && speed_amount < gear3_min)
                    speed_amount += 0.2*upVelocity;
            }
            else if(gear_number == 4) {
                if(speed_amount < gear4_max && speed_amount >= gear4_min)
                    speed_amount += upVelocity;
                else if(speed_amount < gear4_max && speed_amount < gear4_min)
                    speed_amount += 0.2*upVelocity;
            }
            else if(gear_number == 5) {
                if(speed_amount < gear5_max && speed_amount >= gear5_min)
                    speed_amount += upVelocity;
                else if(speed_amount < gear5_max && speed_amount < gear5_min)
                    speed_amount += 0.2*upVelocity;
            }
        }

        if(e.getKeyCode() == 38) {
            if(gear_number < 5)
                gear_number ++;
        }
        else if(e.getKeyCode() == 40) {
            if(gear_number > 0) {
                gear_number--;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed = true;
        speedUp(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    public float getSpeed_amount() {
        return speed_amount;
    }

    public int getGear_number() {
        return gear_number;
    }
}
