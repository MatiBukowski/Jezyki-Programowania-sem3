package org.example.Threads;

import com.sun.source.tree.BreakTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bullet implements Runnable, MouseListener {
    private int x_start, y_start, x_direction, y_direction;         //starty to prawy górny róg postaci
    private boolean shoot = false;
    private double final_point_x;
    private double final_point_y;
    private double way_x;
    private double way_y;
    private int width;
    private int height;
    private double a, b;
    private double a_rightUpCorner, b_rightUpCorner;
    private boolean ball_is_active;     //when we haven't shot ball yet

    public Bullet(int x_start, int y_start, int width, int height) {
        this.x_start = x_start;
        this.y_start = y_start;
        this.width = width;
        this.height = height;

        this.way_x = x_start;
        this.way_y = y_start;
    }

    public void linearFunction(int x_start, int y_start, int x_direction, int y_direction) {
        right_up_corner();

        if(x_direction - x_start != 0) {        //mianownik nie równy 0
            a = (y_direction - y_start) / (x_direction - (double)x_start);
            b = y_direction - a*x_direction;

            if(a == 0 && x_direction < x_start) {       //licznik równy 0 - linai pozioma
                final_point_x = 0;
                final_point_y = b;
            }
            else if(a == 0 && x_direction > x_start) {  //licznik równy 0 - linai pozioma
                final_point_x = width;
                final_point_y = b;
            }
            else if(a > 0 && b < 0) {
                if(x_direction < x_start && y_direction < y_start) {        //nad graczem
                    final_point_x = -b/a;
                    final_point_y = -5;         //bo jest lekkie przesunięcie
                }
                else if(x_direction > x_start && y_direction > y_start) {   //pod graczem
                    final_point_y = height;
                    if((final_point_y-b)/a < width)
                        final_point_x = (final_point_y-b)/a;
                    else
                        final_point_x = width;
                }
            }
            else if(a > 0 && b > 0) {
                if(x_direction < x_start && y_direction < y_start) {        //nad graczem
                    final_point_x = 0;
                    final_point_y = b;
                }
                else if(x_direction > x_start && y_direction > y_start) {   //pod graczem
                    final_point_y = height;
                    if((final_point_y-b)/a < width)
                        final_point_x = (final_point_y-b)/a;
                    else
                        final_point_x = width;
                }
            }
            else if(a < 0 && b > 0) {
                if(x_direction > x_start && y_direction < y_start) {        //nad graczem
                    if(a < a_rightUpCorner && b > b_rightUpCorner) {
                        final_point_x = -b/a;
                        final_point_y = -5;     //bo jest lekkie przesunięcie
                    }
                    else {
                        final_point_x = width;
                        final_point_y = a * final_point_x + b;
                    }
                }
                else if(x_direction < x_start && y_direction > y_start) {   //pod graczem
                    final_point_y = height;
                    if((final_point_y-b)/a > 0)
                        final_point_x = (final_point_y-b)/a;
                    else
                        final_point_x = 0;
                }
            }
        }
        else {                                  //mianownik równy zero - pionowa linia
            if(y_direction < y_start) {
                final_point_x = x_direction;
                final_point_y = 0;
            }
            else if(y_direction > y_start) {
                final_point_x = x_direction;
                final_point_y = height;
            }
        }
    }

    public void bulletWay() {
        if(way_x < final_point_x)
            way_x ++;
        else if(way_x > final_point_x)
            way_x --;

        way_y = a*way_x + b;

        if((int)way_x == (int)final_point_x) {
            shoot = false;
            way_x = x_start;
            way_y = y_start;
        }

        if(ball_is_active == false) {
            shoot = false;
            way_x = x_start;
            way_y = y_start;
        }
    }

    public void right_up_corner() {
        a_rightUpCorner = (0 - y_start) / (width - (double)x_start);
        b_rightUpCorner = 0.0 - a_rightUpCorner*width;
    }

    @Override
    public void run() {

        while (true) {
            if(shoot)
                bulletWay();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!shoot) {
            shoot = true;

            x_direction = e.getX();
            y_direction = e.getY();

            linearFunction(x_start, y_start, x_direction, y_direction);
        }
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

    public double getWay_x() {
        return way_x;
    }

    public double getWay_y() {
        return way_y;
    }

    public boolean getShoot() {
        return shoot;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX_start(int x_start) {
        this.x_start = x_start;
    }

    public void setY_start(int y_start) {
        this.y_start = y_start;
    }
    public void setBallIsActive(boolean ball_is_active) {
        this.ball_is_active = ball_is_active;
    }

}
