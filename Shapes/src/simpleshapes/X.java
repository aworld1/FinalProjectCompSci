package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class X extends SimpleShape{
	public X (Player o) {
		super(o);
		value = 2;
		cost = 20;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("x.png");
		super.process();
	}
}
