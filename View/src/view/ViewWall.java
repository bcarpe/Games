package view;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class ViewWall {
	protected int x, y, height;
	protected static ImageIcon image;
	
	public ViewWall(int inX, int inY, int inHeight) {
		x = inX; y = inY; height = inHeight;
	}
	
	public void update(int inX, int inY, int inHeight) {
		x = inX; y = inY; height = inHeight;
	}
	
	public static void loadImage(String imageName) {
		image = new ImageIcon("images/" + imageName);
	}
	
	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		if(image != null) {
			g2d.drawImage(image.getImage(), x - screenLeft, y - screenTop, null);
		} else {
			g2d.setColor(Color.black);
			g2d.fillRect(x - screenLeft, y - screenTop, 1, height);
		}
	}
}
