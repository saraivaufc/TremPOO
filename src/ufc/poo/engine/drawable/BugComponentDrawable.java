package ufc.poo.engine.drawable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class BugComponentDrawable implements BugDrawable {
	Point pos;
	Point dest;
	Dimension size;
	Color fillColor;
	Color borderColor;
	int penWidth;
	
	double defaultAscel;
	double ascelX;
	double ascelY;
	double defaultSpeed;
	double speedX;
	double speedY;
	double atrito;
	
	public BugComponentDrawable(Point pos, Dimension d) {
		this.pos = this.dest = pos;
		this.size = d;
		penWidth = 0;
		
		borderColor = Color.BLACK;
		fillColor = Color.WHITE;
		
		speedX = speedY = defaultSpeed = 0;
		atrito = Constants.DEFAULT_ATRITO;
	}
	
	public void moveToBounce(double x, double y) {
		dest = new Point((int)x, (int)y);
		
		defaultAscel = Constants.DEFAULT_GRAVITY/10;
		
		for(int i = 0; i < 10; i++) {
			double W = dest.getX() - pos.getX();
			double H = dest.getY() - pos.getY();
			
			double D = Math.sqrt( Math.pow(W, 2) + Math.pow(H, 2) );
			
			if(D < 0.000001) D = 0.000001;
			
			ascelX = W*defaultAscel/D;
			ascelY = H*defaultAscel/D;
			
			speedX = speedX + ascelX;
			speedY = speedY + ascelY;
			
			double xp = speedX + ascelX/2;
			double yp = speedY + ascelY/2;
			
			moveWith(xp, yp);
			
			speedX *= atrito;
			speedY *= atrito;
		}
	}
	
	public void moveToLinear(double x, double y, double vel) {
		dest = new Point((int)x, (int)y);
		
		defaultSpeed = vel;
		uptateSpeeds();
		
		int dist = Math.abs((int) dest.distance(pos));
		if(dist <= defaultSpeed) {
			pos = dest.getLocation();
		} else {
			moveWith(speedX, speedY);
		}
	}
	
	public void moveToLog(double x, double y) {
		double xp = x - pos.getX();
		double yp = y - pos.getY();
		
		xp /= 2;
		yp /= 2;
		
		moveWith(xp, yp);
	}
	
	private void uptateSpeeds() {
		double W = dest.getX() - pos.getX();
		double H = dest.getY() - pos.getY();
		
		double D = Math.sqrt( Math.pow(W, 2) + Math.pow(H, 2) );
		
		if(D < 0.0000001)
			D = 0.0000001;
		
		speedX = W*defaultSpeed/D;
		speedY = H*defaultSpeed/D;
	}
	
	public void moveWith(double xp, double yp) {
		pos.setLocation(pos.getX() + xp, getY() + yp);
	}
	
	public Rectangle toRect() {
		return new Rectangle(pos, size);
	}
	
	public void setFillColor(Color c) {
		this.fillColor = c;
	}
	
	public void setBorderColor(Color c) {
		this.borderColor = c;
	}
	
	void setWidthPen(int w) {
		this.penWidth = w;
	}

	void setPos(int x, int y) {
		pos.setLocation(x, y);
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}
	
	public Point getPos() {
		return pos;
	}
	
	public int getX() {
		return pos.x;
	}

	public int getY() {
		return pos.y;
	}
	
	public void setSize(int width, int height) {
		size.setSize(width, height);
	}
	
	public int getWidth() {
		return size.width;
	}
	
	public int getHeight() {
		return size.height;
	}
}
