package obstacles;

import superclasses.FieldObject;
import superclasses.MovingObject;
import superclasses.Shape;

public class Flector extends MovingObject {
	protected double effectDirection;
	protected double turnSpeed;
	public Flector(int x, int y, int direction, int speed, double effectDirection, double turnSpeed) {
		this.direction = direction;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.effectDirection = effectDirection;
		this.turnSpeed = turnSpeed;
		img = myGame.getUI().readImage("flector.png");
		radius = 20;
	}

	public void process() {
		move();
		effectDirection += turnSpeed;
		draw();
	}

	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			((Shape) s).setDirection((int) effectDirection);
		}
		return null;
	}

	public boolean colliding(FieldObject s) {
		if (s instanceof Shape) {
			double space = this.radius + ((Shape) s).getRadius();
			double distance = Math.sqrt(Math.pow(x - ((Shape) s).getX(), 2) + Math.pow(y - ((Shape) s).getY(), 2));
			return distance <= space;
		}
		return false;
	}

	public void draw() {
		myGame.getUI().draw(img, (int)effectDirection, (int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
	}
}