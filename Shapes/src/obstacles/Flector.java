package obstacles;

import superclasses.FieldObject;
import superclasses.MovingObject;
import superclasses.Shape;

public class Flector extends MovingObject {
	protected double effectDirection;
	protected double turnSpeed;
	
	public Flector(int x, int y, int direction, int speed, double effectDirection, double turnSpeed) {
		super(x, y, direction, speed, 20, 0);
		this.effectDirection = effectDirection;
		this.turnSpeed = turnSpeed;
	}

	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("flector.png");
		super.process();
		effectDirection += turnSpeed;
	}

	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			((Shape) s).setDirection((int) effectDirection);
		}
		return null;
	}

	public void draw() {
		myGame.getUI().draw(img, (int)effectDirection, (int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
	}
}