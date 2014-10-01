package ufc.poo.engine.drawable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class BugEllipse extends BugComponentDrawable {

	public BugEllipse(Point pos, Dimension d) {
		super(pos, d);
	}
	
	public BugEllipse(int x, int y, int w, int h) {
		super(new Point(x, y), new Dimension(w, h));
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(getX(), getY(), getWidth(), getHeight());
		
		g.setColor(borderColor);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}

}
