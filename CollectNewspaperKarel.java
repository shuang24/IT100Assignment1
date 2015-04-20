/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 * 
 * @copyright: Steven Huang
 * 
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		moveToDestination();
		pickBeeper();
		backToOriginalPlace();
	}

	/*
	 * pre-condition: Karel is facing east
	 * 
	 * post condition: Karel move to the beeper while facing east
	 */

	private void moveToDestination() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stanford.karel.SuperKarel#turnRight()
	 * 
	 * pre-condition: karel is facing wall.
	 * 
	 * post-condition: Karel is turning 180 Degree
	 */

	// public void turnRight(){
	// turnLeft();
	// turnLeft();
	// turnLeft();
	// }
	//
	/*
	 * Pre-condition: Karel Facing West
	 * 
	 * Post-condition: Karel move back to original place facing east
	 */
	private void backToOriginalPlace() {
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see stanford.karel.SuperKarel#turnAround()
	 * 
	 * pre-condition: Karel facing east
	 * 
	 * Post-Condition: Karel turn 90 Degree facing west
	 */
	// public void turnAround(){
	// turnLeft();
	// turnLeft();
	// }
}
