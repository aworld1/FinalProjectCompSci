package superclasses;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.Dimensions;
import handlers.Player;

public class Flector extends FieldObject {

	protected int value;
	protected int x;
	protected int y;
	protected int direction;
	protected double speed;
	protected double radius;
	protected double rotation;
	// protected double rotationSpeed;

	public Flector(int x, int y, int direction, double speed, double rotation) {// better fix this in the super
		setX(x);
		radius = 10;
		setY(y);
		setDirection(direction);
		setSpeed(speed);
		setRotation(rotation);
	}

	public void process() {
		move();
		draw();
	}

	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			System.out.println("XD MEMES");
			((Shape) s).setDirection((int) 0);
		}
		return null;
	}

	public boolean colliding(FieldObject s) {
		if (s instanceof Shape) {
			System.out.println("g00d m3m3s");
			double space = this.radius + ((Shape) s).getRadius();
			double distance = Math.sqrt(Math.pow(x - ((Shape) s).getX(), 2) + Math.pow(y - ((Shape) s).getY(), 2));
			return distance <= space;
		}
		System.out.println("m3m3s r dr3am$");
		return false;
	}

	public void move() {
		if (y <= Dimensions.getY() + radius || y >= Dimensions.getY() + Dimensions.getHeight() - radius) {
			direction += (2 * (180 - direction)) % 360;
		}
		x += Math.round(Math.cos(Math.toRadians(direction)) * speed);
		y += Math.round(Math.sin(Math.toRadians(direction)) * speed);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("triangle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, 90 + (rotation));
		g.drawImage(img, (int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius), null);
	}

}
