package supershapes;

import handlers.Player;
import superclasses.*;

public class Missile extends SuperShape {

	public Missile(Player o) {
		super(o);
		img = myGame.getUI().readImage("missile.png");
		speed = 4;
		cost = 100;
		radius = 25;
		value = 0;
	}
	
	public void process() {
		direction = (int) getNextDir();
		rotation = direction;
		move();
		draw();
	}
	
	public double getNextDir() {
		Shape x = getNearestShape();
		if (x != null)
			return getDirToShape(x);
		return direction;
	}
	
	public double getDistanceFromShapes(Shape a, Shape b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}
	
	public Shape getNearestShape() {
		FieldObject cur;
		Shape near = null;
		double n = -100;
		for (int i = 0; i < myGame.getObjs().size(); i++) {
			cur = myGame.getObjs().get(i);
			if (cur instanceof Shape) {
				if (!cur.equals(this) && !((Shape) cur).getOwner().equals(owner) && (n == -100 || getDistanceFromShapes(this,(Shape)cur) < n)) {
					near = (Shape)cur;
					n = getDistanceFromShapes(this,(Shape)cur);
				}
			}
		}
		return near;
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof SimpleShape)
			return s;
		return this;
	}
}
