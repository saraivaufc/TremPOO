package ufc.poo.engine.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ufc.poo.engine.drawable.BugDrawable;
import ufc.poo.engine.drawable.BugRect;

public class BugWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	JFrame window;
	String nome;
	Dimension size;
	private int framerrate;
	Color backgroundColor;
	
	BufferedImage buffer;
	
	List<KeyEvent> bufferKeyPressed;
	List<MouseEvent> bufferMouseCliked;
	
	public BugWindow() {
		nome = "BugWindow";
		size = new Dimension(640, 480);
		createWindow();
	}
	
	public BugWindow(int w, int h, String nome) {
		this.nome = nome;
		size = new Dimension(w, h);
		createWindow();
	}
	
	private void createWindow() {
		framerrate = 15;
		buffer = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		
		bufferKeyPressed = new Vector<KeyEvent>();
		bufferMouseCliked = new Vector<MouseEvent>();
		
		window = new JFrame(nome);
		window.setSize(size);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setContentPane(this);
		setBackground(Color.WHITE);
		setSize(size);
		window.addKeyListener(new MyKeyListener());
		window.addMouseListener(new MyMouseListener());
	}
	
	public void paint(BugDrawable d) {
		d.paint(buffer.getGraphics());
	}
	
	public void paint(List<BugDrawable> ds) {
		for(BugDrawable d: ds)
			d.paint(buffer.getGraphics());
	}
	
	public void paintAll() {
		Graphics g = getGraphics();
		
		g.drawImage(buffer, 0, 0, null);
		
		try {
			Thread.sleep(1000/framerrate);
		} catch (InterruptedException e) {e.printStackTrace();}
		
	}
	
	public void setFramerate(int f) {
		framerrate = f;
	}
	
	public void clear() {
		buffer.getGraphics().setColor(Color.WHITE);
		paint(new BugRect(new Point(0, 0),  size));
	}
	
	public void clear(Color c) {
		BugRect r = new BugRect(new Point(0, 0),  size);
		r.setFillColor(c);
		paint(r);
	}
	
	public boolean isKeyPressed() {
		return bufferKeyPressed.size() > 0;
	}
	
	public KeyEvent getKeyPressed() {
		KeyEvent e = bufferKeyPressed.get(bufferKeyPressed.size() - 1);
		bufferKeyPressed.clear();
		return e;
	}
	
	public boolean isMouseClicked() {
		return bufferMouseCliked.size() > 0;
	}
	
	public MouseEvent getMouseClicked() {
		MouseEvent e = bufferMouseCliked.get(bufferMouseCliked.size() - 1);
		bufferMouseCliked.clear();
		return e;
	}
	
	@Override
	public void paintAll(Graphics g) {

	}
	
	@Override
	public void paint(Graphics g) {
		
	}
	
	@Override
	public void repaint() {
		
	}
	
	private class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			bufferKeyPressed.add(0, e);
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			bufferMouseCliked.add(0, e);
		}
		
	}
}
