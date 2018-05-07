package supershapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import handlers.Player;
import superclasses.GiantShape;

public class Octagon extends GiantShape {

	public Octagon(Player o) {
		super(o, 8);
		speed = 2;
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("octagon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, 90+(rotation));
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius), null);
		g.setColor(Color.decode("#7F3F98"));
		g.setFont(new Font("Helvetica", Font.PLAIN, 18)); 
		g.drawString("" + giantLife,x-5,y+6);
	}
}
