package org.example.Lab4;

import org.example.Threads.Ball;
import org.example.Threads.Bullet;
import org.example.Threads.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private Image guy = new ImageIcon("src/main/resources/Images/stickman3.png").getImage();
    private Graphics2D buffer;
    private Timer timer;
    private int width;
    private int height;
    private int x_pos = 200;        //character position
    private int y_pos = 511;        //character position
    private int current_height = 551;
    private Character character;
    private boolean repaint = false;
    private boolean isJump = false;
    private boolean start = false;
    private Bullet bullet;
    private double way_x;       //bullet way
    private double way_y;       //bullet way
    private boolean shoot = false;
    private Ball ball;
    private double ball_position_x, ball_position_y;
    private boolean ball_is_active = false;
    private boolean gameOver = false;
    private int score;
    private JTextField t_points, t_time;
    int minutes=0, seconds=0;
    int elapsedTime;
    String minutes_string, seconds_string;

    public GamePanel() {
        setFocusable(true);
        timer = new Timer(10,this);
        timer.start();

        addCharacter();
        addBullet();
        addBall();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        buffer = (Graphics2D) g;
        width = getWidth();
        height = getHeight();

        if(sizeIsChanged(height)) {
            buffer.drawImage(guy, x_pos, height - 40, 20, 35, null);

            character.setWidth(width);
            character.setHeight(height);
            bullet.setWidth(width);
            bullet.setHeight(height);
            ball.setWidth(width);
            ball.setHeight(height);
        }
        else
            buffer.drawImage(guy, x_pos, y_pos,20,35,null);

        if(shoot) {
            buffer.fillOval((int)way_x, (int)way_y, 10, 10);
        }

        if(ball_is_active) {
            buffer.fillOval((int)ball_position_x, (int)ball_position_y, 40, 40);
        }
    }

    public boolean sizeIsChanged(int height) {
        if(current_height != height) {
            current_height = height;
            return true;
        }
        else
            return false;
    }

    public void addCharacter() {
        character = new Character(506, 551, x_pos, y_pos);
        addKeyListener(character);

        if(!start) {
            new Thread(character).start();
            start = true;
        }
    }

    public void addBullet() {
        bullet = new Bullet(x_pos+20, y_pos, 506, 551);
        addMouseListener(bullet);

        new Thread(bullet).start();
    }

    public void addBall() {
        ball = new Ball(506, 551, way_x, way_y);

        new Thread(ball).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x_pos = character.getX_pos();
        y_pos = character.getY_pos();

        repaint = character.getRepaint();
        isJump = character.getIsJump();

        if(repaint || isJump) {
            repaint();
        }

        //----------------------------

        way_x = bullet.getWay_x();
        way_y = bullet.getWay_y();
        bullet.setX_start(x_pos + 20);
        bullet.setY_start(y_pos);

        bullet.setBallIsActive(ball_is_active);

        shoot = bullet.getShoot();

        if(shoot)
            repaint();

        //----------------------------

        ball_position_x = ball.getBall_position_x();
        ball_position_y = ball.getBall_position_y();
        ball_is_active = ball.getBallIsActive();
        gameOver = ball.getGameOver();
        score = ball.getScore();

        ball.setBullet_point_x(way_x);
        ball.setBullet_point_y(way_y);
        ball.setCharacter_point_x(x_pos);
        ball.setCharacter_point_y(y_pos);

        if(ball_is_active)
            repaint();

        //----------------------------

        t_points.setText(String.valueOf(score));

        //----------------------------

        elapsedTime += 10;
        minutes = (elapsedTime/60000)%60;
        seconds = (elapsedTime/1000)%60;

        minutes_string = String.format("%02d", minutes);
        seconds_string = String.format("%02d", seconds);

        t_time.setText(minutes_string + ":" + seconds_string);

        //----------------------------

        if(gameOver) {
            gameOver = false;
            elapsedTime = 0;
            minutes = 0;
            seconds = 0;
            ball.setGameOver(false);
        }
    }

    public void setT_points(JTextField t_points) {
        this.t_points = t_points;
    }

    public void setT_time(JTextField t_time) {
        this.t_time = t_time;
    }
}

