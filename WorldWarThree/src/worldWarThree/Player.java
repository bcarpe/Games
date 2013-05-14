package worldWarThree;

import java.util.HashMap;
import java.util.LinkedList;

public class Player {
	LinkedList<model.Unit> army;
	LinkedList<model.Territory> territories;
	HashMap<model.Unit, model.Territory> armyMapping;
	model.Capitol capitol;
	
	public Player() {
		initArmy();
		initTerritories();
		initArmyMapping();
	}
	
	public void initArmy() {
		
	}
	
	public void initTerritories() {
		
	}
	
	public void initArmyMapping() {
		
	}
	
	public void attack(Player targetPlayer, model.Territory targetTerritory, model.Territory attackingTerritory) {
		LinkedList<model.Unit> attackingUnits = selectAttackingUnits(attackingTerritory);
		int attackPower = 0;
		for(model.Unit unit : attackingUnits) {
			attackPower += unit.getStrength();
		}
		LinkedList<model.Unit> targetUnits = selectTargetUnits(targetTerritory, attackPower);
		
	}
	
	private LinkedList<model.Unit> selectAttackingUnits(model.Territory attackingTerritory) {
		LinkedList<model.Unit> attackingUnits = new LinkedList<model.Unit>();
		// selection method
		return attackingUnits;
	}
	
	private LinkedList<model.Unit> selectTargetUnits(model.Territory targetTerritory, int attackPower) {
		LinkedList<model.Unit> targetUnits = new LinkedList<model.Unit>();
		// selection method
		return targetUnits;
	}
}
