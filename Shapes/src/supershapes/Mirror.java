package supershapes;

import handlers.Player;
import superclasses.*;

public class Mirror extends SuperShape {

	public Mirror(Player o) {
		super(o);
		value = 0;
		speed = 5;
		cost = 150;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("mirror.png");
		rotation = direction;
		super.process();
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof SimpleShape && !(s instanceof Mirror)) {
			Shape x = ((Shape) s).clone();
			x.setDirection(direction);
			myGame.addObj(x);
		}
		else if (s instanceof SuperShape && !(s instanceof Mirror)) {
			((Shape) s).setDirection(direction);
		}
		return null;
	}
}
