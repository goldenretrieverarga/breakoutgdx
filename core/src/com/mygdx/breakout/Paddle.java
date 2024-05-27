package com.mygdx.breakout;

import com.badlogic.gdx.math.Rectangle;

public class Paddle {
    int position;
    int y;
    int width;
    int thickness;

    public Paddle(int position)
    {
        this.position = position;
        this.y = 20;
        this.width = 80;
        this.thickness = 30;

    }

    public Rectangle getRect()
    {
        return new Rectangle(this.position,this.y,this.width,this.thickness);
    }
}
