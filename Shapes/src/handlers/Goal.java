package handlers;
import java.awt.Color;
import java.awt.Graphics;

import graphics.Dimensions;
import superclasses.FieldObject;
import superclasses.Shape;

public class Goal extends FieldObject{
	private int x;
	private Player owner;
	public Goal(int newX, Player p) {
		this.setX(newX);
		setOwner(p);
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
			owner.loseHealth(((Shape)fieldObject).getValue());
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
			g.setColor(Color.red);
			g.fillRect(x,(int)(Dimensions.getY() + Dimensions.getHeight()/2 - Dimensions.getHeight()/2 * ((double)owner.getHealth() / owner.getStartHealth())),
						10,(int)(Dimensions.getHeight() * ((double)owner.getHealth() / owner.getStartHealth())));
		}
		else {
			g.fillRect(x-10,Dimensions.getY(),10,Dimensions.getHeight());
			g.setColor(Color.red);
			g.fillRect(x-10,(int)(Dimensions.getY() + Dimensions.getHeight()/2 - Dimensions.getHeight()/2 * ((double)owner.getHealth() / owner.getStartHealth())),
					10,(int)(Dimensions.getHeight() * ((double)owner.getHealth() / owner.getStartHealth())));
		}
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
