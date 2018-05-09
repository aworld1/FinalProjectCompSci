package handlers;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import superclasses.*;

public class Target extends MovingObject {
	public Target(int x, int y, int d) {
		this.x = x;
		this.y = y;
		direction = d;
		speed = 7;
		radius = 10;
		imgName = "circle.png";
	}
	
	public void process() {
		move();
		draw();
		dropShadow();
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, 90+(rotation));
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius), null);
	}
}