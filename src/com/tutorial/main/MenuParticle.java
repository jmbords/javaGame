package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

	private Handler handler;
	Random r = new Random();

	private Color color;
	public MenuParticle(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		volX = (r.nextInt(7 - -7) + -7);
		volY = (r.nextInt(7 - -7) + -7);
		if(volX == 0) volX = 1;
		if(volY == 0) volY = 1;
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void tick() {
		x += volX;
		y += volY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) volY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) volX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
}
