package superclasses;

import handlers.Player;

public abstract class SuperShape extends Shape {
	public SuperShape(Player o) {
		super(o);
		radius = 15;
	}
	public int compareTo(FieldObject s) {
		return -1;
	}
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof SimpleShape) {
			return s;
		}
		return null;
	}
}
