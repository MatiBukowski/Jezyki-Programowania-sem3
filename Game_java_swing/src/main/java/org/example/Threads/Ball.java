package org.example.Threads;

import java.util.Random;

public class Ball implements Runnable {
    private double ball_position_x;
    private double ball_position_y;
    private double ball_destination_x;
    private double ball_destination_y;
    private int width;
    private int height;
    private boolean ball_is_active = false;
    private boolean ball_have_destination = false;
    private int choice;
    private double a,b;
    private double bullet_point_x, bullet_point_y;
    private int score = 0;
    private double character_point_x, character_point_y;
    private boolean gameOver = false;

    public Ball(int width, int height, double bullet_point_x, double bullet_point_y) {
        this.width = width;
        this.height = height;
        this.bullet_point_x = bullet_point_x;
        this.bullet_point_y = bullet_point_y;
    }

    @Override
    public void run() {
        while (true) {
            establishBallPosition();
            collision_with_bullet();
            collision_with_character();
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void startBallPosition(Random random) {
        ball_position_x = random.nextInt(width + 1);
        ball_position_y = random.nextInt(height-100)+20;
        ball_is_active = true;
    }

    public void establishBallPosition() {
        Random random = new Random();

        if(!ball_is_active) {
            startBallPosition(random);
        }

        if(ball_is_active && !ball_have_destination) {
            choice = random.nextInt(4);     //0 - up, 1 - down, 2 - right, 3 - left
            ball_have_destination = true;

            if(choice == 0) {
                ball_destination_x = random.nextInt(width+1);
                ball_destination_y = 0;
            }
            else if(choice == 1) {
                ball_destination_x = random.nextInt(width+1);
                ball_destination_y = height-40;
            }
            else if(choice == 2) {
                ball_destination_x = width-40;
                ball_destination_y = random.nextInt(height-39);     //żeby nie schodziło pod plansze
            }
            else if(choice == 3) {
                ball_destination_x = 0;
                ball_destination_y = random.nextInt(height-39);     //żeby nie schodziło pod plansze
            }

            a = (ball_destination_y - ball_position_y)/(ball_destination_x - ball_position_x);
            b = ball_destination_y - a*ball_destination_x;
        }

        if(ball_is_active && ball_have_destination) {
            changeBallPosition();
        }
    }

    public void changeBallPosition() {
        if(ball_position_x < ball_destination_x) {
            ball_position_x ++;
            ball_position_y = a*ball_position_x + b;
        }
        else if(ball_position_x > ball_destination_x) {
            ball_position_x --;
            ball_position_y = a*ball_position_x + b;
        }

        if(ball_position_x == ball_destination_x) {
            ball_have_destination = false;
        }
    }

    public void collision_with_bullet() {
        if(bullet_point_x+5 >= ball_position_x && bullet_point_x <= ball_position_x+40) {
            if(bullet_point_y >= ball_position_y && bullet_point_y <= ball_position_y+40) {
                ball_is_active = false;
                ball_have_destination = false;
                score++;
            }
        }
        else if(bullet_point_y >= ball_position_y && bullet_point_y <= ball_position_y+40) {
            if(bullet_point_x+10 >= ball_position_x && bullet_point_x <= ball_position_x+40) {
                ball_is_active = false;
                ball_have_destination = false;
                score++;
            }
        }
    }

    public void collision_with_character() {
        if(character_point_y >= ball_position_y && character_point_y <= ball_position_y+40) {
            if(character_point_x >= ball_position_x && character_point_x <= ball_position_x+40) {
                ball_is_active = false;
                ball_have_destination = false;
                score = 0;
                gameOver = true;
            }
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getBallIsActive() {
        return ball_is_active;
    }

    public double getBall_position_x() {
        return ball_position_x;
    }

    public double getBall_position_y() {
        return ball_position_y;
    }

    public void setBullet_point_x(double bullet_point_x) {
        this.bullet_point_x = bullet_point_x;
    }

    public void setBullet_point_y(double bullet_point_y) {
        this.bullet_point_y = bullet_point_y;
    }
    public int getScore() {
        return score;
    }

    public void setCharacter_point_x(int character_point_x) {
        this.character_point_x = (double)character_point_x;
    }

    public void setCharacter_point_y(int character_point_y) {
        this.character_point_y = (double)character_point_y;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

}
