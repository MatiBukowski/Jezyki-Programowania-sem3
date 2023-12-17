package org.example.Threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character implements Runnable, KeyListener {

    private Image guy = new ImageIcon("src/main/resources/Images/stickman3.png").getImage();
    private int width, height;
    private int x_pos, y_pos;
    private int y_pos_remember;
    private int xVelocity = 2;
    private int yVelocity = 1;
    private boolean repaint = false;
    private boolean isJump = false;
    private boolean stopJump = false;

    public Character(int width, int height, int x_pos, int y_pos) {
        this.width = width;
        this.height = height;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.y_pos_remember = y_pos;
    }

    @Override
    public void run() {

        while (true) {
            jump();
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void jump() {
        if(isJump && y_pos > y_pos_remember-30 && !stopJump) {
            y_pos -= yVelocity;
        }
        else if(isJump && y_pos == y_pos_remember-30 && !stopJump) {
            stopJump = true;
            y_pos += yVelocity;
        }

        if(stopJump && y_pos < y_pos_remember) {
            y_pos += yVelocity;
        }
        else if(stopJump && y_pos == y_pos_remember) {
            isJump = false;
            stopJump = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            if(x_pos > 0) {
                x_pos -= xVelocity;
                repaint = true;
            }
        }
        else if(e.getKeyChar() == 'd') {
            if(x_pos < width-20) {
                x_pos += xVelocity;
                repaint = true;
            }
        }
        else if(e.getKeyChar() == 'w' && y_pos == y_pos_remember) {
            isJump = true;
            repaint = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        repaint = false;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public boolean getRepaint() {
        return repaint;
    }
    public boolean getIsJump() {
        return isJump;
    }

    public void setHeight(int height) {
        this.height = height;
        this.y_pos = height-40;
        this.y_pos_remember = height-40;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
