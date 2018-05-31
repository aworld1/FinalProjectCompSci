package handlers;

import java.awt.image.BufferedImage;

import graphics.*;
import superclasses.*;

public class Menu {
	private SuperShape superOne, superTwo;
	private MenuUI ui;
	private BufferedImage img;
	
	public Menu(MenuUI u) {
		superOne = null;
		superTwo = null;
		ui = u;
		ui.setMenu(this);
		img = ui.readImage("menu.png");
		draw();
		ui.getBuffer().show();
	}
	
	public MenuUI getUI() {
		return ui;
	}
	
	public SuperShape getSuperOne() {
		return superOne;
	}

	public void setSuperOne(SuperShape superOne) {
		this.superOne = superOne;
	}
	
	public SuperShape getSuperTwo() {
		return superTwo;
	}

	public void setSuperTwo(SuperShape superTwo) {
		this.superTwo = superTwo;
	}
	
	public void draw() {
		ui.draw(img, 0, 0, 0, 1250, 750);
		ui.getBuffer().show();
	}
}
