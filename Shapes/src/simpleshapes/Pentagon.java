package simpleshapes;

import handlers.Player;
import superclasses.SimpleShape;

public class Pentagon extends SimpleShape{
	public Pentagon (Player o) {
		super(o);
		value = 5;
		imgName = "pentagon.png";
	}
}
