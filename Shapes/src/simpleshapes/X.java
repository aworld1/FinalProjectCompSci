package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class X extends SimpleShape{
	public X (Player o) {
		super(o);
		value = 2;
		cost = 20;
		imgName = "x.png";
	}
}
