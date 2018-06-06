package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class Pentagon extends SimpleShape{
	public Pentagon (Player o) {
		super(o);
		value = 5;
		cost = 50;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("pentagon.png");
		super.process();
	}
}
