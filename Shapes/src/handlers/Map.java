package handlers;

import java.util.*;
import graphics.*;
import superclasses.*;

public class Map {
	private ArrayList<FieldObject> objs;
	private String mapName;
	public Map(ArrayList<FieldObject> arr, String mapN) {
		objs = arr;
		setMapName(mapN);
	}
	public Map() {
		objs = new ArrayList<FieldObject>();
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
	public String getMapName() {
		return mapName;
	}
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
}