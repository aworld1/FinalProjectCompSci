package supershapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import handlers.Player;
import superclasses.GiantShape;

public class Dodecagon extends GiantShape {

	public Dodecagon(Player o) {
		super(o, 12);
		speed = 1.5;
		cost = 120;
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		myGame.getUI().draw(img, (int)rotation, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.decode("#2E3192"));
		g.setFont(new Font("Helvetica", Font.PLAIN, 20));
		if (giantLife >= 10) {
			g.drawString("+",x-6,y+7);
		}
		else {
			g.drawString("" + giantLife,x-5,y+7);
		}
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("dodecagon.png");
		super.process();
	}
}
