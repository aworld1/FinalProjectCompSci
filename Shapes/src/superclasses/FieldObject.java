package superclasses;

import handlers.Game;

public class FieldObject {
	protected Game myGame;
	protected boolean dead;
	public FieldObject() {
		dead = false;
	}
	public void draw() {
		// Draw
	}
	public void process() {
		// Process
	}
	public boolean colliding(FieldObject a) {
		return false;
	}
	public int compareTo(FieldObject fieldObject) {
		return 0;
	}
	public FieldObject evaluate(FieldObject fieldObject, int compareTo) {
		return null;
	}
	public void doBeforeDie() {
		if (!dead) {
			String l = myGame.createDeathSentence(this);
			myGame.addToLog(l);
			System.out.println(l);
		}
		dead = true;
		return;
	}
	public Game getGame() {
		return myGame;
	}
	public void setGame(Game myGame) {
		this.myGame = myGame;
	}
	public boolean isDead() {
		return dead;
	}
}
