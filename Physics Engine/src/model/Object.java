package model;

public class Object {
	private int width, height;
	private double mass, xSpeed, ySpeed, x, y;
	protected Platform floor;
	
	public Object() {
		this(0, 0, 0, 0, 10, null);
	}
	
	public Object(int inX, int inY, int inWidth, int inHeight, double inMass, Platform inFloor) {
		x = inX; y = inY; width = inWidth; height = inHeight; mass = inMass;
		floor = inFloor;
		xSpeed = 0;
		ySpeed = 0;
	}
	
	public void setPlatform(Platform inPlatform) {
		floor = inPlatform;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void detachFromPlatform() {
		floor = null;
	}
	
	public final int X() {
		return (int)x;
	}
	
	public final int Y() {
		return (int)y;
	}
	
	public final double XSpeed() {
		return xSpeed;
	}
	
	public final double YSpeed() {
		return ySpeed;
	}
	
	public final int Height() {
		return height;
	}
	
	public final int Width() {
		return width;
	}

	public final double Mass() {
		return mass;
	}
	
	public void collision(double inXSpeed, double inYSpeed, double inMass) {
		xSpeed += (inXSpeed - xSpeed)*inMass/mass;
		ySpeed += (inYSpeed - ySpeed)*inMass/mass;
	}
	
	public void update(long timeStep, int xForce, int yForce, int terminalVelocity) {
		double dTimeStep = timeStep;
		if(floor == null) {
			x += xSpeed*dTimeStep/100d + Math.pow(xForce*dTimeStep/100d, 2)/2;
			xSpeed += xForce*dTimeStep/100d;
			y += ySpeed*dTimeStep/100d + Math.pow(yForce*dTimeStep/100d, 2)/2;
			ySpeed += yForce*dTimeStep/100d;
			ySpeed = Math.min(ySpeed, terminalVelocity);
		}
		else {
			y = floor.Y() - height;
			ySpeed = 0;
			x += xSpeed*dTimeStep/100d + Math.pow((xForce)*dTimeStep/100d, 2)/2;
			xSpeed += xForce*dTimeStep/100d;
			if (floor.X() > x + width || floor.X() + floor.Width() < x)
				floor = null;
		}
	}
}
