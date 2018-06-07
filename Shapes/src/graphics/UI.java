package graphics;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;
public abstract class UI extends Canvas implements Runnable, KeyListener, MouseListener {
	protected static final long serialVersionUID = 2664539955261714283L;
	protected Graphics g;
	protected BufferStrategy bs;
	protected Window window;
	public UI() {
		window = new Window(1200,700,this);
		run();
	}
	
	public UI(Window window) {
		this.window = window;
		window.init(this);
		run();
	}
	
	public UI(boolean window) {
		super();
		run();
	}

	@Override
	public void run() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
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
		if (getGraphicsConfiguration() == null) {
			return image;
		}
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
	
	public void draw(BufferedImage img, int rotation, int x, int y, int width, int height) {
		img = rotate(img, rotation);
		getG().drawImage(img, x, y, width, height, null);
	}
	
	public Window getWindow() {
		return window;
	}
	
	public BufferedImage readImage(String imgName) {
		ClassLoader cldr = getClass().getClassLoader();
		BufferedImage img = null;
		try {
			img = ImageIO.read(cldr.getResource("icons/" + imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}