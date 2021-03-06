package obstacles;

import superclasses.FieldObject;
import superclasses.Shape;

public class DisappearingCannon extends Cannon{
	
	
	public DisappearingCannon(int x, int y, int direction, int speed, int edirection, int turnSpeed, int fireCooldown) {
		super(x, y, direction, speed, edirection, turnSpeed, fireCooldown);
	}

	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			return this;
		}
		return null;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("cannon2.png");
		super.process();
	}
}
