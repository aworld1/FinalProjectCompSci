package handlers;

import superclasses.*;

public class InventorySlot {
	private Shape shape;
	private double cooldown;
	public long lastUse;
	public InventorySlot(Shape s, double c) {
		shape = s;
		cooldown = c;
		lastUse = 0;
	}
	public Shape getShape() {
		return shape;
	}
	public double getCooldown() {
		return cooldown;
	}
	public void use(Game game) {
		if (System.currentTimeMillis() - lastUse >= cooldown && shape.getOwner().getEnergy() >= shape.getCost()) {
			game.spawnShape(shape.clone());
			shape.getOwner().loseEnergy(shape.getCost());
			lastUse = System.currentTimeMillis();
		}
	}
}
