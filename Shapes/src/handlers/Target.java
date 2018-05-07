package handlers;
import java.awt.Color;
import java.awt.Graphics;

import graphics.Dimensions;
import superclasses.FieldObject;

public class Target extends FieldObject {
	private int x;
	private int y;
	private int direction;
	private int speed;
	private int radius;
	public Target(int x, int y, int d) {
		this.x = x;
		this.y = y;
		direction = d;
		speed = 7;
		radius = 20;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void move() {
		if (y <= Dimensions.getY() + radius || y >= Dimensions.getY() + Dimensions.getHeight() - radius) {
			changeDirection();
		}
		x += Math.cos(Math.toRadians(direction)) * speed;
		y += Math.sin(Math.toRadians(direction)) * speed;
	}
	public void process() {
		move();
		draw();
	}
	public void changeDirection() {
		direction = (direction + 180) % 360;
	}
	public void draw() {
		Graphics g = myGame.getUI().getG();
		g.setColor(Color.white);
		g.drawOval((int)(x-(.5*radius)), (int)(y-(.5*radius)), (int)radius, (int)radius);
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
}