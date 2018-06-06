package obstacles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import superclasses.FieldObject;
import superclasses.MovingObject;
import superclasses.Shape;

public class EnergyOrb extends MovingObject {

	private int value;
	
	public EnergyOrb(int x, int y, int direction, double speed, double radius, int value) {
		super(x, y, direction, speed, radius, 0);
		this.value = value;
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			((Shape) s).getOwner().gainEnergy(value);
		}
		return null;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("eorb.png");
		super.process();
	}
	
	public void draw() {
		super.draw();
		Graphics g = myGame.getUI().getG();
		g.setColor(Color.yellow);
		g.setFont(new Font("Helvetica", Font.PLAIN, 18)); 
		g.drawString("" + value,(int)(x+radius/4),(int)(y+radius/4));
	}
}