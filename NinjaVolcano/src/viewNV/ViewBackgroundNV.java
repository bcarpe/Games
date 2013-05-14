package viewNV;

import java.awt.Graphics2D;
import view.ViewBackground;

public class ViewBackgroundNV extends ViewBackground {
	
	int height = 0;
	
	@Override
	public void draw(Graphics2D g2d, int screenTop, int screenLeft) {
		int bgWidth = background.getWidth(null);
		int bgHeight = background.getHeight(null);
		int screenWidth = g2d.getClipBounds().width;
		int screenHeight = g2d.getClipBounds().height;
		for(int i = 0; i <= screenWidth/bgWidth + 1; i++) {
			for(int j = 0; j <= screenHeight/bgHeight + 1; j++) {
				g2d.drawImage(background, 
								bgWidth*(i - 1) - screenLeft%bgWidth, 
								bgHeight*(j -1) - (screenTop + height)%bgHeight, 
								null);
			}
		}
		height++;
	}
}
