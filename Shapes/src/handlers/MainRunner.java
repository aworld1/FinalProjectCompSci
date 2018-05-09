package handlers;

import graphics.UI;
import simpleshapes.*;
import superclasses.Flector;
import supershapes.*;

public class MainRunner {
	public static void main(String[] args) {
		Game game = new Game(new UI());
		game.spawnShapeByPlayerIndex(new Triangle(new Player()), 0);
		game.spawnShapeByPlayerIndex(new CircleFirework(new Player()), 1);
		game.addObj(new Flector(800,350,0,0,0,3));
		game.runGame();
	}

}
