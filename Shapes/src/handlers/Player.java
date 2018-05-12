package handlers;

import simpleshapes.*;
import superclasses.*;

public class Player {
	private Target target;
	private int energy;
	private int health;
	public InventorySlot[] inventory;
	
	public Player() {
		target = new Target(0,0,90);
		health = 100;
		energy = 150;
		initInventory();
	}
	
	public Player(int x, int y,int d) {
		target = new Target(x,y,d);
		health = 100;
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
		inventory[0] = new InventorySlot(new Circle(this), 250);
		inventory[1] = new InventorySlot(new X(this), 400);
		inventory[2] = new InventorySlot(new Triangle(this), 550);
		inventory[3] = new InventorySlot(new Square(this), 700);
		inventory[4] = new InventorySlot(new Pentagon(this), 900);
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
}