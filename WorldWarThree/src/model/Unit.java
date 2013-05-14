package model;

public class Unit {
	int moves;
	int strength;
	
	public Unit(int inMoves, int inStrength) {
		moves = inMoves;
		strength = inStrength;
	}
	
	public int getStrength() {
		return strength;
	}
}
