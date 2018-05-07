package supershapes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import handlers.Player;
import simpleshapes.Triangle;
import superclasses.Shape;

public class TriangleFirework extends Firework {

	public TriangleFirework(Player o) {
		super(o);
	}
	
	public void addObj(int d) {
		Shape a = new Triangle(owner);
		super.addObj(d,a);
	}
	
	public void draw() {
		// Draw shape on game
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("firework.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, direction+90);
		g.drawImage(img, (int)(x-1.5*radius), (int)(y-0.75*radius), (int)radius*3, (int)(radius*1.5), null);
	}

}
