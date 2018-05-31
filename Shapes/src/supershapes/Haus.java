package supershapes;

import handlers.Player;
import superclasses.GiantShape;

public class Haus extends GiantShape {

	public Haus(Player o) {
		super(o, 999999);
		speed = 2;
		radius = 0;
		img = myGame.getUI().readImage("neuhaus.jpg");
	}
	
	public void process() {
		move();
		draw();
		radius++;
		rotation++;
	}
}
