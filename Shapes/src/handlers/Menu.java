package handlers;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

import graphics.*;
import superclasses.*;

public class Menu {
	private SuperShape[] supers;
	private MenuUI ui;
	private BufferedImage img;
	private Map map;
	private int[] sEnergy;
	private int[] sHealth;
	
	public Menu(MenuUI u) {
		setMap(new Map(new ArrayList<FieldObject>(), "Classic"));
		ui = u;
		ui.setMenu(this);
		supers = new SuperShape[2];
		sHealth = new int[] {50,50};
		sEnergy = new int[] {50,50};
		img = ui.readImage("menu.png");
		draw();
		ui.getBuffer().show();
	}
	
	public MenuUI getUI() {
		return ui;
	}
	
	public SuperShape[] getSupers() {
		return supers;
	}

	public void setSuper(int index, SuperShape s) {
		supers[index] = s;
	}
	
	public void draw() {
		ui.clear();
		ui.draw(img, 0, 0, 0, 1250, 750);
		switch (ui.getPageName()) {
		case "instructions":
			ui.draw(ui.readImage("instruct.png"), 0, 312, 187, 625, 375);
			break;
		case "credits":
			ui.draw(ui.readImage("credits.png"), 0, 312, 187, 625, 375);
			break;
		case "settings":
			ui.draw(ui.readImage("settings.png"), 0, 312, 187, 625, 375);
			Graphics g = ui.getG();
			g.setColor(Color.black);
			g.setFont(new Font("Helvetica", Font.PLAIN, 18)); 
			g.drawString("" + sHealth[0],625 - (Integer.toString(sHealth[0]).length()) * 5,310);
			g.drawString("" + sEnergy[0],625 - (Integer.toString(sEnergy[0]).length()) * 5,355);
			g.drawString("" + sHealth[1],625 - (Integer.toString(sHealth[1]).length()) * 5,427);
			g.drawString("" + sEnergy[1],625 - (Integer.toString(sEnergy[1]).length()) * 5,470);
			break;
		case "map":
			ui.draw(ui.readImage("map.png"), 0, 312, 187, 625, 375);
			switch (map.getMapName()) {
			case "Automated":
				ui.draw(ui.readImage("mapblurbs/AutomatedText.png"), 0, 345, 444, 558, 106);
				break;
			case "Chaos":
				ui.draw(ui.readImage("mapblurbs/ChaosText.png"), 0, 345, 444, 558, 106);
				break;
			case "Classic":
				ui.draw(ui.readImage("mapblurbs/ClassicText.png"), 0, 345, 444, 558, 106);
				break;
			case "Cornered":
				ui.draw(ui.readImage("mapblurbs/CorneredText.png"), 0, 345, 444, 558, 106);
				break;
			case "GreatWall":
				ui.draw(ui.readImage("mapblurbs/GreatWallText.png"), 0, 345, 444, 558, 106);
				break;
			case "Guarded":
				ui.draw(ui.readImage("mapblurbs/GuardedText.png"), 0, 345, 444, 558, 106);
				break;
			case "Poison":
				ui.draw(ui.readImage("mapblurbs/PoisonText.png"), 0, 345, 444, 558, 106);
				break;
			case "Protected":
				ui.draw(ui.readImage("mapblurbs/ProtectedText.png"), 0, 345, 444, 558, 106);
				break;
			case "Raid":
				ui.draw(ui.readImage("mapblurbs/RaidText.png"), 0, 345, 444, 558, 106);
				break;
			case "Redirect":
				ui.draw(ui.readImage("mapblurbs/RedirectText.png"), 0, 345, 444, 558, 106);
				break;
			case "Regenerate":
				ui.draw(ui.readImage("mapblurbs/RegenerateText.png"), 0, 345, 444, 558, 106);
				break;
			case "Shameless":
				ui.draw(ui.readImage("mapblurbs/ShamelessText.png"), 0, 345, 444, 558, 106);
				break;
			}
			break;
		case "supershape":
			ui.draw(ui.readImage("supershape.png"), 0, 312, 187, 625, 375);
			break;
		}
		ui.getBuffer().show();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public void changeE(int amt, int index) {
		if (sEnergy[index] + amt > 0)
			sEnergy[index] += amt;
	}
	
	public void changeH(int amt, int index) {
		if (sHealth[index] + amt > 0)
			sHealth[index] += amt;
	}
	
	public int[] getGameH() {
		return sHealth;
	}
	
	public int[] getGameE() {
		return sEnergy;
	}
	
	public void resetEHToDefault() {
		sHealth[0] = 50; sHealth[1] = 50; sEnergy[0] = 50; sEnergy[1] = 50;
	}
}
