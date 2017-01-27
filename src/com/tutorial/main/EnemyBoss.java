package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	private Random r = new Random();
	private int timer = 80;
	private int timer2 = 50;
	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		volX = 0;
		volY = 2;
	}

	public void tick() {
		x += volX;
		y += volY;
		
		if(timer <= 0){
			volY = 0;
		}else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0){
			if(volX == 0) volX = 2;
			
			if(volX > 0) volX += 0.05f;
			else if(volX < 0) volX -= 0.05f;
			volX = Game.clamp(volX, -10, 10);
			
			volX += 0.01f;
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
		}
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) volY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 96) volX *= -1;
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.009f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 96, 96);
	}
}
