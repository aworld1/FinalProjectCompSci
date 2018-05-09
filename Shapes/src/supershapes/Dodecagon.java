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

public class Dodecagon extends GiantShape {

	public Dodecagon(Player o) {
		super(o, 12);
		speed = 1.5;
		imgName = "dodecagon.png";
	}
	
	public void draw() {
		Graphics g = myGame.getUI().getG();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = myGame.getUI().rotate(img, 90+(rotation));
		g.drawImage(img, (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius), null);
		g.setColor(Color.decode("#2E3192"));
		g.setFont(new Font("Helvetica", Font.PLAIN, 20));
		if (giantLife >= 10) {
			g.drawString("+",x-6,y+7);
		}
		else {
			g.drawString("" + giantLife,x-5,y+7);
		}
	}
}
