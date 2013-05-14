package model;

import java.util.LinkedList;

public class Board {
	private class Bridge {
		
	}
	
	LinkedList<Territory> territories;
	LinkedList<Port> ports;
	LinkedList<Bridge> bridges;
	
	public Board() {
		
	}
	
	public void initBoard() {
		initTerritories();
		initPorts();
		initBridges();
	}
	
	public void initTerritories() {

		territories = new LinkedList<Territory>();
	}
	
	public void initPorts() {

		ports = new LinkedList<Port>();
	}
	
	public void initBridges() {

		bridges = new LinkedList<Bridge>();
	}
}
