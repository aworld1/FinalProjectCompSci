package handlers;

import graphics.UI;

public class MainRunner {
	public static void main(String[] args) {
		Game game = new Game(new UI());
		game.runGame();
	}
}