package viewNV;

import java.awt.Color;
import java.awt.Graphics2D;

import view.ViewWall;

public class ViewWallNV extends ViewWall {

	public ViewWallNV(int inX, int inY, int inHeight) {
		super(inX, inY, inHeight);
	}
	
	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		g2d.setColor(Color.black);
		g2d.fillRect(x - screenLeft, y - screenTop, 1, height);
	}

}
