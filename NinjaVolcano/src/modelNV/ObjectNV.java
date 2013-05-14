package modelNV;

import model.Platform;

public class ObjectNV extends model.Object {
	
	protected view.ViewObject viewObject;
	
	public ObjectNV(int inX, int inY, int inWidth, int inHeight, double inMass, Platform inFloor) {
		super(inX, inY, inWidth, inHeight, inMass, inFloor);
		viewObject = new view.ViewObject(inX, inY, inWidth, inHeight);
	}
	
	public final view.ViewObject getViewObject() {
		return viewObject;
	}
	
	@Override
	public void update(long timeStep, int xForce, int yForce, int terminalVelocity) {
		super.update(timeStep, xForce, yForce, terminalVelocity);
		viewObject.update(X(), Y(), Width(), Height());
	}
}
