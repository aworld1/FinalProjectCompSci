package supershapes;

import handlers.Player;
import superclasses.GiantShape;

public class Haus extends GiantShape {

	public Haus(Player o) {
		super(o, 999999);
		speed = 2;
		radius = 30;
		imgName = "neuhaus.jpg";
	}
	
	public void process() {
		move();
		radius = 100;
		draw();
		radius = 30;
		rotation++;
	}
}
