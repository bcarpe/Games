package view;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class ViewPlatform {
	protected int x, y, width;
	protected static int height = 10;
	protected static ImageIcon image = null;
	
	public ViewPlatform(int inX, int inY, int inWidth) {
		x = inX; y = inY; width = inWidth;
	}
	
	public static void loadImage(String imageName) {
		image = new ImageIcon("images/" + imageName);
	}
	
	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		if(image != null) {
			g2d.drawImage(image.getImage(), x - screenLeft, y - screenTop, null);
		} else {
			g2d.setColor(Color.blue);
			g2d.fillRect(x - screenLeft, y - screenTop, width, height);
		}
	}
}
