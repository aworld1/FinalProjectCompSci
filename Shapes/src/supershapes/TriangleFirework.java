package supershapes;

import handlers.Player;
import simpleshapes.Triangle;
import superclasses.Firework;
import superclasses.Shape;

public class TriangleFirework extends Firework {

	public TriangleFirework(Player o) {
		super(o);
		cost = 140;
	}
	
	public void addObj(int d) {
		Shape a = new Triangle(owner);
		super.addObj(d,a);
	}

}
