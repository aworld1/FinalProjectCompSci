package superclasses;

import graphics.Dimensions;
import handlers.Player;

public class Shape extends FieldObject{
	protected int value;
	protected int x;
	protected int y;
	protected int direction;
	protected Player owner;
	protected double speed;
	protected double radius;
	protected int cost;
	protected double rotation;
	
	public Shape(Player o) {
		owner = o;
		x = owner.getTarget().getX();
		y = owner.getTarget().getY();
		setCost(value);
	}
	
	public int compareTo(FieldObject s) {
		if (s instanceof Shape) {
			int x = value - ((Shape)s).getValue();
			if (Math.abs(x) == 4)
				x *= -1;
			return x;
		}
		return super.compareTo(s);
	}
	
	public void process() {
		move();
		rotation += 5;
		draw();
	}
	
	public boolean colliding(FieldObject s) {
		if (s instanceof Shape) {
			double space = this.radius + ((Shape)s).getRadius();
			double distance = Math.sqrt(Math.pow(x - ((Shape)s).getX(), 2) + Math.pow(y - ((Shape)s).getY(), 2));
			return distance <= space && this.owner != ((Shape)s).getOwner();
		}
		return super.colliding(s);
	}
	
	public void move() {
		if (y <= Dimensions.getY() + radius || y >= Dimensions.getY() + Dimensions.getHeight() - radius) {
			direction += (2 * (180 - direction)) % 360;
		}
		x += Math.round(Math.cos(Math.toRadians(direction)) * speed);
		y += Math.round(Math.sin(Math.toRadians(direction)) * speed);
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setXYToTarget() {
		x = owner.getTarget().getX();
		y = owner.getTarget().getY();
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String getLoc() {
		// Debugging purposes
		return "(" + x + ", " + y + ")";
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
}
