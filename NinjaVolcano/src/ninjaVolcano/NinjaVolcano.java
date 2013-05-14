package ninjaVolcano;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import java.util.LinkedList;

import modelNV.ModelNV;
import modelNV.ObjectNV;
import modelNV.PlatformNV;
import modelNV.WallNV;

import keyboardController.KeyboardController;

import physicsEngine.*;
import utilities.MapLoader;
import view.View;
import viewNV.ViewBackgroundNV;

public class NinjaVolcano extends JFrame implements KeyListener {
	private static final long serialVersionUID = -8825243904521775077L;
	public static JFrame windowFrame;
	public static PhysicsEngine physicsEngine;
	public static NinjaVolcano window;
	public static View view;
	public static LinkedList<ObjectNV> objects;
	public static LinkedList<PlatformNV> platforms;
	public static LinkedList<WallNV> walls;
	public static LinkedList<WallNV> walls2;
	
	public static void main(String[] args) {
		//1. Create the frame.
		window = new NinjaVolcano();
		windowFrame = new JFrame("Ninja Volcano");
		windowFrame.addKeyListener(window);
		view = new View();
		
		//2. initialize GameState
		GameState.player = null;
		GameState.victoryPlatform = null;
		GameState.stillPlaying = true;
		GameState.controller = new KeyboardController();
		GameState.victory = false;
		windowFrame.addKeyListener(GameState.controller);
		
		//3. Optional: What happens when the frame closes?
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//4. Create components and put them in the frame.
		initPhysicsEngine();
		windowFrame.getContentPane().add(view, BorderLayout.CENTER);

		//5. Size the frame.
		windowFrame.setBounds(283, 144, 800, 480);

		//6. Show it.
		windowFrame.setUndecorated(true);
		windowFrame.setVisible(true);
		
		//7. Get Physics Engine Going
		physicsEngine.start();
		
		//8. Start updating view
		while(GameState.stillPlaying) {
			try {
				Thread.sleep(20);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void initPhysicsEngine() {
		physicsEngine = new PhysicsEngine();
		ModelNV model = new ModelNV(view);
		physicsEngine.setModel(model);
		physicsEngine.addLandingListener(model);
		physicsEngine.addWallCollisionListener(model);
		view.resetBackground(new ViewBackgroundNV());
		view.setBackgroundImage("images/lava.jpg");
		MapLoader.loadMap("maps/testMap.xml", physicsEngine, view);
	}
	
	private static void update() {
		view.setScreenTopLeft(GameState.player.Y() - view.getHeight()*2/3, GameState.player.X() + GameState.player.Width()/2 - view.getWidth()/2);
		view.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			physicsEngine.quit();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(windowFrame, WindowEvent.WINDOW_CLOSING));
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
