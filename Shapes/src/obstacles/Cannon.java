package obstacles;
import superclasses.*;

public class Cannon extends MovingObject {
	protected int fireCooldown;
	protected int fireFrame;
	protected int turnSpeed;
	public Cannon(int x, int y, int direction, int speed, int turnSpeed, int fireCooldown) {
		this.direction = direction;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.turnSpeed = turnSpeed;
		this.fireCooldown = fireCooldown;
		imgName = "cannon.png";
		radius = 40;
		fireFrame = 0;
		rotation = direction;
	}
	
	public void process() {
		move();
		checkFire();
		draw();
		direction += turnSpeed;
		rotation = direction;
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
		a.setXY((int)(Math.cos(Math.toRadians(direction)) * (radius + a.getRadius()) + x + 1),
				(int)(Math.sin(Math.toRadians(direction)) * (radius + a.getRadius()) + y + 1));
		a.setDirection(direction);
		myGame.addObj(a);
		b.setXY((int)(Math.cos(Math.toRadians(direction)) * (radius + b.getRadius()) * -1 + x - 1),
				(int)(Math.sin(Math.toRadians(direction)) * (radius + b.getRadius()) * -1 + y - 1));
		b.setDirection(direction + 180);
		myGame.addObj(b);
	}

	public boolean colliding(FieldObject s) {
		if (s instanceof Shape) {
			double space = this.radius + ((Shape) s).getRadius();
			double distance = Math.sqrt(Math.pow(x - ((Shape) s).getX(), 2) + Math.pow(y - ((Shape) s).getY(), 2));
			return distance <= space;
		}
		return false;
	}
}
