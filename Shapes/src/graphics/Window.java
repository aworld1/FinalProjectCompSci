package graphics;
import java.awt.*;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;
	public Window(int w, int h, UI u) {
		u.setPreferredSize(new Dimension(w, h));
		u.setMinimumSize(new Dimension(w, h));
		u.setMaximumSize(new Dimension(w, h));
		frame = new JFrame("");
		init(u);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void init(UI u) {
		u.addKeyListener(u);
		u.addMouseListener(u);
		frame.add(u);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(1250, 750));
		frame.toFront();
		frame.requestFocus();
	}
}