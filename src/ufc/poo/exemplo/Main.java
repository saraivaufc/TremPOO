package ufc.poo.exemplo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import ufc.poo.engine.drawable.BugEllipse;
import ufc.poo.engine.drawable.BugImage;
import ufc.poo.engine.drawable.BugText;
import ufc.poo.engine.view.BugWindow;


public class Main {
	
	public static void main(String[] args) {
		BugWindow win = new BugWindow();
		win.setFramerate(30);
		
		BugText title = new BugText("Bug", 10, 50, 50);
		
		BugEllipse ellipse = new BugEllipse(100, 100, 50, 50);
		ellipse.setFillColor(Color.YELLOW);
		
		
		BugImage i = new BugImage("cacto.png", 0, 0, 100, 100);
		
		int xr = 200, yr = 200; //Ponto de referencia
		
		while(true) {
			win.clear();
			win.paint(title);
			win.paint(ellipse);
			win.paint(i);
			win.paintAll();
			
			ellipse.moveToBounce(xr, yr);
			//ellipse.moveToLinear(xr, yr, 10);
			//ellipse.moveToLog(xr, yr);
			
			if(win.isMouseClicked()) {
				MouseEvent e = win.getMouseClicked();
				xr = e.getX();
				yr = e.getY();
			}
		}
	}
}
