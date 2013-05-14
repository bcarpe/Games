package controls;

public class Controller {
	
	Controllable controllable;
	protected boolean leftState = false, rightState = false, upState = false, downState = false;
	
	public Controller() {	}
	
	public void attachControllable(Controllable controllable) {
		this.controllable = controllable;
	}
	
	protected void triggerUp() {
		upState = true;
		controllable.triggeredUp();
	}
	
	protected void triggerDown() {
		downState = true;
		controllable.triggeredUp();
	}
	
	protected void triggerLeft() {
		leftState = true;
		controllable.triggeredLeft();
	}
	
	protected void triggerRight() {
		rightState = true;
		controllable.triggeredRight();
	}
	
	protected void releaseUp() {
		upState = false;
		controllable.releasedUp();
	}
	
	protected void releaseDown() {
		downState = false;
		controllable.releasedDown();
	}
	
	protected void releaseLeft() {
		leftState = false;
		controllable.releasedLeft();
	}
	
	protected void releaseRight() {
		rightState = false;
		controllable.releasedRight();
	}
}
