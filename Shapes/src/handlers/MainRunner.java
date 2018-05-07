package handlers;

import graphics.UI;
import simpleshapes.*;
import supershapes.*;

public class MainRunner {
	public static void main(String[] args) {
		Game game = new Game(new UI());
		game.spawnShapeByPlayerIndex(new Octagon(new Player()), 0);
		game.spawnShapeByPlayerIndex(new Dodecagon(new Player()), 1);
		game.runGame();
	}

}
