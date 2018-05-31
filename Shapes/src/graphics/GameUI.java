package graphics;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import handlers.*;

public class GameUI extends UI {
	private static final long serialVersionUID = 3843670119322135505L;
	protected Game game;
	protected boolean playerTwoOn;
	
	public GameUI() {
		super();
		playerTwoOn = true;
	}
	
	public GameUI(Window window) {
		super(window);
		playerTwoOn = true;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_P:
			game.togglePause();
			break;
		}
		if (!game.getPause()) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_1:
				game.getPlayers()[0].getInventory(0).use(game);
				break;
			case KeyEvent.VK_2:
				game.getPlayers()[0].getInventory(1).use(game);
				break;
			case KeyEvent.VK_3:
				game.getPlayers()[0].getInventory(2).use(game);
				break;
			case KeyEvent.VK_4:
				game.getPlayers()[0].getInventory(3).use(game);
				break;
			case KeyEvent.VK_5:
				game.getPlayers()[0].getInventory(4).use(game);
				break;
			case KeyEvent.VK_6:
				game.getPlayers()[0].getInventory(5).use(game);
				break;
			}
			if (playerTwoOn) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_B:
					game.getPlayers()[1].getInventory(0).use(game);
					break;
				case KeyEvent.VK_N:
					game.getPlayers()[1].getInventory(1).use(game);
					break;
				case KeyEvent.VK_M:
					game.getPlayers()[1].getInventory(2).use(game);
					break;
				case KeyEvent.VK_COMMA:
					game.getPlayers()[1].getInventory(3).use(game);
					break;
				case KeyEvent.VK_PERIOD:
					game.getPlayers()[1].getInventory(4).use(game);
					break;
				case KeyEvent.VK_SLASH:
					game.getPlayers()[1].getInventory(5).use(game);
					break;
				}
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());
		if (e.getX() >= 380 && e.getX() <= 630 && e.getY() >= 0 && e.getY() <= 50) {
			game.togglePause();
		}
		else if (e.getX() >= 630 && e.getX() <= 870 && e.getY() >= 0 && e.getY() <= 50) {
			game.forceClose();
			if (game.isSomeoneDead() || game.getPause()) {
				game.runGame();
				return;
			}
		}
	}
	
	public void disablePlayerTwo() {
		playerTwoOn = false;
	}
	
	public void returnToMenu() {
		game.stopGame();
		window.getFrame().remove(this);
		new Menu(new MenuUI(window));
	}
}
