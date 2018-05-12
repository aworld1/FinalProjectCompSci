package handlers;

import graphics.UI;
//import obstacles.*;
import supershapes.Haus;

public class MainRunner {
	public static void main(String[] args) {
		Game game = new Game(new UI());
		game.spawnShapeByPlayerIndex(new Haus(new Player()), 0);
		/*game.spawnShapeByPlayerIndex(new Octagon(new Player()), 1);
		game.addObj(new Flector(150, 250, 90, 30, 0, 0));
		game.addObj(new Flector(150, 250, 270, 30, 0, 0));
		game.addObj(new Flector(900, 250, 90, 30, 180, 0));
		game.addObj(new Flector(900, 250, 270, 30, 180, 0));
		game.addObj(new DisappearingCannon(625,350,0,0, 1, 10));
		game.addObj(new DisappearingCannon(625,150,0,0, 1, 10));
		game.addObj(new DisappearingCannon(625, 550,0,0, 1, 10));*/
		//game.addObj(new DisappearingCannon(625,350,90,1,0, 0, 30));
		game.runGame();
	}
}