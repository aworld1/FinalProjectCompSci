package handlers;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

import graphics.*;
import simpleshapes.Circle;
import simpleshapes.Pentagon;
import simpleshapes.Square;
import simpleshapes.Triangle;
import simpleshapes.X;
import superclasses.*;
import superclasses.Shape;

public class Game {
	protected Player players[];
	private Goal goals[];
	private ArrayList<FieldObject> objs;
	private String[] log;
	private final int LOG_SIZE = 5;
	private GameUI ui;
	private Timer timer;
	protected BufferedImage img;
	protected boolean paused;
	protected boolean someoneDead;
	protected boolean forceClose;
	public Game(GameUI u) {
		ui = u;
		objs = new ArrayList<FieldObject>();
		log = new String[LOG_SIZE];
		log[0] = "Let the game begin!";
		players = new Player[2];
		goals = new Goal[2];
		players[0] = new Player(this, Dimensions.getX() + 100, Dimensions.getY() + (Dimensions.getHeight() / 2), 90);
		players[1] = new Player(this, Dimensions.getX() + Dimensions.getWidth() - 50, Dimensions.getY() + (Dimensions.getHeight() / 2), 270);
		goals[0] = new Goal(Dimensions.getX() + 60, players[0]);
		goals[1] = new Goal(Dimensions.getX() + Dimensions.getWidth() - 20, players[1]);
		this.addObj(players[0].getTarget());
		this.addObj(players[1].getTarget());
		this.addObj(goals[0]);
		this.addObj(goals[1]);
		paused = false; forceClose = false; someoneDead = false;
		img = getUI().readImage("gameback.png");
		ui.setGame(this);
	}
	
	public void addMap(Map m) {
		for (int i = 0; i < m.getObjs().size(); i++) {
			addObj(m.getObjs().get(i));
		}
	}
	
	public void togglePause() {
		if (someoneDead) {
			return;
		}
		if (paused) {
			runGame();
		}
		else {
			stopGame();
		}
		paused = !paused;
	}
	
	public GameUI getUI() {
		return ui;
	}
	
	public void forceClose() {
		forceClose = true;
	}
	
	public void nextFrame() {
		if (forceClose) {
			ui.returnToMenu();
			return;
		}
		ui.clear();
		processCollision();
		draw();
		processObjs();
		processPlayers();
		ui.getBuffer().show();
	}
	
	protected void processPlayers() {
		for (int i = 0; i < players.length; i++) {
			players[i].gainEnergy(1);
			if (players[i].getHealth() <= 0) {
				playerDied(i);
			}
		}
	}
	
	public boolean isSomeoneDead() {
		return someoneDead;
	}
	
	public void playerDied(int playerNo) {
		someoneDead = true;
		if (playerNo == 0) {
			playerNo = 2;
		}
		Graphics g = ui.getG();
		g.setFont(new Font("Helvetica", Font.PLAIN, 40));
		g.setColor(Color.gray);
		g.fillRect(400, 250, 425, 200);
		g.setColor(Color.black);
		g.drawRect(400, 250, 425, 200);
		g.setColor(Color.white);
		g.drawString("Player " + playerNo + " wins!", 500, 360);
		stopGame();
		ui.getBuffer().show();
	}

	public void draw() {
		Graphics g = ui.getG();
		g.setColor(Color.white);
		((Graphics2D) g).setComposite(AlphaComposite.SrcOver.derive((float) 0.5));
		g.drawImage(img, 0,0, ui);
		g.setFont(new Font("Helvetica", Font.PLAIN, 20));
		g.drawString("" + players[0].getEnergy(), 225, 35);
		g.drawString("" + players[0].getHealth(), 340, 35);
		g.drawString("" + players[1].getHealth(), 920, 35);
		g.drawString("" + players[1].getEnergy(), 1010, 35);
		((Graphics2D) g).setComposite(AlphaComposite.SrcOver);
		g.setFont(new Font("Helvetica", Font.PLAIN, 12));
		g.drawRect((int)(Dimensions.getWidth()*0.5-100), Dimensions.getHeight()+80, 300, 30);
		g.drawString(log[0], (int)(Dimensions.getWidth()*0.5315-log[0].length()*2), Dimensions.getHeight()+100);
	}
	
	public void processCollision() {
		FieldObject[] x = new FieldObject[objs.size()];
		for (int i = 0; i < x.length; i++) {
			x[i] = objs.get(i);
		}
		FieldObject thisObj, thatObj, a, b;
		for (int i = 0; i < x.length; i++) {
			for (int j = i; j < x.length; j++) {
				thisObj = x[i];
				thatObj = x[j];
				if (thisObj != thatObj && thisObj.colliding(thatObj)) {
					a = thisObj.evaluate(thatObj,thisObj.compareTo(thatObj));
					b = thatObj.evaluate(thisObj,thatObj.compareTo(thisObj));
					if (a != null) {
						a.removeSelf();
					}
					if (a != b && b != null) {
						b.removeSelf();
					}
				}
			}
		}
	}
	
	public void processObjs() {
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i) != null)
				objs.get(i).process();
		}
	}
	
	public void runGame() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
				nextFrame();
		    }
		},0,40);
	}
	
	public void stopGame() {
		timer.cancel();
		timer.purge();
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public ArrayList<FieldObject> getObjs() {
		return objs;
	}

	public void setObjs(ArrayList<FieldObject> objs) {
		this.objs = objs;
	}
	
	public void addObj(FieldObject s) {
		objs.add(s);
		s.setGame(this);
	}
	
	public void removeObj(int index) {
		if (index >= 0) {
			objs.remove(index);
		}
	}
	
	public void removeObj(FieldObject s) {
		removeObj(getIndexOfObj(s));
	}
	
	public int getIndexOfObj(FieldObject s) {
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i) == s) {
				return i;
			}
		}
		return -1;
	}
	
	public void spawnShapeByPlayer(Shape o, Player p) {
		if (p == players[1]) {
			o.setDirection(180);
		}
		o.setXY(p.getTarget().getX(),p.getTarget().getY());
		o.setOwner(p);
		addObj(o);
	}
	
	public void spawnShapeByPlayerIndex(Shape o, int x) {
		spawnShapeByPlayer(o, players[x]);
	}
	
	public void spawnShape(Shape o) {
		spawnShapeByPlayer(o,o.getOwner());
	}
	
	public void addToLog(String s) {
		for (int i = log.length-1; i > 0; i--) {
			log[i] = log[i-1]; 
		}
		if (log.length > 0) {
			log[0] = s;
		}
	}
	
	public String createDeathSentence(FieldObject a) {
		int x = (int)(Math.random() * 6);
		String s = a.getClass() + "";
		while (s.indexOf(".") != -1) {
			s = s.substring(s.indexOf(".")+1);
		}
		switch (x) {
			case 0:
				s += " has perished";
				break;
			case 1:
				s += " took the L";
				break;
			case 2:
				s += " is to never be seen again";
				break;
			case 3:
				s += " played themselves";
				break;
			case 4:
				s += " had a lovely funeral";
				break;
			case 5:
				s += " was toasted";
				break;
		}
		return s;
	}
	
	public SimpleShape getRandomSimpleShape() {
		int c = (int)(Math.random()*5);
		switch (c) {
		case 0:
			return new Circle(new Player());
		case 1:
			return new X(new Player());
		case 2:
			return new Triangle(new Player());
		case 3:
			return new Square(new Player());
		case 4:
			return new Pentagon(new Player());
		}
		return null;
	}

	public boolean getPause() {
		return paused;
	}
}