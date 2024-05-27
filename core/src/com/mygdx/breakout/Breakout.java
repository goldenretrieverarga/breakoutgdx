package com.mygdx.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.ScreenUtils;

public class Breakout extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BrickField field;
	ShapeRenderer renderer;
	Paddle paddle;
	Ball ball;
	int width;
	int height;
	
	@Override
	public void create () {
		width = 800;
		height = 600;
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		field = new BrickField(0,600,800,300);
		renderer = new ShapeRenderer();
		paddle = new Paddle(400);
		ball = new Ball(400,150);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0f, 0, 0.8f, 1);
		batch.begin();
		batch.end();
		ball.update(Gdx.graphics.getDeltaTime());
		Circle ballCircle = ball.getCircle();
		if(Intersector.overlaps(ballCircle,field.getRect()))
		{
			//ball.vy = -ball.vy;
			if(field.pop(ball.x,ball.y))
			{
				ball.vy = -ball.vy;
			}
		}
		if(Intersector.overlaps(ballCircle,paddle.getRect()))
		{
			ball.vy = -ball.vy;
		}


		if(ball.x < 0 || ball.x > width-1)
		{
			ball.vx = - ball.vx;
		}

		if(ball.y < 0 || ball.y > height -1)
		{
			ball = new Ball(400,150);
		}




		renderer.begin(ShapeType.Filled);

		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			paddle.position -= 300 * Gdx.graphics.getDeltaTime();
		}

		if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			paddle.position += 300 * Gdx.graphics.getDeltaTime();
		}

		if(Gdx.input.isKeyPressed(Keys.SPACE))
		{
			ball.moving = true;
		}


		for(int i=0;i<field.height;i++)
		{
			int brickw = field.getBrickW();
			int brickh = field.getBrickH();
			for(int j=0;j<field.width;j++)
			{
				Brick brick = field.bricks[i][j];
				if(!brick.popped)
				{
				renderer.setColor(Color.WHITE);
				renderer.rect(j*brickw,field.y - i*brickh,brickw,brickh);

				renderer.setColor(brick.color);
				renderer.rect(j*brickw+2,field.y - (i*brickh +2),brickw-4,brickh-4);
				}
				else
				{
					System.out.println("Block skipped");
					System.out.printf("x = %d y = %d\n",j,i);
				}
				


				
			}
			renderer.setColor(Color.RED);

			renderer.rect(paddle.position,paddle.y,paddle.width,paddle.thickness);

			renderer.setColor(ball.color);

			renderer.circle(ball.x,ball.y,ball.size);
		}

		renderer.end();

		

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
