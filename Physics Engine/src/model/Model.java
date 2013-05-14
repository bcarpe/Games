package model;

import java.util.LinkedList;

import listeners.LandingListener;
import listeners.WallCollisionListener;

public class Model {
	private LinkedList<Platform> platforms = new LinkedList<Platform>();
	private LinkedList<Wall> walls = new LinkedList<Wall>();
	private LinkedList<Object> objects = new LinkedList<Object>();
	private LinkedList<LandingListener> landingListeners = new LinkedList<LandingListener>();
	private LinkedList<WallCollisionListener> wallCollisionListeners = new LinkedList<WallCollisionListener>();
	private int gravity;
	private int terminalVelocity;
	
	public Model() {
	}
	
	public void setGravity(int inGravity) {
		gravity = inGravity;
	}
	
	public void setTerminalVelocity(int inTerminalVelocity) {
		terminalVelocity = inTerminalVelocity;
	}
	
	public void addPlatform(Platform inPlatform) {
		platforms.add(inPlatform);
	}
	
	public void addPlatforms(LinkedList<Platform> inPlatforms) {
		platforms.addAll(inPlatforms);
	}
	
	public final LinkedList<Platform> getPlatforms() {
		return platforms;
	}
	
	public void addWall(Wall inWall) {
		walls.add(inWall);
	}
	
	public void addWalls(LinkedList<Wall> inWalls) {
		walls.addAll(inWalls);
	}
	
	public final LinkedList<Wall> getWalls() {
		return walls;
	}
	
	public void addObject(Object inObject) {
		objects.add(inObject);
	}
	
	public void addObjects(LinkedList<Object> inObjects) {
		objects.addAll(inObjects);
	}
	
	public final LinkedList<Object> getObjects() {
		return objects;
	}
	
	public void addLandingListener(LandingListener listener) {
		landingListeners.add(listener);
	}
	
	public void addWallCollisionListener(WallCollisionListener listener) {
		wallCollisionListeners.add(listener);
	}
	
	public static boolean detectLanding(Platform platform, Object object) {
		return 
			object.X() < platform.X() + platform.Width() && 
			object.X() + object.Width() > platform.X() &&
			object.Y() + object.Height() > platform.Y() &&
			object.Y() < platform.Y() && 
			object.YSpeed() > 0;
	}
	
	public static boolean detectWallCollision(Wall wall, Object object) {
		return 
			object.X() < wall.X() && 
			object.X() + object.Width() > wall.X() &&
			object.Y() + object.Height() > wall.Y() &&
			object.Y() < wall.Y() + wall.Height() &&
			((wall.FacingLeft() && object.XSpeed() > 0) ||
			(wall.FacingRight() && object.XSpeed() < 0));
	}
	
	public void update(long timeStep) {
		for (Platform platform : platforms) {
			platform.update(timeStep);
		}
		for (Wall wall : walls) {
			wall.update(timeStep);
		}
		for (Object object : objects) {
			object.update(timeStep, 0, gravity, terminalVelocity);
		}
		for (Platform platform : platforms) {
			for (Object object : objects) {
				if (detectLanding(platform, object)) {
					object.setPlatform(platform);
					for (LandingListener listener : landingListeners) {
						listener.landingDetected(platform, object);
					}
				}
			}
		}
		for (Wall wall : walls) {
			for (Object object : objects) {
				if (detectWallCollision(wall, object)) {
					if(wall.FacingLeft())
						object.setX(wall.X() - object.Width());
					else if(wall.FacingRight())
						object.setX(wall.X() + 1);
					object.setXSpeed(0);
					for (WallCollisionListener listener : wallCollisionListeners) {
						listener.wallCollisionDetected(wall, object);
					}
				}
			}
		}
	}
}
