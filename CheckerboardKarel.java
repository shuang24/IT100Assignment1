/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * The CheckerboardKarel class should draw a checkered board using 
 * beepers, as described in Assignment 1. Karel will start in
 * the bottom left-corner facing East and will place a beeper on
 * its current location. It will start by going east, and snaking 
 * up the board, placing a beeper on every other square. It should 
 * be able to handle any size grid. 
 * 
 * Steven Huang
 * 17.04.2015
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	/*
	 * METHOD: run()
	 * 
	 * pre-condition:see above
	 * 
	 * post-condition:completed checkerboard with Karel in eitherof the top two
	 * corners (the right side for grids with an oddnumber of rows, the left
	 * side for grids with an odd numberof lines).
	 * 
	 * Note: While this method does eventually complete thecheckerboard, this
	 * bit of code really initializes Karel'smotion starting with the bottom
	 * line.
	 */

	public void run() {
		putBeeper();
		completeFirstLine();
	}

	/*
	 * METHOD: completeFirstLine()
	 * 
	 * pre-condition:Karel is facing East at the left-most square of a new line.
	 * 
	 * post-conditionKarel is either facing West on the next lineup or program
	 * is finished.
	 */

	private void completeFirstLine() {
		moveToWall();
		turnLeft();
		if (frontIsClear()) {
			startNextLine();
			turnLeft();
			completeSecondLine();
		}
	}

	/*
	 * METHOD: completeSecondLine()
	 * 
	 * pre-condition:Karel is facing West on a new line.
	 * 
	 * post-condition:Karel is either facing East on the next line up or program
	 * is finished.
	 */

	private void completeSecondLine() {
		moveToWall();
		turnRight();
		if (frontIsClear()) {
			startNextLine();
			turnRight();
			completeFirstLine();
		}
	}

	/*
	 * METHOD: startNextLine()
	 * 
	 * pre-condition:Karel is at the end of a line facing the next row up and he
	 * may or maynot be presently on a beeper.
	 * 
	 * post-condition:Karel has now moved to the next row up and is still facing
	 * up. Karel has also placed a beeper on his current square if he wasn't on
	 * one before and hasn't placed one if he was on one before.
	 */ 

	private void startNextLine() {
		if (beepersPresent()) {
			move();
		} else {
			move();
			putBeeper();
		}
	}

	/*
	 * METHOD: moveToWall()pre-condition:Karel is either facing East or West at
	 * the beginning of anew line.
	 * 
	 * post-condition:Karel has now traversed the line and has in doing so has
	 * placed beepers on every other square.
	 */

	private void moveToWall() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				move();
				putBeeper();
			}
		}
	}
}