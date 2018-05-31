package supershapes;
import handlers.Player;
import simpleshapes.Circle;
import superclasses.Firework;
import superclasses.Shape;

public class CircleFirework extends Firework {

	public CircleFirework(Player o) {
		super(o);
		cost = 40;
	}
	
	public void addObj(int d) {
		Shape a = new Circle(owner);
		super.addObj(d,a);
	}

}
