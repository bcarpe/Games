package keyboardController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends controls.Controller implements KeyListener {
	
	public KeyboardController() {	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			if(!upState)
				triggerUp();
			break;
		case KeyEvent.VK_DOWN :
			if(!downState)
				triggerDown();
			break;
		case KeyEvent.VK_LEFT :
			if(!leftState)
				triggerLeft();
			break;
		case KeyEvent.VK_RIGHT :
			if(!rightState)
				triggerRight();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			releaseUp();
			break;
		case KeyEvent.VK_DOWN :
			releaseDown();
			break;
		case KeyEvent.VK_LEFT :
			releaseLeft();
			break;
		case KeyEvent.VK_RIGHT :
			releaseRight();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
