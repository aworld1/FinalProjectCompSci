package graphics;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import superclasses.*;

public class Shadow extends FieldObject{
	private BufferedImage img;
	private int x;
	private int y;
	private double radius;
	private double opacity;
	public Shadow(BufferedImage img, MovingObject s, double r) {
		x = s.getX();
		y = s.getY();
		radius = s.getRadius();
		myGame = s.getGame();
		this.img = myGame.getUI().rotate(img, r);
		opacity = 0.5;
	}
	
	public void process() {
		draw();
		opacity -= 0.1;
		if (opacity <= 0.05) {
			removeSelf();
		}
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		((Graphics2D) g).setComposite(AlphaComposite.SrcOver.derive((float) opacity));
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius), null);
		((Graphics2D) g).setComposite(AlphaComposite.SrcOver);
	}
	
	public void doBeforeDie() {
		// Do nothing
	}
}
