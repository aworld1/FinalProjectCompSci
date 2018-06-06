package handlers;

import superclasses.*;

public class Target extends MovingObject {
	public Target(Game g, int x, int y, int d) {
		this.x = x;
		this.y = y;
		direction = d;
		speed = 7;
		radius = 10;
		myGame = g;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("circle.png");
		move();
		draw();
		dropShadow();
	}
	
	public void dropShadow() {
		int x = (int)(Math.random()*5);
		switch (x) {
		case 0:
			img = myGame.getUI().readImage("circle.png");
			break;
		case 1:
			img = myGame.getUI().readImage("x.png");
			break;
		case 2:
			img = myGame.getUI().readImage("triangle.png");
			break;
		case 3:
			img = myGame.getUI().readImage("square.png");
			break;
		case 4:
			img = myGame.getUI().readImage("pentagon.png");
			break;
		}
		rotation = Math.random()*360;
		super.dropShadow();
		img = myGame.getUI().readImage("circle.png");
	}
}