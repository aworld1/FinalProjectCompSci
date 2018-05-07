package graphics;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;
	public Window(int h, int w, String title, UI u) {
		u.setPreferredSize(new Dimension(w, h));
		u.setMinimumSize(new Dimension(w, h));
		u.setMaximumSize(new Dimension(w, h));
		
		frame = new JFrame(title);
		frame.add(u);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}