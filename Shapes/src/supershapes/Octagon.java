package supershapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import handlers.Player;
import superclasses.GiantShape;

public class Octagon extends GiantShape {

	public Octagon(Player o) {
		super(o, 8);
		speed = 2;
		cost = 80;
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		myGame.getUI().draw(img, (int)rotation, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.decode("#7F3F98"));
		g.setFont(new Font("Helvetica", Font.PLAIN, 18)); 
		g.drawString("" + giantLife,x-5,y+6);
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("octagon.png");
		super.process();
	}
}
