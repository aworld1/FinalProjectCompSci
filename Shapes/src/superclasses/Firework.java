package superclasses;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import handlers.Player;

public class Firework extends SuperShape {
	protected boolean movingBackwards;
	public Firework(Player o) {
		super(o);
		value = 0;
		speed = 8;
		radius = 30;
		imgName = "firework.png";
	}
	public void doBeforeDie() {
		if (!dead) {
			super.doBeforeDie();
			for (int i = 0; i < 5; i++) {
				addObj((direction - 90) + i*45);
			}
		}
	}
	
	public void process() {
		move();
		draw();
		reduceSpeed();
	}
	
	public void reduceSpeed() {
		if (speed <= 0 && !movingBackwards) {
			movingBackwards = true;
			direction = (direction + 180) % 360;
		}
		else if (!movingBackwards) {
			speed -= .03;
		}
		else {
			speed += .03;
		}
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			return this;
		}
		return null;
	}
	
	public void addObj(int d) {
		// Default creation is another firework
		Shape a = new Firework(owner);
		a.setXY(x,y);
		a.setDirection(d);
		myGame.addObj(a);
	}
	
	public void addObj(int d, Shape a) {
		a.setXY(x,y);
		a.setDirection(d);
		myGame.addObj(a);
	}
	

	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, direction);
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)radius*2, (int)(radius*2), null);
	}
}
