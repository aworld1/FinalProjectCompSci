package handlers;

import graphics.GameUI;

public class AIGame extends Game {

	public AIGame(GameUI u) {
		super(u);
		u.disablePlayerTwo();
	}
	
	public void processPlayers() {
		super.processPlayers();
		processAI();
	}

	private void processAI() {
		Player ai = players[1];
		int percentChance = 0;
		percentChance -= ai.getHealth() * 6;
		percentChance += ai.getEnergy();
		percentChance += getObjs().size();
		if (Math.random() * 100 < percentChance) {
			ai.getInventory((int)(Math.random() * 6)).use(this);
		}
	}
}
