package superclasses;

import handlers.*;

public class Shape extends MovingObject implements Cloneable{
	protected int value;
	protected Player owner;
	protected int cost;
	
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
		dropShadow();
	}
	
	public boolean colliding(FieldObject s) {
		if (s instanceof Shape) {
			double space = this.radius + ((Shape)s).getRadius();
			double distance = Math.sqrt(Math.pow(x - ((Shape)s).getX(), 2) + Math.pow(y - ((Shape)s).getY(), 2));
			return distance <= space && this.owner != ((Shape)s).getOwner();
		}
		return s.colliding(this);
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public void setXYToTarget() {
		x = owner.getTarget().getX();
		y = owner.getTarget().getY();
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
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
	
	public String getImgName() {
		return imgName;
	}
	
	public Shape clone(){  
	    try{  
	        return (Shape)super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
}
