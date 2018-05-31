package supershapes;
import handlers.Player;
import simpleshapes.X;
import superclasses.Firework;
import superclasses.Shape;

public class XFirework extends Firework {

	public XFirework(Player o) {
		super(o);
		cost = 90;
	}
	
	public void addObj(int d) {
		Shape a = new X(owner);
		super.addObj(d,a);
	}

}
