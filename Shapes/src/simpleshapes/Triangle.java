package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class Triangle extends SimpleShape{
	public Triangle (Player o) {
		super(o);
		value = 3;
		cost = 30;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("triangle.png");
		super.process();
	}
}
