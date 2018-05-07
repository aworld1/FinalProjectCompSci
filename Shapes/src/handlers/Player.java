package handlers;
public class Player {
	private Target target;
	private int energy;
	private int health;
	
	public Player() {
		target = new Target(0,0,90);
		health = 100;
		energy = 50;
	}
	
	public Player(int x, int y,int d) {
		target = new Target(x,y,d);
		health = 100;
		energy = 50;
	}
	
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void loseHealth(int v) {
		setHealth(health - v);
	}
}