package superclasses;

import handlers.Player;

public class SimpleShape extends Shape {
	public SimpleShape(Player o) {
		super(o);
		direction = 0;
		speed = 3;
	}
	
	public int compareTo(FieldObject s) {
		if (s instanceof SuperShape) {
			return ((SuperShape)s).compareTo(this);
		}
		return super.compareTo(s);
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof SimpleShape) {
			if (c < 0) {
				return this;
			}
			return s;
		}
		else if (s instanceof SuperShape) {
			return this;
		}
		return null;
	}
}