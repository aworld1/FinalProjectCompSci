package simpleshapes;

import java.awt.Color;
import java.awt.Graphics;

import handlers.Player;
import superclasses.SimpleShape;

public class Circle extends SimpleShape {
	public Circle(Player o) {
		super(o);
		value = 1;
	}
	public void draw() {
		// Draw shape on game
		Graphics g = myGame.getUI().getG();
		g.setColor(Color.red);
		g.drawOval((int)(x-(.5*radius)), (int)(y-(.5*radius)), (int)radius, (int)radius);
	}
	
}
