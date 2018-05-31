package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class Pentagon extends SimpleShape{
	public Pentagon (Player o) {
		super(o);
		value = 5;
		cost = 50;
		img = myGame.getUI().readImage("pentagon.png");
	}
}
