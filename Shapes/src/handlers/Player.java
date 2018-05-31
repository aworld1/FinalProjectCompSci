package handlers;

import simpleshapes.*;
import superclasses.*;
import supershapes.*;

public class Player {
	private Target target;
	private int energy;
	private int health;
	private Game game;
	private int startHealth;
	public InventorySlot[] inventory;
	
	public Player() {
		target = new Target(null,0,0,90);
		health = 50;
		startHealth = 50;
		energy = 50;
		initInventory();
	}
	
	public Player(Game g, int x, int y, int d) {
		setGame(g);
		target = new Target(g,x,y,d);
		health = 50;
		startHealth = 50;
		energy = 50;
		initInventory();
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
	public void loseEnergy(int v) {
		setEnergy(energy - v);
	}
	public void initInventory() {
		inventory = new InventorySlot[6];
		inventory[0] = new InventorySlot(new Circle(this), 350);
		inventory[1] = new InventorySlot(new X(this), 500);
		inventory[2] = new InventorySlot(new Triangle(this), 650);
		inventory[3] = new InventorySlot(new Square(this), 800);
		inventory[4] = new InventorySlot(new Pentagon(this), 1000);
		inventory[5] = new InventorySlot(new Missile(this), 4000);
	}
	public void addSuperShape(SuperShape s, int c) {
		inventory[5] = new InventorySlot(s, c);
	}
	public InventorySlot getInventory(int i) {
		return inventory[i];
	}
	public InventorySlot[] getInventory() {
		return inventory;
	}
	public void gainEnergy(int i) {
		energy += i;
	}
	public void gainHealth(int i) {
		health += i;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getStartHealth() {
		return startHealth;
	}

	public void setStartHealth(int startHealth) {
		this.startHealth = startHealth;
	}
}