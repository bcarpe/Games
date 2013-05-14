package model;

public class Platform{
	private int x, y, width;
	
	public Platform() {
		this(0, 0, 0);
	}
	
	public Platform(int inX, int inY, int inWidth) {
		x = inX; y = inY; width = inWidth;
	}
	
	public final int X() {
		return x;
	}
	
	public final int Y() {
		return y;
	}
	
	public final int Width() {
		return width;
	}
	
	public void update(long timeStep) {
		//totalTime += timeStep;
	}
}
