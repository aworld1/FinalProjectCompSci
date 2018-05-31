package obstacles;

import superclasses.FieldObject;
import superclasses.MovingObject;
import superclasses.Shape;

public class EnergyOrb extends MovingObject {

	private int value;
	
	public EnergyOrb(int x, int y, int direction, double speed, double radius, int value) {
		super(x, y, direction, speed, radius, 0);
		this.value = value;
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			((Shape) s).getOwner().gainEnergy(value);
		}
		return null;
	}
}
