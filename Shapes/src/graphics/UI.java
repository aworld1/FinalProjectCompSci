package graphics;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.JFrame;

import handlers.Game;
public class UI extends Canvas implements Runnable, KeyListener {
	private static final long serialVersionUID = 2664539955261714283L;
	private Graphics g;
	private BufferStrategy bs;
	private Window window;
	private Game game;
	public UI() {
		window = new Window(700,1200,"",this);
		run();
		addKeyListener(this);
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		JFrame frame = new JFrame("");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		g.dispose();
		bs.show();
	}

	public BufferStrategy getBuffer() {
		return this.getBufferStrategy();
	}

	public void setBuffer(BufferStrategy s) {
		this.bs = s;
	}

	public Graphics getG() {
		return this.getBufferStrategy().getDrawGraphics();
	}

	public void setG(Graphics g) {
		this.g = g;
	}
	
	public void clear() {
		this.getG().setColor(Color.decode("#FFFFFF"));
		this.getG().fillRect(0, 0, 10000, 10000);
	}
	
	public BufferedImage rotate(BufferedImage image, double angle) {
		angle = Math.toRadians(angle);
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
	    GraphicsConfiguration gc = getGraphicsConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww - w) / 2, (newh - h) / 2);
	    g.rotate(angle, w / 2, h / 2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	}
	
	public void drawPolygon(Color color, int sides, int x, int y, double radius, double rotation) {
		Graphics g = getG();
		g.setColor(color);
		int xVals[] = new int[sides + 1];
		int yVals[] = new int[sides + 1];
		for (int i = 0; i < sides + 1; i++) {
			xVals[i] = (int) (Math.cos(Math.toRadians(rotation + i*(360/sides))) * radius) + x;
			yVals[i] = (int) (Math.sin(Math.toRadians(rotation + i*(360/sides))) * radius) + y;
		}
		g.drawPolygon(xVals,yVals,sides + 1);
	}
	
	public Window getWindow() {
		return window;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}