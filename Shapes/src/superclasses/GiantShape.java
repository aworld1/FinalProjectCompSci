package superclasses;

import handlers.Player;

public class GiantShape extends SuperShape {
	protected int giantLife;
	public GiantShape(Player o, int l) {
		super(o);
		giantLife = l;
		value = l;
	}
	
	public int compareTo(FieldObject s) {
		if (s instanceof Shape) {
			int x = giantLife - ((Shape)s).getValue();
			if (x < 0 && s instanceof SimpleShape)
				x = 0;
			return x;
		}
		return 0;
	}
	
	public FieldObject evaluate(FieldObject s, int c) {
		if (s instanceof Shape) {
			giantLife = c;
			if (c <= 0) {
				return this;
			}
			return s;
		}
		return null;
	}
}
