package com.mygdx.breakout;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
 
public class Brick {
    boolean popped;
    Color color;
    static Color[] colors = { Color.BROWN,Color.YELLOW,Color.DARK_GRAY};
    public Brick()    
    {
        Random random = new Random();
        popped = false;
        this.color = new Color(colors[random.nextInt(colors.length)]);
        
    }

}
