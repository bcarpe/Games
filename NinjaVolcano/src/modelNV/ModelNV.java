package modelNV;

import java.awt.Color;
import java.awt.Font;

import ninjaVolcano.GameState;
import listeners.LandingListener;
import listeners.WallCollisionListener;
import model.Model;
import model.Object;
import model.Platform;
import model.Wall;
import view.View;
import view.ViewDialogBox;

public class ModelNV extends Model implements LandingListener, WallCollisionListener {
	
	View gameView;
	
	public ModelNV(View gameView) {
		super();
		this.gameView = gameView;
	}

	@Override
	public void landingDetected(Platform platform, Object object) {
		if (platform == GameState.victoryPlatform && object == GameState.player) {
			GameState.victory = true;
			ViewDialogBox victoryBox = 
					new ViewDialogBox("Victory!", 200, 100, 400, 100, 
										new Color(128, 0, 0), new Color(255, 128, 0), 
										new Font("sans", Font.PLAIN, 24));
			victoryBox.setTextCentered(true);
			gameView.addDialogBox(victoryBox);
		}
	}

	@Override
	public void wallCollisionDetected(Wall wall, Object object) {
		
	}
}
