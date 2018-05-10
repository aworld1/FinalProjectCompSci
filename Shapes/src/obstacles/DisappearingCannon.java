package obstacles;

import superclasses.FieldObject;
import superclasses.Shape;

public class DisappearingCannon extends Cannon{
	
	
	public DisappearingCannon(int x, int y, int direction, int speed, int turnSpeed, int fireCooldown) {
		super(x, y, direction, speed, turnSpeed, fireCooldown);
		imgName = "cannon2.png";
	}

	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			return this;
		}
		return null;
	}
}
