package supershapes;

import handlers.Player;
import simpleshapes.*;
import superclasses.*;

public class Circlinator extends SuperShape {

	public Circlinator(Player o) {
		super(o);
		value = 0;
		speed = 5;
		cost = 50;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("circlinator.png");
		super.process();
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape && !(s instanceof Mirror)) {
			Shape sh = ((Shape) s);
			Shape x = new Circle(sh.getOwner());
			x.setXY(sh.getX(), sh.getY());
			x.setDirection(sh.getDirection());
			myGame.addObj(x);
		}
		return null;
	}
}