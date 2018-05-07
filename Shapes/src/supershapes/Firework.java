package supershapes;

import handlers.Player;
import superclasses.FieldObject;
import superclasses.Shape;
import superclasses.SuperShape;

public class Firework extends SuperShape {
	public Firework(Player o) {
		super(o);
		value = 0;
		speed = 8;
		radius = 30;
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
		speed -= .03;
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		return this;
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
}
