package ufc.poo.engine.drawable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class BugImage extends BugComponentDrawable {
	ImageIcon image;
	
	public BugImage(String path, Point pos, Dimension d) {
		super(pos, d);
		image = new ImageIcon(path);
	}
	
	public BugImage(String path, int x, int y, int w, int h) {
		super(new Point(x, y), new Dimension(w, h));
		image = new ImageIcon(getClass().getResource(path));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image.getImage(), getX(), getY(), getWidth(), getHeight(), null);
		
	}

}
