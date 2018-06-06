package simpleshapes;
import handlers.Player;
import superclasses.SimpleShape;

public class Square extends SimpleShape{
	public Square (Player o) {
		super(o);
		value = 4;
		cost = 40;
	}
	
	public void process() {
		if (img == null)
			img = myGame.getUI().readImage("square.png");
		super.process();
	}
}
