package ufc.poo.engine.drawable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class BugPoint extends BugComponentDrawable {
	public BugPoint(int x, int y) {
		super(new Point(x, y), new Dimension(1, 1));
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(borderColor);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		
	}
}
