package modelNV;

import viewNV.ViewPlayerNV;
import controls.Controllable;
import model.Platform;

public class PlayerNV extends ObjectNV implements Controllable {
	int jumpVelocity = 90;
	int speed = 50;
	boolean leftState = false, rightState = false, upState = false, downState = false;
	
	public PlayerNV(int inX, int inY, int inWidth, int inHeight, double inMass, Platform inFloor) {
		super(inX, inY, inWidth, inHeight, inMass, inFloor);
		viewObject = new ViewPlayerNV(inX, inY, inWidth, inHeight);
	}
	
	public void jump() {
		detachFromPlatform();
		setYSpeed(-jumpVelocity);
	}
	
	public void runLeft() {
		setXSpeed(-speed);
	}
	
	public void runRight() {
		setXSpeed(speed);
	}
	
	public void stopRunning() {
		setXSpeed(0);
	}
	
	@Override
	public void update(long timeStep, int xForce, int yForce, int terminalVelocity) {
		super.update(timeStep, xForce, yForce, terminalVelocity);
		if (upState && floor != null)
			jump();
	}

	@Override
	public void triggeredUp() {
		upState = true;
		if (floor != null)
			jump();
	}

	@Override
	public void triggeredDown() {
		downState = true;
	}

	@Override
	public void triggeredLeft() {
		leftState = true;
		if (rightState)
			stopRunning();
		else
			runLeft();
	}

	@Override
	public void triggeredRight() {
		rightState = true;
		if (leftState)
			stopRunning();
		else
			runRight();
	}

	@Override
	public void releasedUp() {
		upState = false;
	}

	@Override
	public void releasedDown() {
		downState = false;
	}

	@Override
	public void releasedLeft() {
		leftState = false;
		if (rightState)
			runRight();
		else
			stopRunning();
	}

	@Override
	public void releasedRight() {
		rightState = false;
		if (leftState)
			runLeft();
		else
			stopRunning();
	}
}
