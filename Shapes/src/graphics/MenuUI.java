package graphics;

import java.awt.event.*;

import handlers.*;

public class MenuUI extends UI{
	private static final long serialVersionUID = -5198534914510310340L;
	private Menu menu;
	
	public MenuUI() {
		super();
	}
	
	public MenuUI(Window window) {
		super(window);
	}

	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());
		if (e.getX() >= 270 && e.getX() <= 590 && e.getY() >= 480 && e.getY() <= 570) {
			System.out.println("PvAI");
			AIGame g = new AIGame(new GameUI(window));
			window.getFrame().remove(this);
			g.runGame();
		}
		if (e.getX() >= 660 && e.getX() <= 980 && e.getY() >= 480 && e.getY() <= 570) {
			System.out.println("PvP");
			Game g = new Game(new GameUI(window));
			window.getFrame().remove(this);
			g.runGame();
		}
		if (e.getX() >= 270 && e.getX() <= 590 && e.getY() >= 190 && e.getY() <= 420) {
			System.out.println("Select Map");
		}
		if (e.getX() >= 660 && e.getX() <= 980 && e.getY() >= 190 && e.getY() <= 420) {
			System.out.println("Select SuperShape");
		}
		if (e.getX() >= 1020 && e.getX() <= 1085 && e.getY() >= 275 && e.getY() <= 335) {
			System.out.println("Help");
		}
		if (e.getX() >= 1020 && e.getX() <= 1085 && e.getY() >= 480 && e.getY() <= 545) {
			System.out.println("Settings");
		}
		if (e.getX() >= 535 && e.getX() <= 720 && e.getY() >= 620 && e.getY() <= 655) {
			System.out.println("Credits");
		}
	}
}
