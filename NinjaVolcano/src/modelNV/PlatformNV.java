package modelNV;

import viewNV.ViewPlatformNV;
import model.Platform;

public class PlatformNV extends Platform {
	
	private ViewPlatformNV viewPlatform;
	
	public PlatformNV(int inX, int inY, int inWidth) {
		super(inX, inY, inWidth);
		viewPlatform = new ViewPlatformNV(inX, inY, inWidth);
	}
	
	public final ViewPlatformNV getViewPlatform() {
		return viewPlatform;
	}
}
