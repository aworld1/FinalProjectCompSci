package obstacles;

import superclasses.FieldObject;
import superclasses.MovingObject;
import superclasses.Shape;

public class HealthOrb extends MovingObject{
	
	private int value;
	
	public HealthOrb(int x, int y, int direction, double speed, double radius, int value) {
		super(x, y, direction, speed, radius, 0);
		this.value = value;
	}

	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			((Shape) s).getOwner().gainHealth(value);
		}
		return null;
	}
	
}
