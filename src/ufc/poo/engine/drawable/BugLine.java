package ufc.poo.engine.drawable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class BugLine extends BugComponentDrawable {
	int x2, y2;
	public BugLine(int x, int y, int x2, int y2) {
		super(new Point(x, y), new Dimension(0, 0));
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public BugLine(Point pos, Dimension d) {
		super(pos, d);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(borderColor);
		g.drawLine(getX(), getY(), x2, y2);
	}
}
