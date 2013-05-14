package modelNV;

import viewNV.ViewWallNV;
import model.Wall;

public class WallNV extends Wall {
	
	private view.ViewWall viewWall;
	
	public WallNV(int inX, int inY, int inHeight, boolean inFacingLeft) {
		super(inX, inY, inHeight, inFacingLeft);
		viewWall = new ViewWallNV(inX, inY, inHeight);
	}
	
	public final view.ViewWall getViewWall() {
		return viewWall;
	}
}
