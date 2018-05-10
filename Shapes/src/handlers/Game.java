package handlers;
import java.awt.*;
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
	private Player players[];
	private Goal goals[];
	private ArrayList<FieldObject> objs;
	private String[] log;
	private final int LOG_SIZE = 5;
	private UI ui;
	public Game(UI u) {
		ui = u;
		objs = new ArrayList<FieldObject>();
		log = new String[LOG_SIZE];
		players = new Player[2];
		goals = new Goal[2];
		players[0] = new Player(Dimensions.getX() + 100, Dimensions.getY() + (Dimensions.getHeight() / 2), 90);
		players[1] = new Player(Dimensions.getX() + Dimensions.getWidth() - 100, Dimensions.getY() + (Dimensions.getHeight() / 2), 270);
		goals[0] = new Goal(Dimensions.getX() + 60);
		goals[1] = new Goal(Dimensions.getX() + Dimensions.getWidth() - 60);
		this.addObj(players[0].getTarget());
		this.addObj(players[1].getTarget());
		this.addObj(goals[0]);
		this.addObj(goals[1]);
	}
	
	public UI getUI() {
		return ui;
	}
	
	public void nextFrame() {
		ui.clear();
		processCollision();
		processObjs();
		draw();
		ui.getBuffer().show();
	}
	
	public void draw() {
		Graphics g = ui.getG();
		g.setColor(Color.white);
		g.drawRect(Dimensions.getX(), Dimensions.getY(), Dimensions.getWidth(), Dimensions.getHeight());
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
			objs.get(i).process();
		}
	}
	
	public void runGame() {
		new Timer().scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
				nextFrame();
		    }
		},0,40);
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public String getShapesString() {
		// For debugging purposes
		String x = "";
		for (int i = 0; i < objs.size(); i++) {
			if (objs.get(i) instanceof Shape)
			x += "Shape " + i + " Value: " + ((Shape)objs.get(i)).getValue() + 
					" Loc: " + ((Shape)objs.get(i)).getLoc() + "\n";
		}
		return x;
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
}
