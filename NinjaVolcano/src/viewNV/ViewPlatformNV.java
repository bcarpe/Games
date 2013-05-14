package viewNV;

import java.awt.Color;
import java.awt.Graphics2D;

import view.ViewPlatform;

public class ViewPlatformNV extends ViewPlatform {

	public ViewPlatformNV(int inX, int inY, int inWidth) {
		super(inX, inY, inWidth);
	}
	
	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		g2d.setColor(Color.black);
		g2d.fillRect(x - screenLeft, y - screenTop, width, height*2);
	}
}
