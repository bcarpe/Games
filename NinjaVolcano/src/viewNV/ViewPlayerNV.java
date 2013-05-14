package viewNV;

import java.awt.Color;
import java.awt.Graphics2D;

import view.ViewObject;

public class ViewPlayerNV extends ViewObject {

	public ViewPlayerNV(int inX, int inY, int inWidth, int inHeight) {
		super(inX, inY, inWidth, inHeight);
	}

	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		//g2d.setColor(Color.black);
		//g2d.fillRect(x - screenLeft, y - screenTop, width, height);
		//g2d.setColor(Color.red);
		//g2d.fillRect(x - screenLeft, y - screenTop + height/4, width, height/4);
		g2d.setColor(Color.black);
		g2d.fillRect(g2d.getClipBounds().width/2 - width/2, g2d.getClipBounds().height*2/3, width, height);
	}
}
