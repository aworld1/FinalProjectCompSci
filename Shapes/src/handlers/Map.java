package handlers;

import java.util.*;
import graphics.*;
import superclasses.*;

public class Map {
	private ArrayList<FieldObject> objs;
	public Map(ArrayList<FieldObject> arr) {
		objs = arr;
	}
	public void initMap() {
		Game game = new Game(new GameUI());
		for (int i = 0; i < objs.size(); i++) {
			game.addObj(objs.get(i));
		}
	}
	public ArrayList<FieldObject> getObjs() {
		return objs;
	}
}
