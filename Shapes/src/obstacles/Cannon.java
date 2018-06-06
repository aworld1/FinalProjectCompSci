package obstacles;
import superclasses.*;

public class Cannon extends MovingObject {
	protected int fireCooldown;
	protected int fireFrame;
	protected int turnSpeed;
	protected int effectDirection;
	
	public Cannon(int x, int y, int direction, int speed, int edirection, int turnSpeed, int fireCooldown) {
		super(x, y, direction, speed, 40, direction);
		this.effectDirection = edirection;
		this.turnSpeed = turnSpeed;
		this.fireCooldown = fireCooldown;
		fireFrame = 0;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("cannon.png");
		super.process();
		checkFire();
		effectDirection += turnSpeed;
		rotation = effectDirection;
	}
	
	public void checkFire() {
		if (fireFrame >= fireCooldown) {
			fireFrame = 0;
			fire();
			return;
		}
		fireFrame++;
	}
	
	public void fire() {
		SimpleShape a = myGame.getRandomSimpleShape();
		SimpleShape b = myGame.getRandomSimpleShape();
		a.setXY((int)(Math.cos(Math.toRadians(effectDirection)) * (radius + a.getRadius()) + x + 1),
				(int)(Math.sin(Math.toRadians(effectDirection)) * (radius + a.getRadius()) + y + 1));
		a.setDirection(effectDirection);
		myGame.addObj(a);
		b.setXY((int)(Math.cos(Math.toRadians(effectDirection)) * (radius + b.getRadius()) * -1 + x - 1),
				(int)(Math.sin(Math.toRadians(effectDirection)) * (radius + b.getRadius()) * -1 + y - 1));
		b.setDirection(effectDirection + 180);
		myGame.addObj(b);
	}
}