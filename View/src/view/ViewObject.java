package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ViewObject {
	protected int x, y, width, height;
	protected Map<String, ImageIcon> images;
	protected ImageIcon currentImage = null;
	
	public ViewObject(int inX, int inY, int inWidth, int inHeight) {
		x = inX; y = inY; width = inWidth; height = inHeight;
	}
	
	public void update(int inX, int inY, int inWidth, int inHeight) {
		x = inX; y = inY; width = inWidth; height = inHeight;
	}
	
	public void loadImages(String folderLocation) {
		File dir = new File(folderLocation);
		images = new HashMap<String, ImageIcon>();
		for (File child : dir.listFiles()) {
		    images.put(child.getName(), new ImageIcon(child.getName()));
		}
	}
	
	public void setCurrentImage(String currentImageName) {
		if(currentImageName == null) {
			currentImage = null;
		} else if (images.containsKey(currentImageName)) {
			currentImage = images.get(currentImageName);
		} else {
			System.out.println("Error, could not find image");
		}
	}
	
	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		if(currentImage != null) {
			g2d.drawImage(currentImage.getImage(), x - screenLeft, y - screenTop, null);
		} else {
			g2d.setColor(Color.black);
			g2d.fillRect(x - screenLeft, y - screenTop, width, height);
		}
	}
}
