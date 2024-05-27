package com.mygdx.breakout;

import com.badlogic.gdx.math.Rectangle;

public class BrickField {
    int width;
    int height;
    int physicalWidth;
    int physicalHeight;
    int x;
    int y;
    static int brickSize=20;
    static int brickWidth = 4;
    Brick[][] bricks;

    public BrickField(int x, int y,int width,int height)
    {

        this.x = x;
        this.y =y;
        this.physicalWidth = width;
        this.physicalHeight = height;

        this.width = width / brickSize /brickWidth;
        this.height = height / brickSize;
        bricks = new Brick[this.height][this.width];
        for(int i=0;i<this.height;i++)
        {
            for(int j=0;j<this.width;j++)
            {
                bricks[i][j] = new Brick();
            }
        }

    }

    Rectangle getRect()
    {
        return new Rectangle(this.x,this.y-physicalHeight,physicalWidth,physicalHeight);
    }

    int getBrickW()
    {
        return brickSize * brickWidth;
    }

    int getBrickH()
    {
        return brickSize;
    }
/* 
    int getIndex(int x, int y)
    {
        int ix = x / brickWidth;
        int iy = y;
        return 0;
    }

*/
    public boolean pop(int x, int y)
    {
        System.out.printf("");

        int ix = Math.min(width-1,x / getBrickW());
        int iy = Math.min(height-1, (this.y -y) / getBrickH());
        if(bricks[iy][ix].popped == false)
        {
            bricks[iy][ix].popped = true;
            return true;
        }
        else
        {
            return false;
        }
        //System.out.println("popped set");
        //System.out.printf("x = %d y = %d\n", ix, iy);
        
        

    }
    }

    








