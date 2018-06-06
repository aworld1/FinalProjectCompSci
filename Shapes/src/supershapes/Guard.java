package supershapes;

import handlers.Player;
import superclasses.*;

public class Guard extends SuperShape {

	public Guard(Player o) {
		super(o);
		value = 0;
		speed = 3;
		cost = 80;
		direction = 270;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("guard.png");
		if (direction % 180 != 90)
			direction = 270;
		rotation = direction - 5;
		super.process();
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape && Math.random()<0.5)
			return s;
		if (s instanceof Shape)
			return this;
		return null;
	}
}
