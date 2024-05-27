package com.mygdx.breakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;

public class Ball {
    int x;
    int y;
    int size;
    Color color;
    int speed;
    float vx;
    float vy;
    boolean moving;

    public Ball(int x, int y)
    {
        this.x = x;
        this.y =y;
        this.size = 20;
        this.color = Color.GRAY;
        this.speed = 200;
        this.moving = false;
        this.vx = 1;
        this.vy = 1;

    }

    public void update(float time)
    {
        if(moving)
        {
        this.x += this.speed * this.vx * time;
        this.y += this.speed * this.vy * time;
        }

    }


    public Circle getCircle()
    {
        return new Circle(x,y,size);
    }

}
