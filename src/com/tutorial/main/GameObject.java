package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float volX, volY;
	
	public GameObject(float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return this.id;
	}
	public void setVolX(float volX){
		this.volX = volX;
	}
	public void setVolY(float volY){
		this.volY = volY;
	}
	public float getVolX(){
		return this.volX;
	}
	public float getVolY(){
		return this.volY;
	}
}
