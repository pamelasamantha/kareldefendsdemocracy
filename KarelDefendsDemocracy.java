package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel { 
	
	/* Karel will collect all beepers whenever the middle beeper 
	 * is not present and the path is clear of walls. 
	 * Leaving only the middle beeper Ballots alone.
	 */
	public void run() {
		move(); // Karel moves foward to check first Ballot 
		while (frontIsClear()) {
			checkBallot();
			cleanBallot();
			move(); 
		}
	}
	/*Pre-condition: Karel will check if middle beeper is present 
	 * Post-condition: Karel will move if middle beeper is present 
	 */
		private void checkBallot() {
			if (beepersPresent()) {
				move();
				move();
			}
		}
		/*Pre-condition: Karel will identify that middle beeper is present
		 * and will move foward to clean the Ballot by removing all beepers 
		 * Post-condition: Karel will remove all beepers from both top and bottom
		 * corners 
		 */
		private void cleanBallot() {
			turnRight();
			move();
			collectLineOfBeepers();
			turnAround();
			move();
			move();
			collectLineOfBeepers();
			turnAround();
			move();
			turnLeft();
			move();
		} // Method to have Karel collect all beepers regardless of the amount 
		private void collectLineOfBeepers() {
			while (beepersPresent()) {
				pickBeeper();
				if (frontIsClear()) {
					move();
				}
			}
		}
}
	

