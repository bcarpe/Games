package model;

public class Wall {
	private int x, y, height;
	private boolean facingLeft;
	
	public Wall() {
		this(0, 0, 0, true);
	}
	
	public Wall(int inX, int inY, int inHeight, boolean inFacingLeft) {
		x = inX; y = inY; height = inHeight; facingLeft = inFacingLeft;
	}
	
	public final int X() {
		return x;
	}
	
	public final int Y() {
		return y;
	}
	
	public final int Height() {
		return height;
	}
	
	public final boolean FacingLeft() {
		return facingLeft;
	}
	
	public final boolean FacingRight() {
		return !facingLeft;
	}
	
	public void update(long timeStep) {
		//totalTime += timeStep;
	}
}
