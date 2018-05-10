package handlers;

import graphics.UI;
import obstacles.*;
import supershapes.*;

public class MainRunner {
	public static void main(String[] args) {
		Game game = new Game(new UI());
		game.spawnShapeByPlayerIndex(new CircleFirework(new Player()), 0);
		game.spawnShapeByPlayerIndex(new Octagon(new Player()), 1);
		game.addObj(new Flector(625, 250, 0, 0, 0, 1));
		game.addObj(new Flector(725, 250, 0, 0, 0, -200));
		game.addObj(new Flector(725, 350, 0, 0, 0, 200));
		game.addObj(new Flector(725, 450, 0, 0, 0, -1));
		game.addObj(new Flector(625, 450, 0, 0, 0, 200));
		game.addObj(new Flector(525, 450, 0, 0, 0, -200));
		game.addObj(new Flector(525, 350, 0, 0, 0, 1));
		game.addObj(new Flector(525, 250, 0, 0, 0, -1));
		game.addObj(new Cannon(625,350,0,0, 1, 50));
		game.runGame();
	}
}