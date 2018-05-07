package simpleshapes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import handlers.Player;
import superclasses.SimpleShape;

public class Triangle extends SimpleShape{
	public Triangle (Player o) {
		super(o);
		value = 3;
	}
	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("triangle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, 90+(rotation));
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius), null);
	}
}
