package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		volX = (r.nextInt(5 - -5) + -5);
		volY = 5;
	}

	public void tick() {
		x += volX;
		y += volY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) volY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) volX *= -1;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
}
