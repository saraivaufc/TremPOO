package ufc.poo.engine.drawable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class BugRect extends BugComponentDrawable {

	public BugRect(int x, int y, int w, int h) {
		super(new Point(x, y), new Dimension(w, h));
	}
	
	public BugRect(Point pos, Dimension d) {
		super(pos, d);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(fillColor);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
		g.setColor(borderColor);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}

}
