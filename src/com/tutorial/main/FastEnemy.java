package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{

	private Handler handler;
	
	public FastEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		volX = 2;
		volY = 9;
	}

	public void tick() {
		x += volX;
		y += volY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) volY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) volX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
}
