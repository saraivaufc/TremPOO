package ufc.poo.engine.drawable;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class BugText extends BugComponentDrawable {
	private String text;
	
	public BugText(String t, int x, int y) {
		super(new Point(x, y), new Dimension(30, 30));
		text = t;
	}
	
	public BugText(String t, int x, int y, int size) {
		super(new Point(x, y), new Dimension(size, size));
		text = t;
	}

	void setSize(int size) {
		super.setSize(size, size);
	}
	
	void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(borderColor);
		g.setFont(new Font("Ubuntu", 1, getHeight()));
		g.drawString(text, getX(), getY());
	}

}
