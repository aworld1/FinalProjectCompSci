package superclasses;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.Dimensions;
import graphics.Shadow;

public class MovingObject extends FieldObject {
	protected int x;
	protected int y;
	protected int direction;
	protected double speed;
	protected double radius;
	protected String imgName;
	protected double rotation;
	
	public MovingObject() {
		super();
	}
	
	public void dropShadow() {
		myGame.addObj(new Shadow(imgName, this, rotation));
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
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
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void move() {
		direction = (direction + 360) % 360;
		if ((y <= Dimensions.getY() + radius && direction >= 180) || (y >= Dimensions.getY() + Dimensions.getHeight() - radius && direction <= 180)) {
			direction += (2 * (180 - direction)) % 360;
		}
		x += (int)(Math.cos(Math.toRadians(direction)) * speed);
		y += (int)(Math.sin(Math.toRadians(direction)) * speed);
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, rotation);
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius), null);
	}
}