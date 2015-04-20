/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		repair();
	}

	/*
	 * Method: repair
	 * 
	 * Pre-Condition: Karel facing east
	 * 
	 * Post-condition: Karel will ascend to north put down beeper if he didnt
	 * see any beeper and descend down and move to next column
	 */

	private void repair() {
		turnLeft();
		ascendColumn();
		turnAround();
		descendColumn();
		turnLeft();
		if (frontIsClear()) {
			moveToNextColumn();
			repair();
		}
	}

	/*
	 * Method: ascendColumn
	 * 
	 * Pre-condition: Karel is facing East
	 * 
	 * Post-condition: Karel will put beeper if he dont see any beeper asceding
	 * from bottom
	 */

	private void ascendColumn() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

	/*
	 * Method: descendColumn
	 * 
	 * Pre-condition: Karel facing North and on the top of the world
	 * 
	 * Post-Condition: Karel will move down
	 */

	private void descendColumn() {
		while (frontIsClear()) {
			move();
		}
	}

	/*
	 * method: The logic will repeat 4 times
	 */

	private void moveToNextColumn() {
		for (int i = 0; i < 4; i++) {
			move();
		}
	}
}
