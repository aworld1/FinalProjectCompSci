package handlers;
import java.awt.Color;
import java.awt.Graphics;

import graphics.Dimensions;
import superclasses.FieldObject;
import superclasses.Shape;

public class Goal extends FieldObject{
	private int x;
	public Goal(int newX) {
		this.setX(newX);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public boolean colliding(FieldObject s) {
		if (s instanceof Shape) {
			return Math.abs(((Shape)s).getX() - x) <= ((Shape)s).getRadius();
		}
		return super.colliding(s);
	}
	public FieldObject evaluate(FieldObject fieldObject, int compareTo) {
		if (fieldObject instanceof Shape) {
			((Shape)fieldObject).getOwner().loseHealth(((Shape)fieldObject).getValue());
			return fieldObject;
		}
		return null;
	}
	
	public void process() {
		draw();
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		g.setColor(Color.orange);
		if (x >= 350) {
			g.fillRect(x,Dimensions.getY(),10,Dimensions.getHeight());
		}
		else {
			g.fillRect(x-10,Dimensions.getY(),10,Dimensions.getHeight());
		}
	}
}
