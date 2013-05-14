package model;

public class Capitol extends Territory {
	private class Flag {
		public boolean up;
	}
	
	Flag flag;
	
	public Capitol() {
		initFlag();
	}
	
	private void initFlag() {
		flag = new Flag();
		flag.up = true;
	}
}
