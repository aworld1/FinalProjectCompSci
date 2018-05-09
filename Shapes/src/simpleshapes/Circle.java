package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class Circle extends SimpleShape {
	public Circle(Player o) {
		super(o);
		value = 1;
		imgName = "circle.png";
	}
}
