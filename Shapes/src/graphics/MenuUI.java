package graphics;

import java.awt.event.*;
import java.util.ArrayList;

import handlers.*;
import obstacles.*;
import superclasses.FieldObject;

public class MenuUI extends UI {
	private static final long serialVersionUID = -5198534914510310340L;
	private Menu menu;
	private String pageName;

	public MenuUI() {
		super();
		pageName = "main";
	}

	public MenuUI(Window window) {
		super(window);
		pageName = "main";
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void changePage(String newPageName) {
		pageName = newPageName;
		menu.draw();
		getBuffer().show();
	}

	public void initEHToGame(Game g) {
		g.getPlayers()[0].setHealth(menu.getGameH()[0]);
		g.getPlayers()[0].setStartHealth(menu.getGameH()[0]);
		g.getPlayers()[0].setEnergy(menu.getGameE()[0]);
		g.getPlayers()[0].setSuper(menu.getSupers()[0]);
		g.getPlayers()[1].setHealth(menu.getGameH()[1]);
		g.getPlayers()[1].setStartHealth(menu.getGameH()[1]);
		g.getPlayers()[1].setEnergy(menu.getGameE()[1]);
		g.getPlayers()[1].setSuper(menu.getSupers()[1]);
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());
		if (pageName.equals("main")) {
			if (e.getX() >= 270 && e.getX() <= 590 && e.getY() >= 480 && e.getY() <= 570) {
				System.out.println("PvAI");
				AIGame g = new AIGame(new GameUI(window));
				initEHToGame(g);
				window.getFrame().remove(this);
				g.addMap(menu.getMap().getObjs());
				g.runGame();
			} else if (e.getX() >= 660 && e.getX() <= 980 && e.getY() >= 480 && e.getY() <= 570) {
				System.out.println("PvP");
				Game g = new Game(new GameUI(window));
				initEHToGame(g);
				window.getFrame().remove(this);
				g.addMap(menu.getMap().getObjs());
				g.runGame();
			} else if (e.getX() >= 270 && e.getX() <= 590 && e.getY() >= 190 && e.getY() <= 420) {
				changePage("map");
			} else if (e.getX() >= 660 && e.getX() <= 980 && e.getY() >= 190 && e.getY() <= 420) {
				changePage("supershape");
			} else if (e.getX() >= 1020 && e.getX() <= 1085 && e.getY() >= 275 && e.getY() <= 335) {
				changePage("instructions");
			} else if (e.getX() >= 1020 && e.getX() <= 1085 && e.getY() >= 480 && e.getY() <= 545) {
				changePage("settings");
			} else if (e.getX() >= 535 && e.getX() <= 720 && e.getY() >= 620 && e.getY() <= 655) {
				changePage("credits");
			}
		} else if (!pageName.equals("main")
				&& (e.getX() >= 880 && e.getX() <= 930 && e.getY() >= 195 && e.getY() <= 235)) {
			changePage("main");
		} else if (pageName.equals("settings")) {
			if (e.getX() >= 465 && e.getX() <= 510 && e.getY() >= 290 && e.getY() <= 315) {
				menu.changeH(-10, 0);
			} else if (e.getX() >= 545 && e.getX() <= 590 && e.getY() >= 290 && e.getY() <= 315) {
				menu.changeH(-1, 0);
			} else if (e.getX() >= 660 && e.getX() <= 705 && e.getY() >= 290 && e.getY() <= 315) {
				menu.changeH(1, 0);
			} else if (e.getX() >= 740 && e.getX() <= 785 && e.getY() >= 290 && e.getY() <= 315) {
				menu.changeH(10, 0);
			} else if (e.getX() >= 465 && e.getX() <= 510 && e.getY() >= 340 && e.getY() <= 360) {
				menu.changeE(-10, 0);
			} else if (e.getX() >= 545 && e.getX() <= 590 && e.getY() >= 340 && e.getY() <= 360) {
				menu.changeE(-1, 0);
			} else if (e.getX() >= 660 && e.getX() <= 705 && e.getY() >= 340 && e.getY() <= 360) {
				menu.changeE(1, 0);
			} else if (e.getX() >= 740 && e.getX() <= 785 && e.getY() >= 340 && e.getY() <= 360) {
				menu.changeE(10, 0);
			} else if (e.getX() >= 465 && e.getX() <= 510 && e.getY() >= 405 && e.getY() <= 430) {
				menu.changeH(-10, 1);
			} else if (e.getX() >= 545 && e.getX() <= 590 && e.getY() >= 405 && e.getY() <= 430) {
				menu.changeH(-1, 1);
			} else if (e.getX() >= 660 && e.getX() <= 705 && e.getY() >= 405 && e.getY() <= 430) {
				menu.changeH(1, 1);
			} else if (e.getX() >= 740 && e.getX() <= 785 && e.getY() >= 405 && e.getY() <= 430) {
				menu.changeH(10, 1);
			} else if (e.getX() >= 465 && e.getX() <= 510 && e.getY() >= 450 && e.getY() <= 470) {
				menu.changeE(-10, 1);
			} else if (e.getX() >= 545 && e.getX() <= 590 && e.getY() >= 450 && e.getY() <= 470) {
				menu.changeE(-1, 1);
			} else if (e.getX() >= 660 && e.getX() <= 705 && e.getY() >= 450 && e.getY() <= 470) {
				menu.changeE(1, 1);
			} else if (e.getX() >= 740 && e.getX() <= 785 && e.getY() >= 450 && e.getY() <= 470) {
				menu.changeE(10, 1);
			} else if (e.getX() >= 485 && e.getX() <= 765 && e.getY() >= 510 && e.getY() <= 535) {
				menu.resetEHToDefault();
			}
			changePage("settings");
		} else if (pageName.equals("map")) {
			ArrayList<FieldObject> mapobjs = new ArrayList<FieldObject>();
			if (e.getX() >= 350 && e.getX() <= 505 && e.getY() >= 245 && e.getY() <= 285) {
				menu.setMap(new Map(mapobjs, "Classic"));
			} else if (e.getX() >= 545 && e.getX() <= 700 && e.getY() >= 245 && e.getY() <= 285) {
				mapobjs.add(new Flector(630, 150, 0, 0, 180, 0));
				mapobjs.add(new Flector(630, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(300, 350, 0, 0, 270, 2));
				mapobjs.add(new Flector(960, 350, 0, 0, 90, -2));
				mapobjs.add(new Cannon(630, 350, 0, 0, 90, 1, 90));
				mapobjs.add(new HealthOrb(630, 280, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(630, 420, 0, 0, 20, 1));
				mapobjs.add(new EnergyOrb(560, 350, 0, 0, 20, 5));
				mapobjs.add(new EnergyOrb(700, 350, 0, 0, 20, 5));
				menu.setMap(new Map(mapobjs, "Redirect"));
			} else if (e.getX() >= 750 && e.getX() <= 895 && e.getY() >= 245 && e.getY() <= 285) {
				mapobjs.add(new DisappearingFlector(150, 90, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 140, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 190, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 240, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 290, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 340, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 390, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 440, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 490, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 540, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 590, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(150, 640, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(1110, 90, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 140, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 190, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 240, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 290, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 340, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 390, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 440, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 490, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 540, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 590, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(1110, 640, 0, 0, 180, 0));
				mapobjs.add(new HealthOrb(350, 200, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(910, 500, 0, 0, 20, 1));
				mapobjs.add(new EnergyOrb(910, 200, 0, 0, 20, 5));
				mapobjs.add(new EnergyOrb(350, 500, 0, 0, 20, 5));
				mapobjs.add(new Cannon(630, 350, 270, 1, 90, 1, 60));
				menu.setMap(new Map(mapobjs, "Protected"));
			} else if (e.getX() >= 350 && e.getX() <= 505 && e.getY() >= 295 && e.getY() <= 335) {
				mapobjs.add(new Flector(630, 150, 0, 0, 180, 0));
				mapobjs.add(new Flector(630, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(400, 150, 90, 1, 180, 0));
				mapobjs.add(new Flector(860, 550, 270, 1, 0, 0));
				mapobjs.add(new Cannon(630, 350, 270, 1, 90, 1, 180));
				mapobjs.add(new EnergyOrb(630, 350, 0, 0, 40, 5));
				menu.setMap(new Map(mapobjs, "Automated"));
			} else if (e.getX() >= 545 && e.getX() <= 700 && e.getY() >= 295 && e.getY() <= 335) {
				mapobjs.add(new Flector(370, 125, 0, 0, 180, 0));
				mapobjs.add(new Flector(370, 275, 0, 0, 0, 0));
				mapobjs.add(new Flector(370, 425, 0, 0, 90, 0));
				mapobjs.add(new Flector(370, 575, 0, 0, 0, 0));
				mapobjs.add(new Flector(860, 125, 0, 0, 180, 0));
				mapobjs.add(new Flector(860, 275, 0, 0, 270, 0));
				mapobjs.add(new Flector(860, 425, 0, 0, 180, 0));
				mapobjs.add(new Flector(860, 575, 0, 0, 0, 0));
				mapobjs.add(new Flector(570, 450, 0, 0, 90, 0));
				mapobjs.add(new Flector(660, 450, 0, 0, 270, 0));
				mapobjs.add(new Flector(570, 250, 0, 0, 90, 0));
				mapobjs.add(new Flector(660, 250, 0, 0, 270, 0));
				mapobjs.add(new EnergyOrb(570, 200, 90, 2, 20, 2));
				mapobjs.add(new HealthOrb(660, 200, 90, 2, 20, 2));
				mapobjs.add(new EnergyOrb(570, 350, 90, 2, 20, 3));
				mapobjs.add(new HealthOrb(660, 350, 90, 2, 20, 3));
				mapobjs.add(new EnergyOrb(570, 550, 270, 2, 30, -2));
				mapobjs.add(new HealthOrb(660, 550, 270, 2, 30, -2));
				menu.setMap(new Map(mapobjs, "Regenerate"));
			} else if (e.getX() >= 750 && e.getX() <= 895 && e.getY() >= 295 && e.getY() <= 335) {
				mapobjs.add(new Flector(430, 150, 0, 0, 90, 0));
				mapobjs.add(new Flector(430, 250, 0, 0, 0, 0));
				mapobjs.add(new Flector(430, 450, 0, 0, 270, 0));
				mapobjs.add(new Flector(430, 550, 0, 0, 270, 0));
				mapobjs.add(new Flector(530, 550, 0, 0, 180, 0));
				mapobjs.add(new Flector(530, 150, 0, 0, 0, 0));
				mapobjs.add(new Flector(730, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(730, 150, 0, 0, 90, 0));
				mapobjs.add(new Flector(830, 150, 0, 0, 180, 0));
				mapobjs.add(new Flector(830, 250, 0, 0, 270, 0));
				mapobjs.add(new Flector(830, 450, 0, 0, 180, 0));
				mapobjs.add(new Flector(830, 550, 0, 0, 270, 0));
				mapobjs.add(new HealthOrb(430, 350, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(530, 250, 0, 0, 30, 1));
				mapobjs.add(new EnergyOrb(530, 350, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(530, 450, 0, 0, 30, 1));
				mapobjs.add(new HealthOrb(630, 150, 0, 0, 30, -1));
				mapobjs.add(new EnergyOrb(630, 250, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(630, 350, 0, 0, 30, -2));
				mapobjs.add(new EnergyOrb(630, 450, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(630, 550, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(730, 250, 0, 0, 30, 1));
				mapobjs.add(new EnergyOrb(730, 350, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(730, 450, 0, 0, 30, 1));
				mapobjs.add(new HealthOrb(830, 350, 0, 0, 30, -1));
				mapobjs.add(new DisappearingCannon(630, 80, 0, 0, 0, 0, 60));
				mapobjs.add(new DisappearingCannon(630, 630, 0, 0, 0, 0, 60));
				menu.setMap(new Map(mapobjs, "Poison"));
			} else if (e.getX() >= 350 && e.getX() <= 505 && e.getY() >= 340 && e.getY() <= 385) {
				mapobjs.add(new Flector(380, 100, 0, 0, 315, 0));
				mapobjs.add(new Flector(380, 200, 0, 0, 90, 0));
				mapobjs.add(new DisappearingFlector(330, 150, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(430, 150, 0, 0, 0, 0));
				mapobjs.add(new DisappearingCannon(380, 150, 0, 0, 0, 1, 90));
				mapobjs.add(new Flector(880, 500, 0, 0, 270, 0));
				mapobjs.add(new Flector(880, 600, 0, 0, 135, 0));
				mapobjs.add(new DisappearingFlector(830, 550, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(930, 550, 0, 0, 0, 0));
				mapobjs.add(new DisappearingCannon(880, 550, 0, 0, 0, 1, 90));
				mapobjs.add(new DisappearingCannon(530, 250, 0, 0, 0, 0, 75));
				mapobjs.add(new Cannon(730, 250, 0, 0, 0, 0, 75));
				mapobjs.add(new Cannon(530, 450, 0, 0, 90, 0, 75));
				mapobjs.add(new DisappearingCannon(730, 450, 0, 0, 90, 0, 75));
				mapobjs.add(new DisappearingFlector(530, 350, 0, 0, 180, 0));
				mapobjs.add(new DisappearingFlector(730, 350, 0, 0, 0, 0));
				mapobjs.add(new DisappearingFlector(630, 250, 0, 0, 270, 0));
				mapobjs.add(new DisappearingFlector(630, 450, 0, 0, 90, 0));
				mapobjs.add(new HealthOrb(630, 350, 0, 0, 30, 2));
				menu.setMap(new Map(mapobjs, "Guarded"));
			} else if (e.getX() >= 545 && e.getX() <= 700 && e.getY() >= 340 && e.getY() <= 385) {
				mapobjs.add(new Flector(400, 150, 0, 0, 0, 0));
				mapobjs.add(new Flector(400, 250, 0, 0, 0, 0));
				mapobjs.add(new Flector(400, 350, 0, 0, 0, 0));
				mapobjs.add(new Flector(400, 450, 0, 0, 0, 0));
				mapobjs.add(new Flector(400, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(830, 150, 0, 0, 180, 0));
				mapobjs.add(new Flector(830, 250, 0, 0, 180, 0));
				mapobjs.add(new Flector(830, 350, 0, 0, 180, 0));
				mapobjs.add(new Flector(830, 450, 0, 0, 180, 0));
				mapobjs.add(new Flector(830, 550, 0, 0, 180, 0));
				mapobjs.add(new Cannon(620, 250, 0, 0, 90, 0, 90));
				mapobjs.add(new Cannon(620, 350, 0, 0, 90, 0, 45));
				mapobjs.add(new Cannon(620, 450, 0, 0, 90, 0, 60));
				mapobjs.add(new HealthOrb(500, 270, 0, 0, 20, 1));
				mapobjs.add(new EnergyOrb(500, 430, 0, 0, 20, 4));
				mapobjs.add(new EnergyOrb(730, 270, 0, 0, 20, 4));
				mapobjs.add(new HealthOrb(730, 430, 0, 0, 20, 1));
				menu.setMap(new Map(mapobjs, "GreatWall"));
			} else if (e.getX() >= 750 && e.getX() <= 895 && e.getY() >= 340 && e.getY() <= 385) {
				mapobjs.add(new Flector(220, 100, 0, 0, 90, 0));
				mapobjs.add(new Flector(220, 600, 0, 0, 0, 0));
				mapobjs.add(new Flector(320, 200, 0, 0, 0, 0));
				mapobjs.add(new Flector(320, 300, 0, 0, 0, 0));
				mapobjs.add(new Flector(320, 400, 0, 0, 270, 0));
				mapobjs.add(new Flector(320, 500, 0, 0, 0, 0));
				mapobjs.add(new Flector(420, 100, 0, 0, 0, 0));
				mapobjs.add(new Flector(420, 600, 0, 0, 270, 0));
				mapobjs.add(new Flector(470, 600, 0, 0, 270, 0));
				mapobjs.add(new Flector(470, 400, 0, 0, 180, 0));
				mapobjs.add(new Flector(470, 200, 0, 0, 90, 0));
				mapobjs.add(new Flector(770, 100, 0, 0, 90, 0));
				mapobjs.add(new Flector(770, 200, 0, 0, 0, 0));
				mapobjs.add(new Flector(770, 500, 0, 0, 90, 0));
				mapobjs.add(new Flector(770, 600, 0, 0, 180, 0));
				mapobjs.add(new Flector(870, 300, 0, 0, 90, 0));
				mapobjs.add(new Flector(870, 350, 0, 0, 180, 0));
				mapobjs.add(new Flector(870, 400, 0, 0, 0, 0));
				mapobjs.add(new Flector(970, 100, 0, 0, 0, 0));
				mapobjs.add(new Flector(970, 200, 0, 0, 270, 0));
				mapobjs.add(new Flector(970, 500, 0, 0, 180, 0));
				mapobjs.add(new Flector(970, 600, 0, 0, 270, 0));
				menu.setMap(new Map(mapobjs, "Cornered"));
			} else if (e.getX() >= 350 && e.getX() <= 505 && e.getY() >= 395 && e.getY() <= 430) {
				mapobjs.add(new EnergyOrb(630, 350, 0, 0, 300, 1));
				mapobjs.add(new EnergyOrb(630, 100, 0, 0, 30, 3));
				mapobjs.add(new EnergyOrb(630, 600, 0, 0, 30, 3));
				mapobjs.add(new EnergyOrb(380, 350, 0, 0, 30, 3));
				mapobjs.add(new EnergyOrb(880, 350, 0, 0, 30, 3));
				mapobjs.add(new Flector(530, 200, 0, 0, 180, 0));
				mapobjs.add(new Flector(530, 500, 0, 0, 180, 0));
				mapobjs.add(new Flector(730, 200, 0, 0, 0, 0));
				mapobjs.add(new Flector(730, 500, 0, 0, 0, 0));
				mapobjs.add(new Flector(480, 350, 0, 0, 0, 2));
				mapobjs.add(new Flector(780, 350, 0, 0, 180, 2));
				mapobjs.add(new HealthOrb(630, 250, 0, 0, 30, 1));
				mapobjs.add(new HealthOrb(630, 350, 0, 0, 30, -1));
				mapobjs.add(new HealthOrb(630, 450, 0, 0, 30, 1));
				menu.setMap(new Map(mapobjs, "Raid"));
			} else if (e.getX() >= 545 && e.getX() <= 700 && e.getY() >= 395 && e.getY() <= 430) {
				mapobjs.add(new Flector(330, 250, 0, 0, 90, 0));
				mapobjs.add(new Flector(330, 300, 0, 0, 0, 0));
				mapobjs.add(new Flector(330, 400, 0, 0, 0, 0));
				mapobjs.add(new Flector(330, 450, 0, 0, 270, 0));
				mapobjs.add(new Flector(380, 150, 0, 0, 180, 0));
				mapobjs.add(new Flector(380, 200, 0, 0, 180, 0));
				mapobjs.add(new Flector(380, 250, 0, 0, 90, 0));
				mapobjs.add(new Flector(380, 300, 0, 0, 0, 0));
				mapobjs.add(new Flector(380, 400, 0, 0, 0, 0));
				mapobjs.add(new Flector(380, 450, 0, 0, 270, 0));
				mapobjs.add(new Flector(380, 500, 0, 0, 180, 0));
				mapobjs.add(new Flector(380, 550, 0, 0, 180, 0));
				mapobjs.add(new Flector(380, 100, 0, 0, 180, 0));
				mapobjs.add(new Flector(430, 150, 0, 0, 0, 0));
				mapobjs.add(new Flector(430, 200, 0, 0, 0, 0));
				mapobjs.add(new Flector(430, 250, 0, 0, 0, 0));
				mapobjs.add(new Flector(430, 450, 0, 0, 0, 0));
				mapobjs.add(new Flector(430, 500, 0, 0, 0, 0));
				mapobjs.add(new Flector(430, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(380, 600, 0, 0, 180, 0));
				mapobjs.add(new Cannon(530, 350, 0, 0, 90, 0, 90));
				mapobjs.add(new Flector(910, 250, 0, 0, 90, 0));
				mapobjs.add(new Flector(910, 300, 0, 0, 180, 0));
				mapobjs.add(new Flector(910, 400, 0, 0, 180, 0));
				mapobjs.add(new Flector(910, 450, 0, 0, 270, 0));
				mapobjs.add(new Flector(860, 150, 0, 0, 0, 0));
				mapobjs.add(new Flector(860, 200, 0, 0, 0, 0));
				mapobjs.add(new Flector(860, 250, 0, 0, 90, 0));
				mapobjs.add(new Flector(860, 300, 0, 0, 180, 0));
				mapobjs.add(new Flector(860, 400, 0, 0, 180, 0));
				mapobjs.add(new Flector(860, 450, 0, 0, 270, 0));
				mapobjs.add(new Flector(860, 500, 0, 0, 0, 0));
				mapobjs.add(new Flector(860, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(860, 100, 0, 0, 0, 0));
				mapobjs.add(new Flector(810, 150, 0, 0, 180, 0));
				mapobjs.add(new Flector(810, 200, 0, 0, 180, 0));
				mapobjs.add(new Flector(810, 250, 0, 0, 180, 0));
				mapobjs.add(new Flector(810, 450, 0, 0, 180, 0));
				mapobjs.add(new Flector(810, 500, 0, 0, 180, 0));
				mapobjs.add(new Flector(810, 550, 0, 0, 180, 0));
				mapobjs.add(new Flector(860, 600, 0, 0, 0, 0));
				mapobjs.add(new Cannon(710, 350, 0, 0, 90, 0, 90));
				mapobjs.add(new Flector(620, 350, 0, 0, 270, 3));
				mapobjs.add(new HealthOrb(620, 300, 0, 0, 30, 1));
				mapobjs.add(new HealthOrb(540, 200, 0, 0, 30, 2));
				mapobjs.add(new HealthOrb(700, 200, 0, 0, 30, 2));
				mapobjs.add(new HealthOrb(620, 100, 0, 0, 30, 3));
				mapobjs.add(new EnergyOrb(620, 400, 0, 0, 30, 4));
				mapobjs.add(new EnergyOrb(540, 500, 0, 0, 30, 6));
				mapobjs.add(new EnergyOrb(700, 500, 0, 0, 30, 6));
				mapobjs.add(new EnergyOrb(620, 600, 0, 0, 30, 9));
				menu.setMap(new Map(mapobjs, "Chaos"));
			} else if (e.getX() >= 750 && e.getX() <= 895 && e.getY() >= 395 && e.getY() <= 430) {
				mapobjs.add(new EnergyOrb(520, 200, 0, 0, 20, 3));
				mapobjs.add(new EnergyOrb(420, 130, 0, 0, 20, 3));
				mapobjs.add(new EnergyOrb(320, 200, 0, 0, 20, 3));
				mapobjs.add(new EnergyOrb(270, 300, 0, 0, 20, 3));
				mapobjs.add(new EnergyOrb(320, 400, 0, 0, 20, 3));
				mapobjs.add(new EnergyOrb(420, 470, 0, 0, 20, 3));
				mapobjs.add(new EnergyOrb(520, 400, 0, 0, 20, 3));
				mapobjs.add(new Flector(850, 150, 0, 0, 0, 0));
				mapobjs.add(new Flector(800, 200, 0, 0, 180, 0));
				mapobjs.add(new Flector(750, 250, 0, 0, 0, 0));
				mapobjs.add(new Flector(700, 300, 0, 0, 180, 0));
				mapobjs.add(new Flector(650, 350, 0, 0, 0, 0));
				mapobjs.add(new Flector(600, 400, 0, 0, 180, 0));
				mapobjs.add(new Flector(550, 450, 0, 0, 0, 0));
				mapobjs.add(new Flector(500, 500, 0, 0, 180, 0));
				mapobjs.add(new Flector(450, 550, 0, 0, 0, 0));
				mapobjs.add(new Flector(400, 600, 0, 0, 180, 0));
				mapobjs.add(new HealthOrb(700, 600, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(750, 500, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(800, 400, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(850, 500, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(900, 600, 0, 0, 20, 1));
				mapobjs.add(new HealthOrb(800, 500, 0, 0, 20, 1));
				menu.setMap(new Map(mapobjs, "Shameless"));
			}
			changePage("map");
			menu.draw();
		} else if (pageName.equals("supershape")) {
			if (e.getX() >= 350 && e.getX() <= 425 && e.getY() >= 250 && e.getY() <= 297) {
				menu.setSuper(0, "Octagon");
			} else if (e.getX() >= 426 && e.getX() <= 505 && e.getY() >= 250 && e.getY() <= 297) {
				menu.setSuper(1, "Octagon");
			} else if (e.getX() >= 547 && e.getX() <= 623 && e.getY() >= 250 && e.getY() <= 297) {
				menu.setSuper(0, "Dodecagon");
			} else if (e.getX() >= 624 && e.getX() <= 705 && e.getY() >= 250 && e.getY() <= 297) {
				menu.setSuper(1, "Dodecagon");
			} else if (e.getX() >= 745 && e.getX() <= 822 && e.getY() >= 250 && e.getY() <= 297) {
				menu.setSuper(0, "Mirror");
			} else if (e.getX() >= 823 && e.getX() <= 900 && e.getY() >= 250 && e.getY() <= 297) {
				menu.setSuper(1, "Mirror");
			} else if (e.getX() >= 350 && e.getX() <= 425 && e.getY() >= 300 && e.getY() <= 345) {
				menu.setSuper(0, "CircleFirework");
			} else if (e.getX() >= 426 && e.getX() <= 505 && e.getY() >= 300 && e.getY() <= 345) {
				menu.setSuper(1, "CircleFirework");
			} else if (e.getX() >= 547 && e.getX() <= 623 && e.getY() >= 300 && e.getY() <= 345) {
				menu.setSuper(0, "XFirework");
			} else if (e.getX() >= 624 && e.getX() <= 705 && e.getY() >= 300 && e.getY() <= 345) {
				menu.setSuper(1, "XFirework");
			} else if (e.getX() >= 745 && e.getX() <= 822 && e.getY() >= 300 && e.getY() <= 345) {
				menu.setSuper(0, "TriangleFirework");
			} else if (e.getX() >= 823 && e.getX() <= 900 && e.getY() >= 300 && e.getY() <= 345) {
				menu.setSuper(1, "TriangleFirework");
			} else if (e.getX() >= 350 && e.getX() <= 425 && e.getY() >= 350 && e.getY() <= 395) {
				menu.setSuper(0, "Guard");
			} else if (e.getX() >= 426 && e.getX() <= 505 && e.getY() >= 350 && e.getY() <= 395) {
				menu.setSuper(1, "Guard");
			} else if (e.getX() >= 547 && e.getX() <= 623 && e.getY() >= 350 && e.getY() <= 395) {
				menu.setSuper(0, "Missile");
			} else if (e.getX() >= 624 && e.getX() <= 705 && e.getY() >= 350 && e.getY() <= 395) {
				menu.setSuper(1, "Missile");
			} else if (e.getX() >= 745 && e.getX() <= 822 && e.getY() >= 350 && e.getY() <= 395) {
				menu.setSuper(0, "Circlinator");
			} else if (e.getX() >= 823 && e.getX() <= 900 && e.getY() >= 350 && e.getY() <= 395) {
				menu.setSuper(1, "Circlinator");
			}
			changePage("supershape");
		} else if (pageName.equals("credits")) {
			if (e.getX() >= 840 && e.getX() <= 925 && e.getY() >= 540 && e.getY() <= 560) {
				menu.setSuper(0, "Haus");
			}
		}
	}

	public String getPageName() {
		return pageName;
	}
}
