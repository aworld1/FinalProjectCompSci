package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class Triangle extends SimpleShape{
	public Triangle (Player o) {
		super(o);
		value = 3;
		imgName = "triangle.png";
	}
}
