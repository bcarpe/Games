package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

import view.ViewPlatform;

public class View extends JPanel{
	private static final long serialVersionUID = 2118299654730994785L;
	LinkedList<ViewPlatform> platforms = new LinkedList<ViewPlatform>();
	LinkedList<ViewWall> walls = new LinkedList<ViewWall>();
	LinkedList<ViewObject> objects = new LinkedList<ViewObject>();
	LinkedList<ViewDialogBox> dialogBoxes = new LinkedList<ViewDialogBox>();
	ViewBackground background = new ViewBackground();
	private int screenLeft, screenTop;
	
	public View() {
		screenLeft = 0; screenTop = 0;
	}
	
	public void setScreenTopLeft(int screenTop, int screenLeft) {
		this.screenTop = screenTop;
		this.screenLeft = screenLeft;
	}
	
	public void addPlatform(ViewPlatform inPlatform) {
		platforms.add(inPlatform);
	}
	
	public void removePlatform(ViewPlatform victimPlatform) {
		platforms.remove(victimPlatform);
	}
	
	public void addWall(ViewWall inWall) {
		walls.add(inWall);
	}
	
	public void removeWall(ViewWall victimWall) {
		walls.remove(victimWall);
	}
	
	public void addObject(ViewObject inObject) {
		objects.add(inObject);
	}
	
	public void removeObject(ViewObject victimObject) {
		objects.remove(victimObject);
	}
	
	public void addDialogBox(ViewDialogBox inDialogBox) {
		dialogBoxes.add(inDialogBox);
	}
	
	public void removeDialogBox(ViewDialogBox victimDialogBox) {
		dialogBoxes.remove(victimDialogBox);
	}
	
	public void resetBackground(ViewBackground newBackground) {
		background = newBackground;
	}
	
	public void clear() {
		platforms.clear();
		objects.clear();
		walls.clear();
	}
	
	public void setBackgroundImage(String imageLocation) {
		background.loadImage(imageLocation);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		background.draw(g2d,  screenTop, screenLeft);
		
		for (ViewPlatform platform : platforms) {
			platform.draw(g2d, screenTop, screenLeft);
		}
		for (ViewObject object : objects) {
			object.draw(g2d, screenTop, screenLeft);
		}
		for (ViewWall object : walls) {
			object.draw(g2d, screenTop, screenLeft);
		}
		for (ViewDialogBox dialogBox : dialogBoxes) {
			dialogBox.draw(g2d);
		}
	}
}
