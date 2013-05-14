package physicsEngine;

import java.util.LinkedList;

import listeners.LandingListener;
import listeners.WallCollisionListener;
import model.Model;

public class PhysicsEngine extends Thread {	
	private Model model;
	private boolean stillPlaying = true;
	private long lastTime;
	
	public PhysicsEngine() {
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void setGravity(int gravity) {
		model.setGravity(gravity);
	}
	
	public void setTerminalVelocity(int terminalVelocity) {
		model.setTerminalVelocity(terminalVelocity);
	}
	
	public void addPlatform(model.Platform inPlatform) {
		model.addPlatform(inPlatform);
	}
	
	public final LinkedList<model.Platform> getPlatforms() {
		return model.getPlatforms();
	}
	
	public void addWall(model.Wall inWall) {
		model.addWall(inWall);
	}
	
	public final LinkedList<model.Wall> getWalls() {
		return model.getWalls();
	}
	
	public void addObject(model.Object inObject) {
		model.addObject(inObject);
	}
	
	public final LinkedList<model.Object> getObjects() {
		return model.getObjects();
	}
	
	public void addLandingListener(LandingListener listener) {
		model.addLandingListener(listener);
	}
	
	public void addWallCollisionListener(WallCollisionListener listener) {
		model.addWallCollisionListener(listener);
	}
	
	public void quit() {
		stillPlaying = false;
	}
	
	@Override
	public void run() {
		super.run();
		lastTime = System.currentTimeMillis();
		while(stillPlaying) {
			try {
				sleep(1);
				long currentTime = System.currentTimeMillis();
				long timeStep = currentTime - lastTime;
				model.update(timeStep);
				lastTime = currentTime;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
