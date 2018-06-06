package obstacles;

import superclasses.*;
public class DisappearingFlector extends Flector {

	public DisappearingFlector(int x, int y, int direction, int speed, double effectDirection, double turnSpeed) {
		super(x, y, direction, speed, effectDirection, turnSpeed);
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			((Shape) s).setDirection((int) effectDirection);
			return this;
		}
		return null;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("flector2.png");
		super.process();
	}
}
